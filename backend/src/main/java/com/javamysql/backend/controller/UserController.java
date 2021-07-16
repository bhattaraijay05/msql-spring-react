package com.javamysql.backend.controller;

import java.util.List;
import java.util.Optional;

import com.javamysql.backend.model.User;
import com.javamysql.backend.repository.PlanRepo;
import com.javamysql.backend.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserRepo userRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/all/{id}")
    public List<User> findUsers(@PathVariable("id") int id) {
        return userRepository.findByPlanId(id);
    }

    @PostMapping(path = "/add", consumes = { "application/json" }, produces = "application/json") // Map ONLY POST
                                                                                                  // Requests
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        User _user = userRepository.save(user);
        return new ResponseEntity<>(_user, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") int id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> updateTutorial(@PathVariable("id") int id, @RequestBody User tutorial) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setName(tutorial.getName());
            _user.setEmail(tutorial.getEmail());
            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}