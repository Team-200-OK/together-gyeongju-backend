package org.team200ok.togethergyeongju.dto.suggestion.save;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.constant.PolicyCategory;

@Getter
@AllArgsConstructor
@Builder
@Schema(name = "SuggestionSaveResponse")
public class SuggestionSaveResponseDto {

    @Schema(description = "응답 메시지", example = "제안할 정책이 성공적으로 제출되었습니다.")
    private String message;

    @Schema(description = "제출된 제안 정책의 고유번호", example = "1")
    private Long id;

    @Schema(description = "제출된 제안 정책의 제목", example = "경주시 정책을 파악하기 너무 어려워요")
    private String title;

    @Schema(description = "제출된 제안 정책의 카테고리", example = "WELFARE")
    private PolicyCategory policyCategory;

    @Schema(description = "제출된 제안 정책의 본문", example = "저는 경주시에 있는 한 대학교에 재학중인 학생입니다. 이번에 이하 생략...")
    private String description;

    public static SuggestionSaveResponseDto fromDto(SuggestionSaveDto dto){
        return SuggestionSaveResponseDto.builder()
                .message("제안할 정책이 성공적으로 제출되었습니다.")
                .id(dto.getId())
                .title(dto.getTitle())
                .policyCategory(dto.getPolicyCategory())
                .description(dto.getDescription())
                .build();
    }
}
