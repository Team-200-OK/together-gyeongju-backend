package org.team200ok.togethergyeongju.dto.auth.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class LoginDto {
    private LoginToken token;

    public static LoginDto of(String accessToken, String refreshToken) {
        return LoginDto.builder()
                .token(LoginToken.of(accessToken, refreshToken))
                .build();
    }
}
