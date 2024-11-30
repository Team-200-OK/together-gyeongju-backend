package org.team200ok.togethergyeongju.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.team200ok.togethergyeongju.domain.suggestion.Suggestion;

import java.time.LocalDateTime;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

    @Query("SELECT s FROM suggestion s WHERE (s.id > :suggestionId AND s.createdAt = :createdAt) OR s.createdAt > :createdAt")
    Page<Suggestion> getSuggestionsByCursor(@Param("suggestionId") Long suggestionId,
                                            @Param("createdAt") LocalDateTime createdAt,
                                            Pageable suggestionPageable
    );
}
