package org.team200ok.togethergyeongju.dto.survey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class SurveyListGetDto {
    List<SurveyElementDto> surveys;

    public static SurveyListGetDto fromDto(List<SurveyElementDto> surveys) {
        return SurveyListGetDto.builder()
                .surveys(surveys)
                .build();
    }
}
