package com.example.noidea.sept_noidea.service;


import com.example.noidea.sept_noidea.dao.UserDao;
import com.example.noidea.sept_noidea.dao.UserNewDao;
import com.example.noidea.sept_noidea.model.User;
import com.example.noidea.sept_noidea.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository ur;
    private List<User> userList;

    @Override
    public UserDao getUser(int id){

        Optional<User> userOpt = ur.findById(id);
        if (userOpt.isEmpty()) {
            throw new ResourceNotFoundException("user not found");
        }
        User user = userOpt.get();

        UserDao userDao = new UserDao();
        userDao.setUserid(user.getUserid());
        userDao.setUsername(user.getUsername());
        userDao.setPassword(user.getPassword());
        userDao.setAge(user.getAge());
        userDao.setEmail(user.getEmail());
        userDao.setMobile(user.getMobile());
        userDao.setDeleteFlag(user.getDeleteFlag());
        return userDao;

    }
    @Override
    public List<UserDao> getAllUser() {
        List<User> userPage = (List<User>) ur.findAll();

        List<UserDao> userDaoList = new ArrayList<>();

        if (!userPage.isEmpty()) {

            userPage.forEach(user -> {
                UserDao userDao = new UserDao();
                userDao.setUserid(user.getUserid());
                userDao.setUsername(user.getUsername());
                userDao.setPassword(user.getPassword());
                userDao.setEmail(user.getEmail());
                userDao.setAge(user.getAge());
                userDao.setMobile(user.getMobile());
                userDao.setDeleteFlag(user.getDeleteFlag());

                userDaoList.add(userDao);
            });

        }
        return userDaoList;
    }

    @Override
    public UserNewDao addUser(UserDao u) {
        User user = new User();
        user.setUserid(u.getUserid());
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());
        user.setAge(u.getAge());
        user.setEmail(u.getEmail());
        user.setMobile(u.getMobile());
        user.setDeleteFlag(u.getDeleteFlag());
        user = ur.save(user);
        UserNewDao ud = new UserNewDao();
        ud.setUserid(u.getUserid());
        ud.setUsername(u.getUsername());
        ud.setPassword(u.getPassword());
        ud.setAge(u.getAge());
        ud.setEmail(u.getEmail());
        ud.setMobile(u.getMobile());
        ud.setDeleteFlag(u.getDeleteFlag());
        return ud;
    }

}
