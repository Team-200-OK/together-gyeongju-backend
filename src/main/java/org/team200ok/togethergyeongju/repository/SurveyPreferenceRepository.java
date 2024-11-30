package org.team200ok.togethergyeongju.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team200ok.togethergyeongju.domain.Survey;
import org.team200ok.togethergyeongju.domain.SurveyOpinion;
import org.team200ok.togethergyeongju.domain.SurveyPreference;

import java.util.Optional;

public interface SurveyPreferenceRepository extends JpaRepository<SurveyPreference, Long> {
    Optional<SurveyPreference> findBySurvey(Survey survey);
}
