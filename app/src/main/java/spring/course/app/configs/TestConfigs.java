package spring.course.app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import spring.course.app.entities.Order;
import spring.course.app.entities.User;
import spring.course.app.entities.enums.OrderStatus;
import spring.course.app.repositories.OrderRepository;
import spring.course.app.repositories.UserRepository;

import java.time.Instant;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfigs implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Maria Brown", "m@b.com", "1234", "98765-1234");
        User user2 = new User(null, "Alex Green", "a@g.com", "1234", "98765-1234");
        User user3 = new User(null, "Bob Grey", "b@g.com", "1234", "98765-1234");
        userRepository.saveAll(List.of(user1, user2, user3));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,user1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT,user2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,user1);
        orderRepository.saveAll(List.of(o1, o2, o3));
    }
}
