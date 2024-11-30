package org.team200ok.togethergyeongju.dto.policy.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.constant.JobCategory;
import org.team200ok.togethergyeongju.domain.policy.Policy;
import org.team200ok.togethergyeongju.domain.policy.PolicyImage;
import org.team200ok.togethergyeongju.dto.policy.PolicyImageElement;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class PolicyDetailResponseDto {

    @Schema(description = "응답 메시지", example = "성공적으로 정책 상세정보를 불러왔습니다.")
    private String message;

    @Schema(description = "정책 이미지 api 주소")
    private String imageApiUrl;

    @Schema(description = "정책 id")
    private Long id;

    @Schema(description = "정책 카테고리")
    private JobCategory jobCategory;

    @Schema(description = "정책 제목")
    private String title;

    @Schema(description = "정책 본문")
    private String content;

    @Schema(description = "정책 이미지들")
    private List<PolicyImageElement> images;

    @Schema(description = "정책 스크랩 여부")
    private boolean scrapStatus;

    @Schema(description = "정책 정보 생성시간")
    private LocalDateTime createdAt;


    public static PolicyDetailResponseDto of(Policy foundPolicy, List<PolicyImage> foundImages, String imageApiUrl, boolean scrapStatus) {
        return PolicyDetailResponseDto.builder()
                .message("정책 상세정보를 성공적으로 불러왔습니다.")
                .imageApiUrl(imageApiUrl)
                .id(foundPolicy.getId())
                .jobCategory(foundPolicy.getJobCategory())
                .title(foundPolicy.getTitle())
                .content(foundPolicy.getContent())
                .images(foundImages.stream()
                        .map(PolicyImageElement::fromEntity)
                        .toList())
                .scrapStatus(scrapStatus)
                .createdAt(foundPolicy.getCreatedAt())
                .build();
    }

}
