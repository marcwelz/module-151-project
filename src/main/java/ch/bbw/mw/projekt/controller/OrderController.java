package ch.bbw.mw.projekt.controller;

import ch.bbw.mw.projekt.model.Order;
import ch.bbw.mw.projekt.repository.OrderRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@Transactional
public class OrderController {

    private final String urlClassname = "/order";
    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = urlClassname + "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Order> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = urlClassname + "/get/byid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Order> getById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping(value = urlClassname + "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody Order entity) {
        repository.save(entity);
    }

    @GetMapping(value = urlClassname + "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody Order entity) {
        repository.delete(entity);
    }

    @PostMapping(value = urlClassname + "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order update(Order order) throws Exception {
        Integer id = order.getId();
        Order oldOrder = repository.findById(id).orElseThrow(() -> new Exception("Not found for this id: " + id));

        oldOrder.setArticleidfs(order.getArticleidfs());
        oldOrder.setUserIdfs(order.getUserIdfs());
        oldOrder.setOrdertime(order.getOrdertime());
        oldOrder.setTotaleprice(order.getTotaleprice());

        return repository.save(oldOrder);
    }
}
