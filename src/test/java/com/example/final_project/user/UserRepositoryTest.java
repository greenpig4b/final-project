package com.example.final_project.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;


    @Test
    public void findbyId_test(){
        //given
        Integer userId = 1;
        //when
        Optional<User> user = userRepository.findById(userId);
        //then
        System.out.println(user);
    }
}
