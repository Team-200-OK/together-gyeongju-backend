package org.team200ok.togethergyeongju.dto.survey.satisfied;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.team200ok.togethergyeongju.constant.PolicyCategory;
import org.team200ok.togethergyeongju.constant.SurveyType;

import java.util.List;

@Getter
@Setter
public class SurveySatisfiedCreateRequestDto {
    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "본문을 입력해주세요.")
    @Size(min = 1, max = 500, message = "500글자 이내로 본문을 입력해주세요")
    private String description;

    @NotNull(message = "정책 카테고리를 지정해주세요")
    private PolicyCategory policyCategory;

    @NotNull(message = "설문 항목을 입력하세요.")
    private List<String> items;
}
