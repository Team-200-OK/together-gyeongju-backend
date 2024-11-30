package org.team200ok.togethergyeongju.dto.auth.signup;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.team200ok.togethergyeongju.constant.Gender;
import org.team200ok.togethergyeongju.constant.JobCategory;
import org.team200ok.togethergyeongju.constant.SnsType;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SignupRequestDto {
    @Schema(example = "Kakao", description = "토큰 발행 기관")
    @NotNull(message = "소셜 계정의 타입이 필요합니다.")
    private SnsType snsType;

    @Schema(example = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIy...", description = "토큰 발행 기관에서 받은 AccessToken")
    @NotNull(message = "accessToken이 필요합니다.")
    private String accessToken;

    @Schema(example = "10", description = "회원 나이")
    @Min(value = 1, message = "나이는 한살 이상이어야 합니다.")
    @Max(value = 200, message = "나이는 200살 이하이어야 합니다.")
    @NotNull(message = "나이가 필요합니다.")
    private int age;

    @Schema(example = "MALE", description = "회원 성별")
    @NotNull(message = "성별이 필요합니다.")
    private Gender gender;

    @Schema(example = "INOCCUPATION", description = "회원 직종")
    @NotNull(message = "회원 직종이 필요합니다.")
    private JobCategory jobCategory;
}
