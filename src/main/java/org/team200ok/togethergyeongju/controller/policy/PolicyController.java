package org.team200ok.togethergyeongju.controller.policy;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.team200ok.togethergyeongju.config.HttpErrorCode;
import org.team200ok.togethergyeongju.domain.User;
import org.team200ok.togethergyeongju.dto.policy.detail.PolicyDetailResponseDto;
import org.team200ok.togethergyeongju.dto.policy.detail.PolicyScrapResponseDto;
import org.team200ok.togethergyeongju.dto.policy.summary.PolicySummaryListResponseDto;
import org.team200ok.togethergyeongju.service.policy.PolicyService;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExample;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExamples;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/policy")
@Tag(name = "메인 화면")
public class PolicyController {

    private final PolicyService policyService;

    @Operation(summary = "정책 요약 정보 조회")
    @ApiErrorCodeExamples(value = {
            @ApiErrorCodeExample(value = HttpErrorCode.AccessDeniedError),
            @ApiErrorCodeExample(value = HttpErrorCode.NotValidAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.ExpiredAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.UserNotFoundError),
    })
    @GetMapping()
    public ResponseEntity<PolicySummaryListResponseDto> getPolicySummaries(
            @AuthenticationPrincipal User user,
            @RequestParam(value = "cursor", required = false) Long cursor
    ) {
        PolicySummaryListResponseDto policySummaryList = policyService.getPolicySummaryList(user, cursor);
        return new ResponseEntity<>(policySummaryList, HttpStatus.OK);
    }

    @Operation(summary = "정책 요약 상세 조회")
    @ApiErrorCodeExamples(value = {
            @ApiErrorCodeExample(value = HttpErrorCode.AccessDeniedError),
            @ApiErrorCodeExample(value = HttpErrorCode.NotValidAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.ExpiredAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.UserNotFoundError),
            @ApiErrorCodeExample(value = HttpErrorCode.PolicyNotFoundError)
    })
    @GetMapping("/{id}")
    public ResponseEntity<PolicyDetailResponseDto> getPolicyDetail(
            @AuthenticationPrincipal User user,
            @PathVariable(name = "id") Long id
    ){
        PolicyDetailResponseDto policyDetail = policyService.getPolicyDetail(user, id);

        return new ResponseEntity<>(policyDetail, HttpStatus.OK);
    }

    @Operation(summary = "정책 스크랩")
    @ApiErrorCodeExamples(value = {
            @ApiErrorCodeExample(value = HttpErrorCode.AccessDeniedError),
            @ApiErrorCodeExample(value = HttpErrorCode.NotValidAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.ExpiredAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.UserNotFoundError),
            @ApiErrorCodeExample(value = HttpErrorCode.PolicyNotFoundError)
    })
    @PostMapping("/{id}/scrap")
    public ResponseEntity<PolicyScrapResponseDto> policyScrapToggle(
            @AuthenticationPrincipal User user,
            @PathVariable(name = "id") Long id
    ){
        String responseMessage = policyService.policyScrapToggle(user, id);

        return ResponseEntity.ok(PolicyScrapResponseDto.createNewResponse(responseMessage));
    }

}
