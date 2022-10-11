package com.example.noidea.sept_noidea.repository;

import com.example.noidea.sept_noidea.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    void findAll() {
        User user = new User(1,"abc","123",1,"123@134","1111111111",0);
        userRepository.save(user);


        Iterable<User> list = userRepository.findAll();

        assertNotNull(list);
        assertThat(list).isNotNull();

    }
}