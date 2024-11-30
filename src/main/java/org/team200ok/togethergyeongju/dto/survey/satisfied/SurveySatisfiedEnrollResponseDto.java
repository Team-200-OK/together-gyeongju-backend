package org.team200ok.togethergyeongju.dto.survey.satisfied;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.domain.UserSurveySatisfied;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class SurveySatisfiedEnrollResponseDto {
    private Long id;

    private Long userId;

    private Long satisfiedId;

    private LocalDateTime createdAt;

    public static SurveySatisfiedEnrollResponseDto from(SurveySatisfiedEnrollDto dto) {
        return SurveySatisfiedEnrollResponseDto.builder()
                .id(dto.getId())
                .userId(dto.getUserId())
                .satisfiedId(dto.getSatisfiedId())
                .createdAt(dto.getCreatedAt())
                .build();
    }
}
