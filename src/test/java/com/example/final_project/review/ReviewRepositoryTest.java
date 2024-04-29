package com.example.final_project.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ReviewRepositoryTest {

    @Autowired
    ReviewRepository reviewRepository;


    @Test
    public void findById_test(){
        //given
        Integer userId = 1;
        //when

        //then
    }
}
