package org.team200ok.togethergyeongju.dto.survey.preference;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurveyPreferenceEnrollRequestDto {
    @NotNull(message = "선호여부를 입력해주세요")
    private boolean isPreference;
}
