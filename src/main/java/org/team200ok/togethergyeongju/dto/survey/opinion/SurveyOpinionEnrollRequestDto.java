package org.team200ok.togethergyeongju.dto.survey.opinion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurveyOpinionEnrollRequestDto {
    @NotBlank
    @Size(min = 1, max = 500, message = "500글자 이내로 의견을 입력해주세요")
    private String opinion;
}
