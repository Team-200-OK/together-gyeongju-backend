package org.team200ok.togethergyeongju.dto.policy.summary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.team200ok.togethergyeongju.domain.policy.Policy;
import org.team200ok.togethergyeongju.domain.policy.PolicyImage;
import org.team200ok.togethergyeongju.domain.policy.PolicyScrap;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PolicySummaryListDto {

    private PolicySummaryElement policySummary;

    public static PolicySummaryListDto of(Policy policy, List<PolicyImage> images, PolicyScrap foundPolicyScrap) {
        return PolicySummaryListDto.builder()
                .policySummary(PolicySummaryElement.of(policy, images, foundPolicyScrap))
                .build();
    }
}
