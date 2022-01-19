package ch.bbw.mw.projekt.controller;

import ch.bbw.mw.projekt.model.User;
import ch.bbw.mw.projekt.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@Transactional
public class UserController {

    private final String urlClassname = "/user";
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = urlClassname + "/getall/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = urlClassname + "/get/userbyId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<User> getById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping(value = urlClassname + "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody User entity) {
        repository.save(entity);
    }

    @DeleteMapping(value = urlClassname + "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody User entity) {
        repository.delete(entity);
    }

    @PostMapping(value = urlClassname + "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User update(User user) throws Exception {
        Integer id = user.getUserid();
        User oldUser = repository.findById(id).orElseThrow(() -> new Exception("Not found for this id: " + id));

        oldUser.setUsername(user.getUsername());
        oldUser.setAdress(user.getAdress());
        oldUser.setPhone(user.getPhone());

        return repository.save(oldUser);
    }
}
