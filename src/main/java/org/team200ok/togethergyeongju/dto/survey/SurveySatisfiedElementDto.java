package org.team200ok.togethergyeongju.dto.survey;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.domain.SurveySatisfied;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@Builder
public class SurveySatisfiedElementDto {
    private Long surveySatisfiedId;
    private String value;

    public static SurveySatisfiedElementDto from(SurveySatisfied surveySatisfied) {
        return SurveySatisfiedElementDto.builder()
                .surveySatisfiedId(surveySatisfied.getId())
                .value(surveySatisfied.getItem())
                .build();
    }
}
