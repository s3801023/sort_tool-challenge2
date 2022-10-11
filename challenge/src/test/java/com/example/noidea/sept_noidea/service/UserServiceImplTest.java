package com.example.noidea.sept_noidea.service;

import com.example.noidea.sept_noidea.dao.UserDao;
import com.example.noidea.sept_noidea.dao.UserNewDao;
import com.example.noidea.sept_noidea.model.User;
import com.example.noidea.sept_noidea.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Autowired
    private MockMvc mvc;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl service;
    @Test
    void getUser() {
        UserDao user = new UserDao();
        user.setUserid(1);
        user.setUsername("abc");
        user.setEmail("123@134");
        user.setMobile("1111111111");
        user.setPassword("123");
        user.setDeleteFlag(0);
        user.setAge(15); ;
        assertEquals(user,service.getUser(1));
    }

    @Test
    void getAllUser() {
        when(userRepository.findAll()).thenReturn(Stream.of(new User(1,"abc","123",15,"123@134","1111111111",0),new User(2,"abcd","1234",73,"1253@134","1311111111",0)).collect(Collectors.toList()));
        assertNotNull(userRepository);
        assertEquals(2,service.getAllUser().size());
    }

    @Test
    void addUser() {
        User user = new User(1,"abc","123",15,"123@134","1111111111",0);
        UserDao user1 = new UserDao();
        user1.setUserid(1);
        user1.setUsername("abc");
        user1.setEmail("123@134");
        user1.setMobile("1111111111");
        user1.setPassword("123");
        user1.setDeleteFlag(0);
        user1.setAge(1);
        System.out.println(user1);
        UserNewDao user2 = service.addUser(user1);
        assertNotNull(user2);
        assertThat(user2.getUsername()).isEqualTo("abc");
    }
}