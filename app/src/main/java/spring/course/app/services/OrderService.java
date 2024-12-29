package spring.course.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.course.app.entities.Order;
import spring.course.app.entities.User;
import spring.course.app.repositories.OrderRepository;
import spring.course.app.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> o = orderRepository.findById(id);
        return o.orElseThrow(()-> new RuntimeException("User not Found"));
    }

}
