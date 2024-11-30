package org.team200ok.togethergyeongju.controller.suggestion;

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
import org.team200ok.togethergyeongju.dto.suggestion.detail.SuggestionDetailDto;
import org.team200ok.togethergyeongju.dto.suggestion.detail.SuggestionDetailResponseDto;
import org.team200ok.togethergyeongju.dto.suggestion.detail.SuggestionLikeToggleResponseDto;
import org.team200ok.togethergyeongju.dto.suggestion.list.SuggestionListResponseDto;
import org.team200ok.togethergyeongju.dto.suggestion.save.SuggestionSaveDto;
import org.team200ok.togethergyeongju.dto.suggestion.save.SuggestionSaveRequestDto;
import org.team200ok.togethergyeongju.dto.suggestion.save.SuggestionSaveResponseDto;
import org.team200ok.togethergyeongju.service.suggestion.SuggestionService;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExample;
import org.team200ok.togethergyeongju.swagger.ApiErrorCodeExamples;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/suggestion")
@Tag(name = "제안하기 탭")
public class SuggestionController {

    private final SuggestionService suggestionService;

    @Operation(summary = "제안하기 제출")
    @ApiErrorCodeExamples(value = {
            @ApiErrorCodeExample(value = HttpErrorCode.AccessDeniedError),
            @ApiErrorCodeExample(value = HttpErrorCode.NotValidAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.ExpiredAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.UserNotFoundError),
    })
    @PostMapping("/save")
    public ResponseEntity<SuggestionSaveResponseDto> saveSuggestion(
            @AuthenticationPrincipal User user,
            @Valid @RequestBody SuggestionSaveRequestDto suggestionSaveRequestDto
    ){

        SuggestionSaveDto dto = suggestionService.saveSuggestion(user, suggestionSaveRequestDto);

        return new ResponseEntity<>(SuggestionSaveResponseDto.fromDto(dto), HttpStatus.CREATED);

    }

    @Operation(summary = "제안된 정책 리스트 조회")
    @ApiErrorCodeExamples(value = {
            @ApiErrorCodeExample(value = HttpErrorCode.AccessDeniedError),
            @ApiErrorCodeExample(value = HttpErrorCode.NotValidAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.ExpiredAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.UserNotFoundError),
            @ApiErrorCodeExample(value = HttpErrorCode.SuggestionNotFoundError),
    })
    @GetMapping()
    public ResponseEntity<SuggestionListResponseDto> getSuggestionList(
            @AuthenticationPrincipal User user,
            @RequestParam(value = "cursor", required = false) Long cursor
    ){

        SuggestionListResponseDto suggestionList = suggestionService.getSuggestionList(user, cursor);

        return new ResponseEntity<>(suggestionList, HttpStatus.OK);

    }

    @Operation(summary = "제안된 정책 상세 조회")
    @ApiErrorCodeExamples(value = {
            @ApiErrorCodeExample(value = HttpErrorCode.AccessDeniedError),
            @ApiErrorCodeExample(value = HttpErrorCode.NotValidAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.ExpiredAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.UserNotFoundError),
            @ApiErrorCodeExample(value = HttpErrorCode.SuggestionNotFoundError),
    })
    @GetMapping("/{id}")
    public ResponseEntity<SuggestionDetailResponseDto> getSuggestionDetail(
            @AuthenticationPrincipal User user,
            @PathVariable(name = "id") Long id
    ){

        SuggestionDetailDto dto = suggestionService.getSuggestionDetail(user, id);

        return new ResponseEntity<>(SuggestionDetailResponseDto.fromDto(dto), HttpStatus.OK);

    }

    @Operation(summary = "제안된 정책 좋아요 토글")
    @ApiErrorCodeExamples(value = {
            @ApiErrorCodeExample(value = HttpErrorCode.AccessDeniedError),
            @ApiErrorCodeExample(value = HttpErrorCode.NotValidAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.ExpiredAccessTokenError),
            @ApiErrorCodeExample(value = HttpErrorCode.UserNotFoundError),
    })
    @PostMapping("/{id}/like")
    public ResponseEntity<SuggestionLikeToggleResponseDto> suggestionLikeToggle(
            @AuthenticationPrincipal User user,
            @PathVariable(name = "id") Long id
    ){

        String responseMessage = suggestionService.suggestionLikeToggle(user, id);

        return new ResponseEntity<>(SuggestionLikeToggleResponseDto.createNewResponse(responseMessage), HttpStatus.CREATED);

    }
}
