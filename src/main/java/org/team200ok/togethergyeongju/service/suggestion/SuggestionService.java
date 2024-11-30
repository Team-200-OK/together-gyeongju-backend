package org.team200ok.togethergyeongju.service.suggestion;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.team200ok.togethergyeongju.config.HttpErrorCode;
import org.team200ok.togethergyeongju.domain.User;
import org.team200ok.togethergyeongju.domain.suggestion.Suggestion;
import org.team200ok.togethergyeongju.domain.suggestion.SuggestionLike;
import org.team200ok.togethergyeongju.dto.suggestion.detail.SuggestionDetailDto;
import org.team200ok.togethergyeongju.dto.suggestion.list.SuggestionListDto;
import org.team200ok.togethergyeongju.dto.suggestion.list.SuggestionListResponseDto;
import org.team200ok.togethergyeongju.dto.suggestion.save.SuggestionSaveDto;
import org.team200ok.togethergyeongju.dto.suggestion.save.SuggestionSaveRequestDto;
import org.team200ok.togethergyeongju.exception.HttpErrorException;
import org.team200ok.togethergyeongju.repository.SuggestionLikeRepository;
import org.team200ok.togethergyeongju.repository.SuggestionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuggestionService {

    private final SuggestionRepository suggestionRepository;
    private final SuggestionLikeRepository suggestionLikeRepository;

    private final int Suggestion_PAGE_SIZE = 10;


    @Transactional
    public SuggestionSaveDto saveSuggestion(User user, SuggestionSaveRequestDto suggestionSaveRequestDto) {

        Suggestion savedSuggestion = suggestionRepository.save(Suggestion.of(user, suggestionSaveRequestDto));

        return SuggestionSaveDto.fromEntity(savedSuggestion);
    }


    public SuggestionListResponseDto getSuggestionList(User user, Long cursor){

        Page<Suggestion> suggestionPage;

        Pageable suggestoinPageable = PageRequest.of(0, Suggestion_PAGE_SIZE);

        if (cursor != null){
            Suggestion foundSuggestion = suggestionRepository.findById(cursor)
                    .orElseThrow(() -> new HttpErrorException(HttpErrorCode.SuggestionNotFoundError));

            suggestionPage = suggestionRepository.getSuggestionsByCursor(foundSuggestion.getId(), foundSuggestion.getCreatedAt(), suggestoinPageable);
        }else {
            suggestionPage = suggestionRepository.findAll(suggestoinPageable);
        }

        List<SuggestionListDto> suggestionList = suggestionPage.map( suggestion ->
            SuggestionListDto.of(suggestion,
                    suggestionLikeRepository.countBySuggestionId(suggestion.getId()),
                    suggestionLikeRepository.findByUserAndSuggestion(user, suggestion))
        ).toList();

        return SuggestionListResponseDto.fromDto(suggestionList);

    }

    public SuggestionDetailDto getSuggestionDetail(User user, Long suggestionId){

        Suggestion foundSuggestion = suggestionRepository.findById(suggestionId)
                .orElseThrow(() -> new HttpErrorException(HttpErrorCode.SuggestionNotFoundError));

        Long likeCount = suggestionLikeRepository.countBySuggestionId(suggestionId);

        boolean likeStatus;

        SuggestionLike foundSuggestionLike = suggestionLikeRepository.findByUserAndSuggestion(user, foundSuggestion);

        likeStatus = foundSuggestionLike != null;

        return SuggestionDetailDto.of(foundSuggestion, likeCount, likeStatus);
    }

    @Transactional
    public String suggestionLikeToggle(User user, Long suggestionId){

        String responseMessage;

        Suggestion foundSuggestion = suggestionRepository.findById(suggestionId)
                .orElseThrow(() -> new HttpErrorException(HttpErrorCode.SuggestionNotFoundError));

        SuggestionLike foundSuggestionLike = suggestionLikeRepository.findByUserAndSuggestion(user, foundSuggestion);

        if (foundSuggestionLike == null){
            suggestionLikeRepository.save(SuggestionLike.of(foundSuggestion, user));

            responseMessage = "제안된 정책에 좋아요를 누르셨습니다.";
        }else{
            suggestionLikeRepository.delete(foundSuggestionLike);

            responseMessage = "제안된 정책에 좋아요를 취소하셨습니다.";
        }

        return responseMessage;

    }

}
