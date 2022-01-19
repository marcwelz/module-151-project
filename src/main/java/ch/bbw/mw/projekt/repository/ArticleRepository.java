package ch.bbw.mw.projekt.repository;

import ch.bbw.mw.projekt.model.Article;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
}
