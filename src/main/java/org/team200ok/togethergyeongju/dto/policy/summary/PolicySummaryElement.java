package org.team200ok.togethergyeongju.dto.policy.summary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.constant.JobCategory;
import org.team200ok.togethergyeongju.domain.policy.Policy;
import org.team200ok.togethergyeongju.domain.policy.PolicyImage;
import org.team200ok.togethergyeongju.domain.policy.PolicyScrap;
import org.team200ok.togethergyeongju.dto.policy.PolicyImageElement;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class PolicySummaryElement {

    private Long policyId;

    private JobCategory jobCategory;

    private String title;

    private String summary;

    private List<PolicyImageElement> images;

    private boolean scrapStatus;

    private LocalDateTime createdAt;

    public static PolicySummaryElement of(Policy policy, List<PolicyImage> images, PolicyScrap foundPolicyScrap) {
        return PolicySummaryElement.builder()
                .policyId(policy.getId())
                .jobCategory(policy.getJobCategory())
                .title(policy.getTitle())
                .summary(policy.getSummary())
                .images(images.stream()
                        .map(PolicyImageElement::fromEntity)
                        .toList())
                .scrapStatus(foundPolicyScrap != null ? true : false)
                .createdAt(policy.getCreatedAt())
                .build();
    }
}
