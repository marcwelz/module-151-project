package ch.bbw.mw.projekt.Controller;

import ch.bbw.mw.projekt.model.Article;
import ch.bbw.mw.projekt.model.Order;
import ch.bbw.mw.projekt.model.User;
import ch.bbw.mw.projekt.persistence.ArticlePersistence;
import ch.bbw.mw.projekt.persistence.OrderPersistence;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private static OrderPersistence orderPersistence = new OrderPersistence();

    @GetMapping(value = "/getall/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUser() {
        return orderPersistence.getAllOrders();
    }

    @GetMapping(value = "/add/order")
    public void addUser(@RequestBody Order order) {
        orderPersistence.addOrder(order);
    }
}
