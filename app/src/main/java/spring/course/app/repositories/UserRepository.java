package spring.course.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.course.app.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> { }
