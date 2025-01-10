package spring.course.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.course.app.entities.Product;
import spring.course.app.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> u = productService.findAll();
        return ResponseEntity.ok().body(u);
    };

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        Product u = productService.findById(id);
        return ResponseEntity.ok().body(u);
    }

}
