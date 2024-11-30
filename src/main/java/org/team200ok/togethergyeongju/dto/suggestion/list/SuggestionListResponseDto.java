package org.team200ok.togethergyeongju.dto.suggestion.list;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
@Schema(name = "SuggestionListResponse")
public class SuggestionListResponseDto {

    @Schema(description = "응답 메시지", example = "성공적으로 제안된 정책 리스트를 불러왔습니다.")
    private String message;

    @Schema(description = "제안된 정책 정보 리스트")
    private List<SuggestionListDto> suggestions;

    public static SuggestionListResponseDto fromDto(List<SuggestionListDto> suggestions) {
        return SuggestionListResponseDto.builder()
                .message("제안된 정책 리스트를 성공적으로 불러왔습니다.")
                .suggestions(suggestions)
                .build();
    }
}
