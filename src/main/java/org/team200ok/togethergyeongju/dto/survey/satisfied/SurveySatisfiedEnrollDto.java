package org.team200ok.togethergyeongju.dto.survey.satisfied;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.domain.SurveyPreference;
import org.team200ok.togethergyeongju.domain.SurveySatisfied;
import org.team200ok.togethergyeongju.domain.UserSurveySatisfied;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class SurveySatisfiedEnrollDto {
    private Long id;

    private Long userId;

    private Long satisfiedId;

    private LocalDateTime createdAt;

    public static SurveySatisfiedEnrollDto of(UserSurveySatisfied userSurveySatisfied) {
        return SurveySatisfiedEnrollDto.builder()
                .id(userSurveySatisfied.getId())
                .userId(userSurveySatisfied.getUser().getId())
                .satisfiedId(userSurveySatisfied.getSurveySatisfied().getId())
                .createdAt(userSurveySatisfied.getCreatedAt())
                .build();
    }
}
