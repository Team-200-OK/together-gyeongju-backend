package org.team200ok.togethergyeongju.dto.policy.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PolicyScrapResponseDto {

    @Schema(description = "응답 메시지", example = "정책을 스크랩하였습니다!")
    private String message;

    public static PolicyScrapResponseDto createNewResponse(String responseMessage) {
        return PolicyScrapResponseDto.builder()
                .message(responseMessage)
                .build();
    }
}
