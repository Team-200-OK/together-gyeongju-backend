package org.team200ok.togethergyeongju.service.survey;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.team200ok.togethergyeongju.config.HttpErrorCode;
import org.team200ok.togethergyeongju.domain.Survey;
import org.team200ok.togethergyeongju.domain.SurveyOpinion;
import org.team200ok.togethergyeongju.domain.User;
import org.team200ok.togethergyeongju.dto.survey.opinion.SurveyOpinionEnrollDto;
import org.team200ok.togethergyeongju.dto.survey.opinion.SurveyOpinionEnrollRequestDto;
import org.team200ok.togethergyeongju.dto.survey.opinion.admin.SurveyOpinionCreateDto;
import org.team200ok.togethergyeongju.dto.survey.opinion.admin.SurveyOpinionCreateRequestDto;
import org.team200ok.togethergyeongju.exception.HttpErrorException;
import org.team200ok.togethergyeongju.repository.SurveyOpinionRepository;
import org.team200ok.togethergyeongju.repository.SurveyRepository;

@RequiredArgsConstructor
@Service
@Transactional
public class SurveyOpinionService {
    private final SurveyOpinionRepository surveyOpinionRepository;
    private final SurveyRepository surveyRepository;

    public SurveyOpinionEnrollDto enroll(User user, SurveyOpinionEnrollRequestDto requestDto, Long surveyId) {
        Survey foundSurvey = surveyRepository.findById(surveyId).orElseThrow(() -> new HttpErrorException(HttpErrorCode.NoSuchSurveyError));
        SurveyOpinion savedSurveyOpinion = surveyOpinionRepository.save(SurveyOpinion.of(foundSurvey, user, requestDto));
        return SurveyOpinionEnrollDto.of(savedSurveyOpinion);
    }

    public SurveyOpinionCreateDto createSurveyOpinion(SurveyOpinionCreateRequestDto requestDto) {
        Survey newSurvey = surveyRepository.save(Survey.createSurveyOpinion(requestDto));
        return SurveyOpinionCreateDto.fromDto(newSurvey);
    }
}
