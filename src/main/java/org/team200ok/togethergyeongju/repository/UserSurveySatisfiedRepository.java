package org.team200ok.togethergyeongju.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team200ok.togethergyeongju.domain.SurveySatisfied;
import org.team200ok.togethergyeongju.domain.User;
import org.team200ok.togethergyeongju.domain.UserSurveySatisfied;

import java.util.Optional;

public interface UserSurveySatisfiedRepository extends JpaRepository<UserSurveySatisfied, Long> {
    Optional<UserSurveySatisfied> findByUserAndSurveySatisfied(User user, SurveySatisfied surveySatisfied);
}
