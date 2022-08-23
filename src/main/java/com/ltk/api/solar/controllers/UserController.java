package com.ltk.api.solar.controllers;

import com.ltk.api.solar.models.User;
import com.ltk.api.solar.services.UserService;
import com.ltk.api.solar.tos.user.request.UserRequestTo;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/user")
public class UserController {

    private final UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") String id) {
        Optional<User> optUser = service.findByIdAndActiveIsTrue(id);
        if (optUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("City not found.");
        }
//        UserResponseTo userResponseTo = new UserResponseTo().setValues(optUser.get());
        return ResponseEntity.status(HttpStatus.OK).body(optUser.get());
    }

    @PostMapping()
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserRequestTo userRequestTo) {

//        // custom validations
//        if(service.existsByName(userRequestTo.getName())) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This city already exists!");
//        }

        User user = new User();
        BeanUtils.copyProperties(userRequestTo, user);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody @Valid UserRequestTo userRequestTo) {

//        // custom validations
//        if(service.existsByName(userRequestTo.getName())) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This city already exists!");
//        }

        User user = new User();
        BeanUtils.copyProperties(userRequestTo, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> inactiveById(@PathVariable(value = "id") String id) {

//        if (!service.existsById(id)) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body(optCity.get());
        return ResponseEntity.ok("ok");
    }

}
