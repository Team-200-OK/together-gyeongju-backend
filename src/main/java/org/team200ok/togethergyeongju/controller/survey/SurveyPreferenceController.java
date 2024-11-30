package org.team200ok.togethergyeongju.controller.survey;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.team200ok.togethergyeongju.config.HttpErrorCode;
import org.team200ok.togethergyeongju.domain.User;
import org.team200ok.togethergyeongju.dto.survey.opinion.admin.SurveyOpinionCreateResponseDto;
import org.team200ok.togethergyeongju.dto.survey.preference.*;
import org.team200ok.togethergyeongju.service.survey.SurveyPreferenceService;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExample;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExamples;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/survey/preference")
@Tag(name = "설문조사 선호도")
public class SurveyPreferenceController {
    private final SurveyPreferenceService surveyPreferenceService;

    @PostMapping("/{surveyId}")
    @Operation(summary = "설문조사 선호도 등록")
    @ApiErrorCodeExamples(value = {
            @ApiErrorCodeExample(value = HttpErrorCode.AccessDeniedError),
            @ApiErrorCodeExample(value = HttpErrorCode.NotValidAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.ExpiredAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.UserNotFoundError),
            @ApiErrorCodeExample(value = HttpErrorCode.NoSuchSurveyError)

    })
    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = SurveyPreferenceEnrollResponseDto.class)))
    public ResponseEntity<SurveyPreferenceEnrollResponseDto> enroll(@AuthenticationPrincipal User user,
                                                                       @Valid @RequestBody SurveyPreferenceEnrollRequestDto requestDto,
                                                                       @PathVariable Long surveyId) {
        SurveyPreferenceEnrollDto dto = surveyPreferenceService.enroll(user, requestDto, surveyId);
        return new ResponseEntity<>(SurveyPreferenceEnrollResponseDto.fromDto(dto), HttpStatus.OK);
    }
}
