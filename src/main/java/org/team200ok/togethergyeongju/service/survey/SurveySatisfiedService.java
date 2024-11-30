package org.team200ok.togethergyeongju.service.survey;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.team200ok.togethergyeongju.config.HttpErrorCode;
import org.team200ok.togethergyeongju.domain.Survey;
import org.team200ok.togethergyeongju.domain.SurveySatisfied;
import org.team200ok.togethergyeongju.domain.User;
import org.team200ok.togethergyeongju.domain.UserSurveySatisfied;
import org.team200ok.togethergyeongju.dto.survey.satisfied.SurveySatisfiedCreateDto;
import org.team200ok.togethergyeongju.dto.survey.satisfied.SurveySatisfiedCreateRequestDto;
import org.team200ok.togethergyeongju.dto.survey.satisfied.SurveySatisfiedEnrollDto;
import org.team200ok.togethergyeongju.exception.HttpErrorException;
import org.team200ok.togethergyeongju.repository.SurveyRepository;
import org.team200ok.togethergyeongju.repository.SurveySatisfiedRepository;
import org.team200ok.togethergyeongju.repository.UserSurveySatisfiedRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SurveySatisfiedService {
    private final SurveyRepository surveyRepository;
    private final SurveySatisfiedRepository surveySatisfiedRepository;
    private final UserSurveySatisfiedRepository userSurveySatisfiedRepository;

    public SurveySatisfiedCreateDto createSurveySatisfied(SurveySatisfiedCreateRequestDto requestDto) {
        Survey savedPreference = surveyRepository.save(Survey.createSurveySatisfied(requestDto));
        List<SurveySatisfied> surveySatisfiedList = new ArrayList<>();

        for (String item : requestDto.getItems()) {
            surveySatisfiedList.add(surveySatisfiedRepository.save(SurveySatisfied.of(savedPreference, item)));
        }

        return SurveySatisfiedCreateDto.from(surveySatisfiedList);
    }

    public SurveySatisfiedEnrollDto enroll(Long satisfiedId, User user) {
        SurveySatisfied foundSurveySatisfied = surveySatisfiedRepository.findById(satisfiedId).orElseThrow(() -> new HttpErrorException(HttpErrorCode.NoSuchSurveySatisfiedError));
        UserSurveySatisfied savedUserSurveySatisfied = userSurveySatisfiedRepository.save(UserSurveySatisfied.of(user, foundSurveySatisfied));
        return SurveySatisfiedEnrollDto.of(savedUserSurveySatisfied);
    }
}
