package org.team200ok.togethergyeongju.service.survey;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.team200ok.togethergyeongju.config.HttpErrorCode;
import org.team200ok.togethergyeongju.domain.Survey;
import org.team200ok.togethergyeongju.domain.SurveyOpinion;
import org.team200ok.togethergyeongju.domain.SurveyPreference;
import org.team200ok.togethergyeongju.domain.User;
import org.team200ok.togethergyeongju.dto.survey.opinion.SurveyOpinionEnrollDto;
import org.team200ok.togethergyeongju.dto.survey.preference.SurveyPreferenceCreateDto;
import org.team200ok.togethergyeongju.dto.survey.preference.SurveyPreferenceCreateRequestDto;
import org.team200ok.togethergyeongju.dto.survey.preference.SurveyPreferenceEnrollDto;
import org.team200ok.togethergyeongju.dto.survey.preference.SurveyPreferenceEnrollRequestDto;
import org.team200ok.togethergyeongju.exception.HttpErrorException;
import org.team200ok.togethergyeongju.repository.SurveyPreferenceRepository;
import org.team200ok.togethergyeongju.repository.SurveyRepository;
import org.team200ok.togethergyeongju.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class SurveyPreferenceService {
    private final SurveyRepository surveyRepository;
    private final SurveyPreferenceRepository surveyPreferenceRepository;

    public SurveyPreferenceEnrollDto enroll(User user, @Valid SurveyPreferenceEnrollRequestDto requestDto, Long surveyId) {
        Survey foundSurvey = surveyRepository.findById(surveyId).orElseThrow(() -> new HttpErrorException(HttpErrorCode.NoSuchSurveyError));
        SurveyPreference savedSurveyPreference = surveyPreferenceRepository.save(SurveyPreference.of(foundSurvey, user, requestDto));
        return SurveyPreferenceEnrollDto.of(savedSurveyPreference);
    }

    public SurveyPreferenceCreateDto createSurveyPreference(SurveyPreferenceCreateRequestDto requestDto) {
        Survey savedPreference = surveyRepository.save(Survey.createSurveyPreference(requestDto));
        return SurveyPreferenceCreateDto.fromEntity(savedPreference);
    }
}
