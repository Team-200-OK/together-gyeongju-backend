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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.team200ok.togethergyeongju.config.HttpErrorCode;
import org.team200ok.togethergyeongju.dto.survey.preference.SurveyPreferenceCreateDto;
import org.team200ok.togethergyeongju.dto.survey.preference.SurveyPreferenceCreateRequestDto;
import org.team200ok.togethergyeongju.dto.survey.preference.SurveyPreferenceCreateResponseDto;
import org.team200ok.togethergyeongju.dto.survey.preference.SurveyPreferenceEnrollResponseDto;
import org.team200ok.togethergyeongju.service.survey.SurveyPreferenceService;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExample;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExamples;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/survey/preference")
@Tag(name = "관리자 설문조사 선호도")
public class SurveyPreferenceAdminController {
    private final SurveyPreferenceService surveyPreferenceService;

    @PostMapping
    @Operation(summary = "설문조사 선호도 추가")
    @ApiErrorCodeExamples(value = {
            @ApiErrorCodeExample(value = HttpErrorCode.AccessDeniedError),
            @ApiErrorCodeExample(value = HttpErrorCode.NotValidAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.ExpiredAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.UserNotFoundError),
    })
    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = SurveyPreferenceCreateResponseDto.class)))
    public ResponseEntity<SurveyPreferenceCreateResponseDto> createSurveyOpinion(@Valid @RequestBody SurveyPreferenceCreateRequestDto requestDto) {
        SurveyPreferenceCreateDto dto = surveyPreferenceService.createSurveyPreference(requestDto);
        return new ResponseEntity<>(SurveyPreferenceCreateResponseDto.fromDto(dto), HttpStatus.CREATED);
    }
}
