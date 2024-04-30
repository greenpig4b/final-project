package com.example.final_project.review;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ReviewRequest {

    @Data
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public class ReviewReqDTO{
        private Integer userId;
        private Integer parentId;
        private String content;

        public ReviewReqDTO(String content) {
            this.content = content;
        }

        public Review toEntity(){
            return Review.builder()
                    .id(this.userId)

                    .build();
        }
    }
}
