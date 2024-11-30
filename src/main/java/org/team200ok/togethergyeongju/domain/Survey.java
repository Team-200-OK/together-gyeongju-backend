package org.team200ok.togethergyeongju.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.team200ok.togethergyeongju.constant.PolicyCategory;
import org.team200ok.togethergyeongju.constant.SurveyType;
import org.team200ok.togethergyeongju.dto.survey.opinion.admin.SurveyOpinionCreateRequestDto;
import org.team200ok.togethergyeongju.dto.survey.preference.SurveyPreferenceCreateRequestDto;
import org.team200ok.togethergyeongju.dto.survey.satisfied.SurveySatisfiedCreateRequestDto;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private PolicyCategory policyCategory;

    @Column(nullable = false)
    private SurveyType surveyType;

    @CreatedDate
    private LocalDateTime createdAt;

    public static Survey createSurveyOpinion(SurveyOpinionCreateRequestDto requestDto) {
        return Survey.builder()
                .title(requestDto.getTitle())
                .description(requestDto.getDescription())
                .surveyType(SurveyType.SURVEY_OPINION)
                .policyCategory(requestDto.getPolicyCategory())
                .build();
    }

    public static Survey createSurveyPreference(SurveyPreferenceCreateRequestDto requestDto) {
        return Survey.builder()
                .title(requestDto.getTitle())
                .description(requestDto.getDescription())
                .surveyType(SurveyType.SURVEY_PREFERENCE)
                .policyCategory(requestDto.getPolicyCategory())
                .build();
    }

    public static Survey createSurveySatisfied(SurveySatisfiedCreateRequestDto requestDto) {
        return Survey.builder()
                .title(requestDto.getTitle())
                .description(requestDto.getDescription())
                .surveyType(SurveyType.SURVEY_SATISFIED)
                .policyCategory(requestDto.getPolicyCategory())
                .build();
    }
}
