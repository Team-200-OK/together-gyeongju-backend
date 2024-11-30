package org.team200ok.togethergyeongju.dto.survey.satisfied;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.constant.PolicyCategory;
import org.team200ok.togethergyeongju.constant.SurveyType;
import org.team200ok.togethergyeongju.domain.Survey;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class SurveySatisfiedCreateResponseDto {
    private Long id;

    private String title;

    private String description;

    private SurveyType surveyType;

    private PolicyCategory policyCategory;

    private List<String> items;

    public static SurveySatisfiedCreateResponseDto from(SurveySatisfiedCreateDto dto) {
        return SurveySatisfiedCreateResponseDto.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .surveyType(dto.getSurveyType())
                .policyCategory(dto.getPolicyCategory())
                .items(dto.getItems())
                .build();
    }
}
