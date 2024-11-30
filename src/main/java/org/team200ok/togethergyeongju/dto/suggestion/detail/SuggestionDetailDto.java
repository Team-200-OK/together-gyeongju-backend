package org.team200ok.togethergyeongju.dto.suggestion.detail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.constant.PolicyCategory;
import org.team200ok.togethergyeongju.domain.suggestion.Suggestion;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class SuggestionDetailDto {

    private Long id;
    private String creatorName;
    private String title;
    private PolicyCategory policyCategory;
    private String description;
    private Long likeCount;
    private boolean likeStatus;
    private LocalDateTime createdAt;

    public static SuggestionDetailDto of(Suggestion foundSuggestion, Long likeCount, boolean likeStatus){
        return SuggestionDetailDto.builder()
                .id(foundSuggestion.getId())
                .creatorName(foundSuggestion.getUser().getName())
                .title(foundSuggestion.getTitle())
                .policyCategory(foundSuggestion.getPolicyCategory())
                .description(foundSuggestion.getDescription())
                .likeCount(likeCount)
                .likeStatus(likeStatus)
                .createdAt(foundSuggestion.getCreatedAt())
                .build();
    }
}
