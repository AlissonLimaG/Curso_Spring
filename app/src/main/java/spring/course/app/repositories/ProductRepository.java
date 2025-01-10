package spring.course.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.course.app.entities.Product;
import spring.course.app.entities.User;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> { }
