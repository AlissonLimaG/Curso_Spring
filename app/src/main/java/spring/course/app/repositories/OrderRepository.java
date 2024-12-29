package spring.course.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.course.app.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> { }
