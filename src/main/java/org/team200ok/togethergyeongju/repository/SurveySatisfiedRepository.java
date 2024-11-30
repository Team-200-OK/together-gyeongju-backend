package org.team200ok.togethergyeongju.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team200ok.togethergyeongju.domain.Survey;
import org.team200ok.togethergyeongju.domain.SurveyPreference;
import org.team200ok.togethergyeongju.domain.SurveySatisfied;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface SurveySatisfiedRepository extends JpaRepository<SurveySatisfied, Long> {
    List<SurveySatisfied> findBySurvey(Survey survey);
}
