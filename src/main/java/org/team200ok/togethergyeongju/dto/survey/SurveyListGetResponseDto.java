package org.team200ok.togethergyeongju.dto.survey;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.constant.PolicyCategory;
import org.team200ok.togethergyeongju.constant.SurveyType;
import org.team200ok.togethergyeongju.domain.Survey;
import org.team200ok.togethergyeongju.domain.SurveySatisfied;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class SurveyListGetResponseDto {
    List<SurveyElementDto> surveys;

    public static SurveyListGetResponseDto from(SurveyListGetDto dto) {
        return SurveyListGetResponseDto.builder()
                .surveys(dto.getSurveys())
                .build();
    }
}
