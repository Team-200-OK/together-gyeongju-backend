package org.team200ok.togethergyeongju.dto.survey.preference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.constant.PolicyCategory;
import org.team200ok.togethergyeongju.constant.SurveyType;
import org.team200ok.togethergyeongju.domain.Survey;

@Getter
@AllArgsConstructor
@Builder
public class SurveyPreferenceCreateResponseDto {
    private Long id;

    private String title;

    private String description;

    private SurveyType surveyType;

    private PolicyCategory policyCategory;

    public static SurveyPreferenceCreateResponseDto fromDto(SurveyPreferenceCreateDto dto) {
        return SurveyPreferenceCreateResponseDto.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .surveyType(dto.getSurveyType())
                .policyCategory(dto.getPolicyCategory())
                .build();
    }
}
