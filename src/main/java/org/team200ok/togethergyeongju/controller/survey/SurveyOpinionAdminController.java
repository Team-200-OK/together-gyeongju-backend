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
import org.springframework.web.bind.annotation.*;
import org.team200ok.togethergyeongju.config.HttpErrorCode;
import org.team200ok.togethergyeongju.dto.survey.SurveyListGetResponseDto;
import org.team200ok.togethergyeongju.dto.survey.opinion.admin.SurveyOpinionCreateDto;
import org.team200ok.togethergyeongju.dto.survey.opinion.admin.SurveyOpinionCreateRequestDto;
import org.team200ok.togethergyeongju.dto.survey.opinion.admin.SurveyOpinionCreateResponseDto;
import org.team200ok.togethergyeongju.service.survey.SurveyOpinionService;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExample;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExamples;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/survey/opinion")
@Tag(name = "관리자 설문조사 의견")
public class SurveyOpinionAdminController {
    private final SurveyOpinionService surveyOpinionService;

    @PostMapping
    @Operation(summary = "설문조사 의견 추가")
    @ApiErrorCodeExamples(value = {
            @ApiErrorCodeExample(value = HttpErrorCode.AccessDeniedError),
            @ApiErrorCodeExample(value = HttpErrorCode.NotValidAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.ExpiredAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.UserNotFoundError),
    })
    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = SurveyOpinionCreateResponseDto.class)))
    public ResponseEntity<SurveyOpinionCreateResponseDto> createSurveyOpinion(@Valid @RequestBody SurveyOpinionCreateRequestDto requestDto) {
        SurveyOpinionCreateDto dto = surveyOpinionService.createSurveyOpinion(requestDto);
        return new ResponseEntity<>(SurveyOpinionCreateResponseDto.fromDto(dto), HttpStatus.CREATED);
    }
}
