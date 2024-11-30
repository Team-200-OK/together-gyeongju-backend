package org.team200ok.togethergyeongju.controller.survey;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.team200ok.togethergyeongju.config.HttpErrorCode;
import org.team200ok.togethergyeongju.domain.User;
import org.team200ok.togethergyeongju.dto.survey.opinion.SurveyOpinionEnrollDto;
import org.team200ok.togethergyeongju.dto.survey.opinion.SurveyOpinionEnrollRequestDto;
import org.team200ok.togethergyeongju.dto.survey.opinion.SurveyOpinionEnrollResponseDto;
import org.team200ok.togethergyeongju.service.survey.SurveyOpinionService;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExample;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExamples;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/survey/opinion")
@Tag(name = "설문조사 의견")
public class SurveyOpinionController {
    private final SurveyOpinionService surveyOpinionService;

    @PostMapping("/{surveyId}")
    @Operation(summary = "설문조사 의견 등록")
    @ApiErrorCodeExamples(value = {
            @ApiErrorCodeExample(value = HttpErrorCode.AccessDeniedError),
            @ApiErrorCodeExample(value = HttpErrorCode.NotValidAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.ExpiredAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.UserNotFoundError),
            @ApiErrorCodeExample(value = HttpErrorCode.NoSuchSurveyError),
    })
    public ResponseEntity<SurveyOpinionEnrollResponseDto> enroll(@AuthenticationPrincipal User user,
                                                                 @Valid @RequestBody SurveyOpinionEnrollRequestDto requestDto,
                                                                 @PathVariable Long surveyId) {
        SurveyOpinionEnrollDto dto = surveyOpinionService.enroll(user, requestDto, surveyId);
        return new ResponseEntity<>(SurveyOpinionEnrollResponseDto.fromDto(dto), HttpStatus.OK);
    }
}
