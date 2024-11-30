package org.team200ok.togethergyeongju.dto.suggestion.save;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.constant.PolicyCategory;
import org.team200ok.togethergyeongju.domain.suggestion.Suggestion;

@Getter
@AllArgsConstructor
@Builder
public class SuggestionSaveDto {

    private Long id;
    private String title;
    private PolicyCategory policyCategory;
    private String description;

    public static SuggestionSaveDto fromEntity(Suggestion savedSuggestion){
        return SuggestionSaveDto.builder()
                .id(savedSuggestion.getId())
                .title(savedSuggestion.getTitle())
                .policyCategory(savedSuggestion.getPolicyCategory())
                .description(savedSuggestion.getDescription())
                .build();
    }
}
