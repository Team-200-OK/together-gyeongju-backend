package org.team200ok.togethergyeongju.dto.suggestion.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "SuggestionLikeToggleResponse")
public class SuggestionLikeToggleResponseDto {

    @Schema(description = "응답 메시지", example = "제안된 정책에 좋아요를 누르셨습니다!")
    private String message;

    public static SuggestionLikeToggleResponseDto createNewResponse(String responseMessage){
        return SuggestionLikeToggleResponseDto.builder()
                .message(responseMessage)
                .build();
    }

}
