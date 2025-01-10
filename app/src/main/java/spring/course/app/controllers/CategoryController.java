package spring.course.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.course.app.entities.Category;
import spring.course.app.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/")
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> u = categoryService.findAll();
        return ResponseEntity.ok().body(u);
    };

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") Long id){
        Category u = categoryService.findById(id);
        return ResponseEntity.ok().body(u);
    }

}
