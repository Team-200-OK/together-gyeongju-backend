package org.team200ok.togethergyeongju.dto.policy.summary;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@Schema(name = "PolicySummaryListResponse")
public class PolicySummaryListResponseDto {

    @Schema(description = "응답 메시지", example = "성공적으로 정책 요약 정보 리스트를 불러왔습니다.")
    private String message;

    @Schema(description = "정책 이미지 api 주소")
    private String imageApiUrl;

    @Schema(description = "정책 요약 정보 리스트")
    private List<PolicySummaryListDto> policySummaries;

    public static PolicySummaryListResponseDto of(List<PolicySummaryListDto> policySummaries, String imageApiUrl) {
        return PolicySummaryListResponseDto.builder()
                .message("정책 요약정보 리스트를 성공적으로 불러왔습니다.")
                .imageApiUrl(imageApiUrl)
                .policySummaries(policySummaries)
                .build();
    }
}
