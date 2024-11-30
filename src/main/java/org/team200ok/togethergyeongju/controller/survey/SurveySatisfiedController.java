package org.team200ok.togethergyeongju.controller.survey;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.team200ok.togethergyeongju.config.HttpErrorCode;
import org.team200ok.togethergyeongju.domain.User;
import org.team200ok.togethergyeongju.dto.survey.satisfied.SurveySatisfiedEnrollDto;
import org.team200ok.togethergyeongju.dto.survey.satisfied.SurveySatisfiedEnrollResponseDto;
import org.team200ok.togethergyeongju.service.survey.SurveySatisfiedService;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExample;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExamples;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/survey/satisfied")
@Tag(name = "설문조사 만족도")
public class SurveySatisfiedController {
    private final SurveySatisfiedService surveySatisfiedService;

    @PostMapping("/item/{satisfiedId}")
    @Operation(summary = "설문조사 만족도 등록")
    @ApiErrorCodeExamples(value = {
            @ApiErrorCodeExample(value = HttpErrorCode.AccessDeniedError),
            @ApiErrorCodeExample(value = HttpErrorCode.NotValidAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.ExpiredAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.UserNotFoundError),
            @ApiErrorCodeExample(value = HttpErrorCode.NoSuchSurveySatisfiedError)
    })
    public ResponseEntity<SurveySatisfiedEnrollResponseDto> enroll(
            @PathVariable Long satisfiedId,
            @AuthenticationPrincipal User user) {

        SurveySatisfiedEnrollDto dto = surveySatisfiedService.enroll(satisfiedId, user);
        return new ResponseEntity<>(SurveySatisfiedEnrollResponseDto.from(dto), HttpStatus.OK);
    }

}
