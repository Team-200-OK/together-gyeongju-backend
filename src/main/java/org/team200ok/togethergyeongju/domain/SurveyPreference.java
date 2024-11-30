package org.team200ok.togethergyeongju.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.team200ok.togethergyeongju.dto.survey.preference.SurveyPreferenceEnrollRequestDto;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@EntityListeners(AuditingEntityListener.class)
public class SurveyPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Survey survey;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private boolean isPreference;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public static SurveyPreference of(Survey foundSurvey, User user, SurveyPreferenceEnrollRequestDto requestDto) {
        return SurveyPreference.builder()
                .survey(foundSurvey)
                .user(user)
                .isPreference(requestDto.isPreference())
                .build();
    }
}
