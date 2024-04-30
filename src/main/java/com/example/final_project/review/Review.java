package com.example.final_project.review;

import com.example.final_project._core.enums.ReviewEnum;
import com.example.final_project.room.Room;
import com.example.final_project.stay.Stay;
import com.example.final_project.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;


@Data
@NoArgsConstructor
@Table(name = "review_tb")
@Entity
@JsonIgnoreProperties({"user", "room"})
public class Review{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 리뷰 번호

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // optional = false를 적어야 Not Null이 된다.
    private User user; // 리뷰 남긴 유저 번호

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Stay stay; // 리뷰한 숙소

    @Column(nullable = false, length = 1000)
    private String content; // 내용

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Review parentReview; // 부모댓글

    // @Column(nullable = false)
    private Integer score; // 평점

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReviewEnum isDelete; // 삭제 여부(FLAWLESS : 문제 없는 댓글, COMPLETE: 삭제 됨, FAIL: 삭제 안 됨)

    @CreationTimestamp
    private LocalDateTime createdAt; // 리뷰 작성 날짜

    @OneToMany(mappedBy = "parent")
    private List<Review> children = new ArrayList<>();
    @Builder
    public Review(Integer id, User user, Stay stay, String content, Review parentReview, Integer score, ReviewEnum isDelete, LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.stay = stay;
        this.content = content;
        this.parentReview = parentReview;
        this.score = score;
        this.isDelete = isDelete;
        this.createdAt = createdAt;
    }

    public Review(User user, Stay stay, String content, Review parentReview,ReviewEnum isDelete) {
        this.user = user;
        this.stay = stay;
        this.content = content;
        this.parentReview = parentReview;
        this.isDelete = isDelete;
    }

    public Optional<Review> findDeletetableReview(){
        return hasChildren() ? Optional.empty() : Optional.of(findDeletetableReviewByParent());

    }

    public void delete(){
        this.isDelete = ReviewEnum.valueOf("COMPLETE");
    }

    private Review findDeletetableReviewByParent(){
        return isDeletableParent() ?  getParentReview().findDeletetableReviewByParent(): this;
    }

    public boolean hasChildren(){
        return getChildren().size()!= 0;
    }

    private boolean isDeletableParent(){
        return getParentReview() != null && getParentReview().isDelete.equals("FLAWLESS") && getParentReview().getChildren().size() == 1;
    }

}