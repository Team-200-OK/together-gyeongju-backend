package org.team200ok.togethergyeongju.dto.suggestion.save;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.team200ok.togethergyeongju.constant.PolicyCategory;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SuggestionSaveRequestDto {

    @Schema(example = "경주시 정책을 파악하기 너무 어려워요", description = "제안하기 제목")
    @NotNull(message = "제목은 필수로 입력되어야합니다.")
    @Size(min = 2, message = "제목은 최소 2글자 이상이어야 합니다.")
    private String title;

    @Schema(example = "WELFARE", description = "제안할 정책의 카테고리")
    @NotNull(message = "카테고리는 필수 입니다.")
    private PolicyCategory policyCategory;

    @Schema(example = "저는 경주시에 있는 한 대학교에 재학중인 학생입니다. 이번에 경주시로 전입신고를 하게 되었습니다. 이하 생략...", description = "제안하기 본문")
    @NotNull(message = "본문은 필수로 입력되어야합니다.")
    @Size(min = 20, message = "본문은 최소 20글자 이상이어야 합니다.")
    private String description;
}
