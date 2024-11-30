package org.team200ok.togethergyeongju.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team200ok.togethergyeongju.domain.User;
import org.team200ok.togethergyeongju.domain.suggestion.Suggestion;
import org.team200ok.togethergyeongju.domain.suggestion.SuggestionLike;

public interface SuggestionLikeRepository extends JpaRepository<SuggestionLike, Long> {

    Long countBySuggestionId(Long suggestionId);

    SuggestionLike findByUserAndSuggestion(User user, Suggestion suggestion);

}
