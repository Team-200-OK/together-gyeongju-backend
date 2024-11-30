package org.team200ok.togethergyeongju.dto.auth.oauth.userInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.constant.SnsType;
import org.team200ok.togethergyeongju.dto.auth.oauth.kakao.KakaoUserInfoResponse;
import org.team200ok.togethergyeongju.dto.auth.oauth.naver.NaverUserInfoResponse;

@Getter
@AllArgsConstructor
@Builder
public class OAuthUserInfoDto {
    private String snsId;
    private SnsType snsType;
    private String name;
    private String email;

    // TODO: 카카오 검수 완료 후 회원가입 시 이메일 정보도 저장하도록 구현 필요
    public static OAuthUserInfoDto from(KakaoUserInfoResponse kakaoResponse) {
        return OAuthUserInfoDto.builder()
                .snsId(String.valueOf(kakaoResponse.getId()))
                .snsType(SnsType.Kakao)
                .name(kakaoResponse.getKakaoAccount().getProfile().getNickname())
                .email(null)
                .build();
    }

    public static OAuthUserInfoDto from(NaverUserInfoResponse naverResponse) {
        return OAuthUserInfoDto.builder()
                .snsId(naverResponse.getResponseDetails().getId())
                .snsType(SnsType.Naver)
                .name(naverResponse.getResponseDetails().getName())
                .email(naverResponse.getResponseDetails().getEmail())
                .build();
    }

    public static OAuthUserInfoDto of(String snsId, SnsType snsType, String name, String email) {
        return OAuthUserInfoDto.builder()
                .snsId(snsId)
                .snsType(snsType)
                .name(name)
                .email(email)
                .build();
    }
}
