package org.team200ok.togethergyeongju.dto.survey.preference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.domain.SurveyPreference;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class SurveyPreferenceEnrollDto {
    private Long id;

    private Long surveyId;

    private Long userId;

    private boolean isPreference;

    private LocalDateTime createdAt;

    public static SurveyPreferenceEnrollDto of(SurveyPreference surveyPreference) {
        return SurveyPreferenceEnrollDto.builder()
                .id(surveyPreference.getId())
                .surveyId(surveyPreference.getSurvey().getId())
                .userId(surveyPreference.getUser().getId())
                .isPreference(surveyPreference.isPreference())
                .createdAt(surveyPreference.getCreatedAt())
                .build();
    }
}
