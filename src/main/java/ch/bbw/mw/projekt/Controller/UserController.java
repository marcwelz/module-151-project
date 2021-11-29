package ch.bbw.mw.projekt.Controller;


import ch.bbw.mw.projekt.model.User;
import ch.bbw.mw.projekt.persistence.UserPersistence;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    UserPersistence userRepositoryMock = new UserPersistence();

    @GetMapping(value = "/getall/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUser() {
        return userRepositoryMock.getAllUser();
    }

    @GetMapping(value = "/add/user")
    public void addUser(@RequestBody User user) {
       userRepositoryMock.addUser(user);
    }
}
