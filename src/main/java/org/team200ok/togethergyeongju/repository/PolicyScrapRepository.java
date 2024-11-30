package org.team200ok.togethergyeongju.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team200ok.togethergyeongju.domain.User;
import org.team200ok.togethergyeongju.domain.policy.Policy;
import org.team200ok.togethergyeongju.domain.policy.PolicyScrap;

public interface PolicyScrapRepository extends JpaRepository<PolicyScrap, Long> {

    PolicyScrap findByUserAndPolicy(User user, Policy policy);
}
