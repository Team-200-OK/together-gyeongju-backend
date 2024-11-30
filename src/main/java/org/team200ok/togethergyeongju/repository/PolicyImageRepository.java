package org.team200ok.togethergyeongju.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team200ok.togethergyeongju.domain.policy.PolicyImage;

import java.util.List;

public interface PolicyImageRepository extends JpaRepository<PolicyImage, Long> {

    List<PolicyImage> findByPolicyId(Long policyId);
}
