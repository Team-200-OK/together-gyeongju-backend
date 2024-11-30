package org.team200ok.togethergyeongju.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.team200ok.togethergyeongju.constant.JobCategory;
import org.team200ok.togethergyeongju.domain.policy.Policy;

import java.time.LocalDateTime;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

    Policy findByJobCategoryAndId(JobCategory jobCategory, Long cursor);

    Page<Policy> findAllByJobCategory(JobCategory jobCategory, Pageable pageable);

    @Query("SELECT p FROM policy p WHERE (p.id > :policyId AND p.createdAt = :createdAt) OR p.createdAt > :createdAt")
    Page<Policy> getPoliciesByCursor(@Param("policyId") Long policyId,
                                   @Param("createdAt")LocalDateTime createdAt,
                                   Pageable policyPageable
    );

}
