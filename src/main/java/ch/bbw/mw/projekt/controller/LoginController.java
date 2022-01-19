package ch.bbw.mw.projekt.controller;

import ch.bbw.mw.projekt.model.Login;
import ch.bbw.mw.projekt.repository.LoginRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@Transactional
public class LoginController {

    private final String urlClassname = "/login";
    private final LoginRepository repository;

    public LoginController(LoginRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = urlClassname + "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Login> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = urlClassname + "/get/byId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Login> getById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping(value = urlClassname + "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody Login entity) {
        repository.save(entity);
    }

    @GetMapping(value = urlClassname + "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody Login entity) {
        repository.delete(entity);
    }

    @PostMapping(value = urlClassname + "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Login update(Login login) throws Exception {
        Integer id = login.getUseridfs();
        Login oldLogin = repository.findById(id).orElseThrow(() -> new Exception("Not found for this id: " + id));

        oldLogin.setUseridfs(login.getUseridfs());
        oldLogin.setAdmin(login.isAdmin());
        oldLogin.setEmail(login.getEmail());
        oldLogin.setPassword(login.getPassword());
        oldLogin.setToken(login.getToken());

        return repository.save(oldLogin);
    }
}
