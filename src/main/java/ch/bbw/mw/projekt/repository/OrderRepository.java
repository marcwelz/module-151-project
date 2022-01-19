package ch.bbw.mw.projekt.repository;

import ch.bbw.mw.projekt.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
