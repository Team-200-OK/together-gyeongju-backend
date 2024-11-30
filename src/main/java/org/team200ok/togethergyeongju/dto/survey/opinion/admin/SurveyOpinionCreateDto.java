package org.team200ok.togethergyeongju.dto.survey.opinion.admin;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.team200ok.togethergyeongju.constant.PolicyCategory;
import org.team200ok.togethergyeongju.constant.SurveyType;
import org.team200ok.togethergyeongju.domain.Survey;
import org.team200ok.togethergyeongju.domain.SurveyOpinion;

@Getter
@AllArgsConstructor
@Builder
public class SurveyOpinionCreateDto {
    private Long id;

    private String title;

    private String description;

    private SurveyType surveyType;

    private PolicyCategory policyCategory;

    public static SurveyOpinionCreateDto fromDto(Survey survey) {
        return SurveyOpinionCreateDto.builder()
                .id(survey.getId())
                .title(survey.getTitle())
                .description(survey.getDescription())
                .surveyType(survey.getSurveyType())
                .policyCategory(survey.getPolicyCategory())
                .build();
    }
}
