package org.team200ok.togethergyeongju.dto.suggestion.list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.constant.PolicyCategory;
import org.team200ok.togethergyeongju.domain.suggestion.Suggestion;
import org.team200ok.togethergyeongju.domain.suggestion.SuggestionLike;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class SuggestionElement {

    private Long suggestionId;
    private String creatorName;
    private String title;
    private PolicyCategory policyCategory;
    private String description;
    private Long likeCount;
    private boolean likeStatus;
    private LocalDateTime createdAt;

    public static SuggestionElement of(Suggestion foundSuggestion, Long likeCount, SuggestionLike foundSuggestionLike){
        return SuggestionElement.builder()
                .suggestionId(foundSuggestion.getId())
                .creatorName(foundSuggestion.getUser().getName())
                .title(foundSuggestion.getTitle())
                .policyCategory(foundSuggestion.getPolicyCategory())
                .description(foundSuggestion.getDescription())
                .likeCount(likeCount)
                .likeStatus(foundSuggestionLike != null ? true : false)
                .createdAt(foundSuggestion.getCreatedAt())
                .build();
    }

}
