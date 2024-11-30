package org.team200ok.togethergyeongju.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team200ok.togethergyeongju.domain.Survey;
import org.team200ok.togethergyeongju.domain.SurveyOpinion;

import java.util.Optional;

public interface SurveyOpinionRepository extends JpaRepository<SurveyOpinion, Long> {
    Optional<SurveyOpinion> findBySurvey(Survey survey);
}
