package org.team200ok.togethergyeongju.dto.survey.opinion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.domain.SurveyOpinion;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class SurveyOpinionEnrollDto {
    private Long id;

    private Long surveyId;

    private Long userId;

    private String opinion;

    private LocalDateTime createdAt;

    public static SurveyOpinionEnrollDto of(SurveyOpinion surveyOpinion) {
        return SurveyOpinionEnrollDto.builder()
                .id(surveyOpinion.getId())
                .surveyId(surveyOpinion.getSurvey().getId())
                .userId(surveyOpinion.getUser().getId())
                .opinion(surveyOpinion.getOpinion())
                .createdAt(surveyOpinion.getCreatedAt())
                .build();
    }
}
