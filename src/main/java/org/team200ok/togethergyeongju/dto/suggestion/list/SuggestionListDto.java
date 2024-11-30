package org.team200ok.togethergyeongju.dto.suggestion.list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.domain.suggestion.Suggestion;
import org.team200ok.togethergyeongju.domain.suggestion.SuggestionLike;

@Getter
@AllArgsConstructor
@Builder
public class SuggestionListDto {

    private SuggestionElement suggestion;

    public static SuggestionListDto of(Suggestion foundSuggestion, Long suggestionLikeCount, SuggestionLike foudSuggestionLike){
        return SuggestionListDto.builder()
                .suggestion(SuggestionElement.of(foundSuggestion, suggestionLikeCount, foudSuggestionLike))
                .build();
    }

}
