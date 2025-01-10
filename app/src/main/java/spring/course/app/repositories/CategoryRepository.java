package spring.course.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.course.app.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> { }
