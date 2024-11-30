package org.team200ok.togethergyeongju.dto.suggestion.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.constant.PolicyCategory;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@Schema(name = "SuggestionDetailResponse")
public class SuggestionDetailResponseDto {

    @Schema(description = "응답 메시지", example = "제안 정책 상세 정보를 성공적으로 불러왔습니다.")
    private String message;

    @Schema(description = "제출된 제안 정책의 고유번호", example = "1")
    private Long id;

    @Schema(description = "제출된 제안 정책의 고유번호", example = "1")
    private String creatorName;

    @Schema(description = "제출된 제안 정책의 제목", example = "경주시 정책을 파악하기 너무 어려워요")
    private String title;

    @Schema(description = "제출된 제안 정책의 카테고리", example = "WELFARE")
    private PolicyCategory policyCategory;

    @Schema(description = "제출된 제안 정책의 본문", example = "저는 경주시에 있는 한 대학교에 재학중인 학생입니다. 이번에 이하 생략...")
    private String description;

    @Schema(description = "제출된 제안 정책의 좋아요 수", example = "10")
    private Long likeCount;

    @Schema(description = "제출된 제안 정책에 대한 현재 로그인된 유저의 좋아요 여부", example = "true")
    private boolean likeStatus;

    @Schema(description = "제출된 제안 정책의 생성시간", example = "2024-12-01 02:23:04.646905")
    private LocalDateTime createdAt;

    public static SuggestionDetailResponseDto fromDto(SuggestionDetailDto dto){
        return SuggestionDetailResponseDto.builder()
                .message("제안 정책 상세 정보를 성공적으로 불러왔습니다.")
                .id(dto.getId())
                .creatorName(dto.getCreatorName())
                .title(dto.getTitle())
                .policyCategory(dto.getPolicyCategory())
                .description(dto.getDescription())
                .likeCount(dto.getLikeCount())
                .likeStatus(dto.isLikeStatus())
                .createdAt(dto.getCreatedAt())
                .build();
    }
}
