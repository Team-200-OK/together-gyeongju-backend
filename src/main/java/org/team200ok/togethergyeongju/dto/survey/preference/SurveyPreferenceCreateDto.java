package org.team200ok.togethergyeongju.dto.survey.preference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.constant.PolicyCategory;
import org.team200ok.togethergyeongju.constant.SurveyType;
import org.team200ok.togethergyeongju.domain.Survey;
import org.team200ok.togethergyeongju.domain.SurveyPreference;
import org.team200ok.togethergyeongju.dto.survey.opinion.admin.SurveyOpinionCreateDto;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class SurveyPreferenceCreateDto {
    private Long id;

    private String title;

    private String description;

    private SurveyType surveyType;

    private PolicyCategory policyCategory;

    public static SurveyPreferenceCreateDto fromEntity(Survey survey) {
        return SurveyPreferenceCreateDto.builder()
                .id(survey.getId())
                .title(survey.getTitle())
                .description(survey.getDescription())
                .surveyType(survey.getSurveyType())
                .policyCategory(survey.getPolicyCategory())
                .build();
    }

}
