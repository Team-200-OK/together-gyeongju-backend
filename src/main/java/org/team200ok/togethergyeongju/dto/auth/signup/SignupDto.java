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
public class SignupDto {
    private LoginToken token;

    public static SignupDto of(String accessToken, String refreshToken) {
        return SignupDto.builder()
                .token(LoginToken.of(accessToken, refreshToken))
                .build();
    }
}
