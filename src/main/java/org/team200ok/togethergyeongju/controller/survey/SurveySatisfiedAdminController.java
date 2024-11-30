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
import org.team200ok.togethergyeongju.dto.survey.SurveyListGetResponseDto;
import org.team200ok.togethergyeongju.dto.survey.satisfied.SurveySatisfiedCreateDto;
import org.team200ok.togethergyeongju.dto.survey.satisfied.SurveySatisfiedCreateRequestDto;
import org.team200ok.togethergyeongju.dto.survey.satisfied.SurveySatisfiedCreateResponseDto;
import org.team200ok.togethergyeongju.service.survey.SurveySatisfiedService;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExample;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExamples;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/survey/satisfied")
@Tag(name = "관리자 설문조사 만족도")
public class SurveySatisfiedAdminController {
    private final SurveySatisfiedService surveySatisfiedService;

    @PostMapping
    @Operation(summary = "설문조사 만족도 추가")
    @ApiErrorCodeExamples(value = {
            @ApiErrorCodeExample(value = HttpErrorCode.AccessDeniedError),
            @ApiErrorCodeExample(value = HttpErrorCode.NotValidAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.ExpiredAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.UserNotFoundError),
    })
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = SurveySatisfiedCreateResponseDto.class)))
    public ResponseEntity<SurveySatisfiedCreateResponseDto> createSurveyOpinion(@Valid @RequestBody SurveySatisfiedCreateRequestDto requestDto) {
        SurveySatisfiedCreateDto dto = surveySatisfiedService.createSurveySatisfied(requestDto);
        return new ResponseEntity<>(SurveySatisfiedCreateResponseDto.from(dto), HttpStatus.CREATED);
    }
}
