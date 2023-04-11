package com.vishal.User.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishal.User.Entity.User;
import com.vishal.User.Repo.UserRepo;
import com.vishal.User.Service.UserService;
import com.vishal.User.payload.ApiResponse;

@RestController
@RequestMapping("/users")
public class controller {

    @Autowired
    public UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){

        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }


    @GetMapping("/{Uid}")
    public ResponseEntity<User> getUser(@PathVariable Integer Uid){
        return new ResponseEntity<>(userService.getUser(Uid),HttpStatus.ACCEPTED);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully "+id,true,HttpStatus.ACCEPTED),HttpStatus.ACCEPTED);
    }
    
}
