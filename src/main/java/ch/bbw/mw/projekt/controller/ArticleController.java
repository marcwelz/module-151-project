package ch.bbw.mw.projekt.controller;

import ch.bbw.mw.projekt.model.Article;
import ch.bbw.mw.projekt.repository.ArticleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@Transactional
public class ArticleController {

    private final String urlClassname = "/article";
    private ArticleRepository repository;

    public ArticleController(ArticleRepository articleRepository) {
        this.repository = articleRepository;
    }

    @GetMapping(value = urlClassname + "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Article> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = urlClassname + "/get/byId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Article> getById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping(value = urlClassname + "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody Article entity) {
        repository.save(entity);
    }

    @GetMapping(value = urlClassname + "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody Article entity) {
        repository.delete(entity);
    }

    @PostMapping(value = urlClassname + "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Article update(Article article) throws Exception {
        Integer id = article.getArticleid();
        Article oldArticle = repository.findById(id).orElseThrow(() -> new Exception("Not found for this id: " + id));

        oldArticle.setDescription(article.getDescription());
        oldArticle.setPrice(article.getPrice());
        oldArticle.setTitle(article.getTitle());

        return repository.save(oldArticle);
    }
}
