package com.example.noidea.sept_noidea.controller;

import com.example.noidea.sept_noidea.dao.UserDao;
import com.example.noidea.sept_noidea.dao.UserNewDao;
import com.example.noidea.sept_noidea.model.User;
import com.example.noidea.sept_noidea.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class controller {
    @Autowired
    private UserServiceImpl userDao;
    //create
    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody UserDao user){
        userDao.addUser(user);
        return ResponseEntity.ok("Created!");
    }
    //get all person
    @GetMapping("/all_person")
    public ResponseEntity<Object> getAllUsers() {
        List<UserDao> userList = userDao.getAllUser();
        return ResponseEntity.ok().header("OK!").body(userList);
    }
    //get by id
    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Object> getUserbyId(@PathVariable("id") int id){
        UserDao user = userDao.getUser(id);
        return ResponseEntity.ok().body(user);
    }
    //update
    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Object> updateUser(@PathVariable(name = "id") int id, @RequestBody User updateUser){
        UserDao user = userDao.getUser(id);
        user.setEmail(updateUser.getEmail());
        user.setMobile(updateUser.getMobile());
        user.setPassword(updateUser.getPassword());
        user.setUsername(updateUser.getUsername());
        user.setAge(updateUser.getAge());
        user.setDeleteFlag(updateUser.getDeleteFlag());

        UserNewDao updatedEmployee = userDao.addUser(user);
        return ResponseEntity.ok("Updated!");
    }


    //delete
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteUser(@PathVariable int id){
        UserDao user= userDao.getUser(id);
        user.setDeleteFlag(1);
        UserNewDao updated = userDao.addUser(user);
        return ResponseEntity.ok("Deleted");
    }



}
