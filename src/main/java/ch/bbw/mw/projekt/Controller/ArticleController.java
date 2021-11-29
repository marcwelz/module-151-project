package ch.bbw.mw.projekt.Controller;

import ch.bbw.mw.projekt.model.Article;
import ch.bbw.mw.projekt.model.Login;
import ch.bbw.mw.projekt.model.User;
import ch.bbw.mw.projekt.persistence.ArticlePersistence;
import ch.bbw.mw.projekt.persistence.LoginPersistence;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {

    private static ArticlePersistence articleController = new ArticlePersistence();

    @GetMapping(value = "/getall/article", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUser() {
        return articleController.getAllArticle();
    }

    @GetMapping(value = "/add/article")
    public void addUser(@RequestBody Article article) {
        articleController.addArticle(article);
    }
}
