package ch.bbw.mw.projekt.repository;

import ch.bbw.mw.projekt.model.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<Login, Integer> {
}