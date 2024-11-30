package org.team200ok.togethergyeongju.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.team200ok.togethergyeongju.constant.PolicyCategory;
import org.team200ok.togethergyeongju.domain.Survey;

import java.time.LocalDateTime;
import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
    Page<Survey> findAllByPolicyCategory(PolicyCategory policyCategory, Pageable commentPageable);

    @Query("SELECT s FROM Survey s WHERE (s.id > :surveyId AND s.createdAt = :createdAt) OR s.createdAt > :createdAt")
    Page<Survey> getSurveyByCursor(
            @Param("surveyId") Long surveyId,
            @Param("createdAt") LocalDateTime createdAt,
            Pageable replyPageable
    );

    @Query("SELECT s FROM Survey s WHERE ((s.id > :surveyId AND s.createdAt = :createdAt) OR s.createdAt > :createdAt) AND s.policyCategory = :policyCategory")
    Page<Survey> getSurveyByCursorAndPolicyCategory(
            @Param("policyCategory") PolicyCategory policyCategory,
            @Param("surveyId") Long surveyId,
            @Param("createdAt") LocalDateTime createdAt,
            Pageable replyPageable
    );
}
