package org.team200ok.togethergyeongju.dto.survey;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.domain.Survey;
import org.team200ok.togethergyeongju.domain.SurveySatisfied;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@Builder
public class SurveySatisfiedDto {
    private List<SurveySatisfiedElementDto> items;

    public static SurveySatisfiedDto from(List<SurveySatisfied> surveySatisfieds) {
        return SurveySatisfiedDto.builder()
                .items(surveySatisfieds.stream().map(SurveySatisfiedElementDto::from).collect(Collectors.toList()))
                .build();
    }
}
