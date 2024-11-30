package org.team200ok.togethergyeongju.dto.policy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.domain.policy.PolicyImage;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class PolicyImageElement {

    private Long id;
    private String policyImageName;
    private LocalDateTime createdAt;

    public static PolicyImageElement fromEntity(PolicyImage policyImage) {
        return PolicyImageElement.builder()
                .id(policyImage.getId())
                .policyImageName(policyImage.getImageName())
                .createdAt(policyImage.getCreatedAt())
                .build();
    }

}


