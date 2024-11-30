package org.team200ok.togethergyeongju.controller.survey;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.team200ok.togethergyeongju.config.HttpErrorCode;
import org.team200ok.togethergyeongju.constant.PolicyCategory;
import org.team200ok.togethergyeongju.domain.User;
import org.team200ok.togethergyeongju.dto.survey.SurveyListGetDto;
import org.team200ok.togethergyeongju.dto.survey.SurveyListGetResponseDto;
import org.team200ok.togethergyeongju.service.survey.SurveyService;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExample;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExamples;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/survey")
@Tag(name = "설문조사")
public class SurveyController {
    private final SurveyService surveyService;

    @GetMapping
    @Operation(summary = "설문조사 전체 조회")
    @ApiErrorCodeExamples(value = {
            @ApiErrorCodeExample(value = HttpErrorCode.AccessDeniedError),
            @ApiErrorCodeExample(value = HttpErrorCode.NotValidAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.ExpiredAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.UserNotFoundError),
            @ApiErrorCodeExample(value = HttpErrorCode.NoSuchSurveyError)
    })
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = SurveyListGetResponseDto.class)))
    public ResponseEntity<SurveyListGetResponseDto> getSurveyList(@RequestParam(value = "policyCategory", required = false) PolicyCategory policyCategory,
                                                                  @RequestParam(value = "cursor", required = false) Long cursor,
                                                                  @AuthenticationPrincipal User user) {
        SurveyListGetDto dto = surveyService.getList(policyCategory, cursor, user);
        return new ResponseEntity<>(SurveyListGetResponseDto.from(dto), HttpStatus.OK);
    }

}
