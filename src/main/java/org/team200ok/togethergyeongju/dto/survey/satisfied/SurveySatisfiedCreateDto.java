package org.team200ok.togethergyeongju.dto.survey.satisfied;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.constant.PolicyCategory;
import org.team200ok.togethergyeongju.constant.SurveyType;
import org.team200ok.togethergyeongju.domain.Survey;
import org.team200ok.togethergyeongju.domain.SurveyPreference;
import org.team200ok.togethergyeongju.domain.SurveySatisfied;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@Builder
public class SurveySatisfiedCreateDto {
    private Long id;

    private String title;

    private String description;

    private SurveyType surveyType;

    private PolicyCategory policyCategory;

    private List<String> items;

    public static SurveySatisfiedCreateDto from(List<SurveySatisfied> surveySatisfieds) {
        return SurveySatisfiedCreateDto.builder()
                .id(surveySatisfieds.get(0).getId())
                .title(surveySatisfieds.get(0).getSurvey().getTitle())
                .description(surveySatisfieds.get(0).getSurvey().getDescription())
                .surveyType(surveySatisfieds.get(0).getSurvey().getSurveyType())
                .policyCategory(surveySatisfieds.get(0).getSurvey().getPolicyCategory())
                .items(surveySatisfieds.stream().map(SurveySatisfied::getItem).collect(Collectors.toList()))
                .build();
    }
}
