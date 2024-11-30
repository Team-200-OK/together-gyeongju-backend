package org.team200ok.togethergyeongju.dto.survey.opinion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.domain.Survey;
import org.team200ok.togethergyeongju.domain.User;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class SurveyOpinionEnrollResponseDto {
    private Long id;

    private Long surveyId;

    private Long userId;

    private String opinion;

    private LocalDateTime createdAt;

    public static SurveyOpinionEnrollResponseDto fromDto(SurveyOpinionEnrollDto dto) {
        return SurveyOpinionEnrollResponseDto.builder()
                .id(dto.getId())
                .surveyId(dto.getSurveyId())
                .userId(dto.getUserId())
                .opinion(dto.getOpinion())
                .createdAt(dto.getCreatedAt())
                .build();
    }
}
