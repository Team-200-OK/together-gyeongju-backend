package org.team200ok.togethergyeongju.dto.auth.signup;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.dto.auth.login.LoginDto;
import org.team200ok.togethergyeongju.dto.auth.login.LoginToken;

@Getter
@Builder
@AllArgsConstructor
@Schema(name = "SignupResponse")
public class SignupResponseDto {
    @Schema(description = "응답 메시지", example = "성공적으로 회원가입 하였습니다.")
    private String message;
    @Schema(description = "서비스 토큰 정보")
    private LoginToken token;

    public static SignupResponseDto fromDto(SignupDto dto) {
        return SignupResponseDto.builder()
                .message("성공적으로 회원가입 하였습니다.")
                .token(dto.getToken())
                .build();
    }
}
