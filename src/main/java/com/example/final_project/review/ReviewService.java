package com.example.final_project.review;

import com.example.final_project._core.errors.exception.Exception404;

import com.example.final_project.stay.Stay;
import com.example.final_project.stay.StayRepository;
import com.example.final_project.user.User;
import com.example.final_project.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final StayRepository stayRepository;

//    @Transactional
//    public Review save(Integer roomId,ReviewRequest.ReviewReqDTO reqDTO){
//        //1.인증처리
//
//        //  1-1 유저찾기
//        User user = userRepository.findById(reqDTO.getUserId())
//                .orElseThrow(() -> new Exception404("해당 유저를 찾을 수 없습니다."));
//        //  1-2 작성하는 숙소 찾기
//        Stay stay = stayRepository.findById(roomId)
//                .orElseThrow(() -> new Exception404("해당 숙소를 찾을 수 없습니다."));
//
//        Review review = reviewRepository.save(reqDTO.toEntity());
//
//    }
}
