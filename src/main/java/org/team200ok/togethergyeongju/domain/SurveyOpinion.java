package org.team200ok.togethergyeongju.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.team200ok.togethergyeongju.dto.survey.opinion.SurveyOpinionEnrollRequestDto;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@EntityListeners(AuditingEntityListener.class)
public class SurveyOpinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Survey survey;

    @ManyToOne
    private User user;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String opinion;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;


    public static SurveyOpinion of(Survey survey, User user, SurveyOpinionEnrollRequestDto requestDto) {
        return SurveyOpinion.builder()
                .survey(survey)
                .user(user)
                .opinion(requestDto.getOpinion())
                .build();
    }
}
