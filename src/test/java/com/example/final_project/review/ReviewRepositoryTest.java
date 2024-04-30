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

        //when

        //then
    }
}

// 테스트 사이트 주소 : https://kukekyakya.tistory.com/554