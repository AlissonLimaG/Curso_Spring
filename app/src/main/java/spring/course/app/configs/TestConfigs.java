package spring.course.app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import spring.course.app.entities.Category;
import spring.course.app.entities.Order;
import spring.course.app.entities.Product;
import spring.course.app.entities.User;
import spring.course.app.entities.enums.OrderStatus;
import spring.course.app.repositories.CategoryRepository;
import spring.course.app.repositories.OrderRepository;
import spring.course.app.repositories.ProductRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category c1 = new Category(null,"Electronics");
        Category c2 = new Category(null,"Books");
        Category c3 = new Category(null,"Computers");
        categoryRepository.saveAll(List.of(c1,c2,c3));

        Product p1 = new Product(null, "Smart TV Samsung 50\"", "Tela 4K UHD com inteligência artificial integrada.", 2500.0, "");
        Product p2 = new Product(null, "Fone JBL Tune 750BT", "Fone de ouvido Bluetooth com cancelamento de ruído.", 450.0, "");
        Product p3 = new Product(null, "Clean Code", "Um guia prático de boas práticas de programação.", 120.0, "");
        Product p4 = new Product(null, "O Senhor dos Anéis", "Clássico da literatura de fantasia escrito por J.R.R. Tolkien.", 90.0, "");
        Product p5 = new Product(null, "MacBook Air M2", "Notebook leve e potente com o chip Apple M2.", 8000.0, "");
        Product p6 = new Product(null, "Lenovo IdeaPad 3", "Laptop acessível para tarefas do dia a dia.", 2200.0, "");
        productRepository.saveAll(List.of(p1,p2,p3,p4,p5,p6));

        p1.getCategories().addAll(List.of(c1,c3));
        p2.getCategories().add(c1);
        p3.getCategories().add(c2);
        p4.getCategories().add(c2);
        p5.getCategories().addAll(List.of(c1,c3));
        p6.getCategories().addAll(List.of(c1,c3));
        productRepository.saveAll(List.of(p1,p2,p3,p4,p5,p6));

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
