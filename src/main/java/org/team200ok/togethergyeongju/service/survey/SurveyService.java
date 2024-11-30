package org.team200ok.togethergyeongju.service.survey;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.team200ok.togethergyeongju.config.HttpErrorCode;
import org.team200ok.togethergyeongju.constant.PolicyCategory;
import org.team200ok.togethergyeongju.constant.SurveyType;
import org.team200ok.togethergyeongju.domain.*;
import org.team200ok.togethergyeongju.dto.survey.SurveyElementDto;
import org.team200ok.togethergyeongju.dto.survey.SurveyListGetDto;
import org.team200ok.togethergyeongju.exception.HttpErrorException;
import org.team200ok.togethergyeongju.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SurveyService {
    private final SurveyRepository surveyRepository;
    private final SurveyOpinionRepository surveyOpinionRepository;
    private final SurveySatisfiedRepository surveySatisfiedRepository;
    private final SurveyPreferenceRepository surveyPreferenceRepository;
    private final UserSurveySatisfiedRepository userSurveySatisfiedRepository;

    private final int PAGE_SIZE = 10;


    public SurveyListGetDto getList(PolicyCategory policyCategory, Long cursor, User user) {
        Pageable commentPageable = PageRequest.of(0, PAGE_SIZE);

        Page<Survey> surveyPage;

        if (cursor != null) {
            Survey foundSurvey = surveyRepository.findById(cursor)
                    .orElseThrow(() -> new HttpErrorException(HttpErrorCode.NoSuchSurveyError));

            if (policyCategory == null) {
                surveyPage = surveyRepository.getSurveyByCursor(foundSurvey.getId(), foundSurvey.getCreatedAt(), commentPageable);
            } else {
                surveyPage = surveyRepository.getSurveyByCursorAndPolicyCategory(policyCategory, foundSurvey.getId(), foundSurvey.getCreatedAt(), commentPageable);
            }
        } else {
           if (policyCategory == null) {
               surveyPage = surveyRepository.findAll(commentPageable);
           } else {
               surveyPage = surveyRepository.findAllByPolicyCategory(policyCategory, commentPageable);
           }
        }

        List<SurveyElementDto> surveyElements = new ArrayList<>();

        for (Survey survey : surveyPage.getContent()) {
            if(survey.getSurveyType() == SurveyType.SURVEY_OPINION) {
                Optional<SurveyOpinion> surveyOpinionOptional = surveyOpinionRepository.findBySurvey(survey);
                surveyElements.add(SurveyElementDto.createOpinion(survey, surveyOpinionOptional.isPresent()));
            }

            if(survey.getSurveyType() == SurveyType.SURVEY_PREFERENCE) {
                Optional<SurveyPreference> surveyPreferenceOptional = surveyPreferenceRepository.findBySurvey(survey);
                surveyElements.add(SurveyElementDto.createPreference(survey, surveyPreferenceOptional.isPresent()));
            }

            if(survey.getSurveyType() == SurveyType.SURVEY_SATISFIED) {
                boolean isCompleted = false;
                List<SurveySatisfied> surveySatisfieds = surveySatisfiedRepository.findBySurvey(survey);

                for(SurveySatisfied surveySatisfied : surveySatisfieds) {
                    Optional<UserSurveySatisfied> userSurveySatisfiedOptional = userSurveySatisfiedRepository.findByUserAndSurveySatisfied(user, surveySatisfied);
                    isCompleted = userSurveySatisfiedOptional.isPresent();
                    if(isCompleted) {
                        break;
                    }
                }

                surveyElements.add(SurveyElementDto.createSatisfied(surveySatisfieds, isCompleted));
            }

        }

        return SurveyListGetDto.fromDto(surveyElements);
    }
}
