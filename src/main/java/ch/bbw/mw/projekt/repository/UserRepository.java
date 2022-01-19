package ch.bbw.mw.projekt.repository;

import ch.bbw.mw.projekt.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
