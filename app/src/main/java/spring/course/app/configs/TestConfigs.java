package spring.course.app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import spring.course.app.entities.User;
import spring.course.app.repositories.UserRepository;

import java.util.List;

@Configuration
@Profile("test")
public class TestConfigs implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Maria Brown", "m@b.com", "1234", "98765-1234");
        User user2 = new User(null, "Alex Green", "a@g.com", "1234", "98765-1234");
        User user3 = new User(null, "Bob Grey", "b@g.com", "1234", "98765-1234");
        userRepository.saveAll(List.of(user1, user2, user3));
    }
}