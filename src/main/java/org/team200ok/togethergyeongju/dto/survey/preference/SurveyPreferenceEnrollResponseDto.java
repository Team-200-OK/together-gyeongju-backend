package org.team200ok.togethergyeongju.dto.survey.preference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.domain.SurveyPreference;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class SurveyPreferenceEnrollResponseDto {
    private Long id;

    private Long surveyId;

    private Long userId;

    private boolean isPreference;

    private LocalDateTime createdAt;

    public static SurveyPreferenceEnrollResponseDto fromDto(SurveyPreferenceEnrollDto dto) {
        return SurveyPreferenceEnrollResponseDto.builder()
                .id(dto.getId())
                .surveyId(dto.getSurveyId())
                .userId(dto.getUserId())
                .isPreference(dto.isPreference())
                .createdAt(dto.getCreatedAt())
                .build();
    }
}
