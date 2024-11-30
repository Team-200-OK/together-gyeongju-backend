package org.team200ok.togethergyeongju.dto.survey;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.constant.PolicyCategory;
import org.team200ok.togethergyeongju.constant.SurveyType;
import org.team200ok.togethergyeongju.domain.Survey;
import org.team200ok.togethergyeongju.domain.SurveySatisfied;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class SurveyElementDto {
    @Schema(example = "1", description = "설문조사 아이디")
    private Long surveyId;

    @Schema(example = "경주시 설문조사", description = "설문조사 제목")
    private String title;

    @Schema(example = "경주시 설문조사입니다.", description = "설문조사 본문")
    private String description;

    @Schema(example = "ENVIRONMENT", description = "설문조사 카테고리")
    private PolicyCategory policyCategory;

    @Schema(example = "SURVEY_OPINION", description = "설문조사 종류")
    private SurveyType surveyType;

    @Schema(example = "true", description = "설문조사 완료 여부")
    private boolean isCompleted;

    @Schema(example = "true", description = "설문조사 종류가 만족도일 경우 활성화됩니다.")
    private SurveySatisfiedDto satisfied;

    public static SurveyElementDto createOpinion(Survey survey, boolean isCompleted) {
        return SurveyElementDto.builder()
                .surveyId(survey.getId())
                .title(survey.getTitle())
                .description(survey.getDescription())
                .policyCategory(survey.getPolicyCategory())
                .surveyType(survey.getSurveyType())
                .isCompleted(isCompleted)
                .build();
    }

    public static SurveyElementDto createPreference(Survey survey, boolean isCompleted) {
        return SurveyElementDto.builder()
                .surveyId(survey.getId())
                .title(survey.getTitle())
                .description(survey.getDescription())
                .policyCategory(survey.getPolicyCategory())
                .surveyType(survey.getSurveyType())
                .isCompleted(isCompleted)
                .build();
    }

    public static SurveyElementDto createSatisfied(List<SurveySatisfied> surveySatisfieds, boolean isCompleted) {
        Survey survey = surveySatisfieds.get(0).getSurvey();

        return SurveyElementDto.builder()
                .surveyId(surveySatisfieds.get(0).getSurvey().getId())
                .title(survey.getTitle())
                .description(survey.getDescription())
                .policyCategory(survey.getPolicyCategory())
                .surveyType(survey.getSurveyType())
                .isCompleted(isCompleted)
                .satisfied(SurveySatisfiedDto.from(surveySatisfieds))
                .build();
    }
}
