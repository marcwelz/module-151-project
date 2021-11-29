package ch.bbw.mw.projekt.Controller;

import ch.bbw.mw.projekt.model.Login;
import ch.bbw.mw.projekt.model.User;
import ch.bbw.mw.projekt.persistence.LoginPersistence;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    private static LoginPersistence loginPersistence = new LoginPersistence();

    @GetMapping(value = "/getall/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUser() {
        return loginPersistence.getAllLogins();
    }

    @GetMapping(value = "/add/login")
    public void addUser(@RequestBody Login login) {
        loginPersistence.addLogin(login);
    }
}
