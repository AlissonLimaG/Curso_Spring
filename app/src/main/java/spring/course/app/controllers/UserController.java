package spring.course.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.course.app.entities.User;
import spring.course.app.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers(){
        List<User> u = userService.findAll();
        return ResponseEntity.ok().body(u);
    };

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        User u = userService.findById(id);
        return ResponseEntity.ok().body(u);
    }

}
