package org.team200ok.togethergyeongju.service.policy;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.team200ok.togethergyeongju.config.HttpErrorCode;
import org.team200ok.togethergyeongju.domain.User;
import org.team200ok.togethergyeongju.domain.policy.Policy;
import org.team200ok.togethergyeongju.domain.policy.PolicyImage;
import org.team200ok.togethergyeongju.domain.policy.PolicyScrap;
import org.team200ok.togethergyeongju.dto.policy.detail.PolicyDetailResponseDto;
import org.team200ok.togethergyeongju.dto.policy.summary.PolicySummaryListDto;
import org.team200ok.togethergyeongju.dto.policy.summary.PolicySummaryListResponseDto;
import org.team200ok.togethergyeongju.exception.HttpErrorException;
import org.team200ok.togethergyeongju.repository.PolicyImageRepository;
import org.team200ok.togethergyeongju.repository.PolicyRepository;
import org.team200ok.togethergyeongju.repository.PolicyScrapRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PolicyService {

    private final int POLICY_PAGE_SIZE = 10;
    @Value("${file.upload.image.api}")
    private String imageApiUrl;

    private final PolicyRepository policyRepository;
    private final PolicyImageRepository policyImageRepository;
    private final PolicyScrapRepository policyScrapRepository;

    public PolicySummaryListResponseDto getPolicySummaryList(User user, Long cursor){

        Page<Policy> policyPage;

        Pageable policyPageable = PageRequest.of(0, POLICY_PAGE_SIZE);

        if(cursor != null){
            Policy foundPolicy = policyRepository.findByJobCategoryAndId(user.getJobCategory(), cursor);

            policyPage = policyRepository.getPoliciesByCursor(foundPolicy.getId(), foundPolicy.getCreatedAt(), policyPageable);

        }else {
            policyPage = policyRepository.findAllByJobCategory(user.getJobCategory(), policyPageable);
        }

        List<PolicySummaryListDto> policySummaryList = policyPage.map( policy ->
                    PolicySummaryListDto.of(policy,
                            policyImageRepository.findByPolicyId(policy.getId()),
                            policyScrapRepository.findByUserAndPolicy(user, policy)
                    )
            ).toList();

        return PolicySummaryListResponseDto.of(policySummaryList, imageApiUrl);

    }

    public PolicyDetailResponseDto getPolicyDetail(User user, Long policyId){

        Policy foundPolicy = policyRepository.findById(policyId)
                .orElseThrow(()-> new HttpErrorException(HttpErrorCode.PolicyNotFoundError));

        List<PolicyImage> foundImages = policyImageRepository.findByPolicyId(policyId);

        boolean scrapStatus;

        PolicyScrap foundPolicyScrap = policyScrapRepository.findByUserAndPolicy(user, foundPolicy);

        scrapStatus = foundPolicyScrap != null;

        return PolicyDetailResponseDto.of(foundPolicy, foundImages, imageApiUrl, scrapStatus);
    }

    @Transactional
    public String policyScrapToggle(User user, Long policyId){

        String responseMessage;

        Policy foundPolicy = policyRepository.findById(policyId)
                .orElseThrow(()-> new HttpErrorException(HttpErrorCode.PolicyNotFoundError));

        PolicyScrap foundScrapByUserAndPolicy = policyScrapRepository.findByUserAndPolicy(user, foundPolicy);

        if (foundScrapByUserAndPolicy == null){
            policyScrapRepository.save(PolicyScrap.of(user, foundPolicy));

            responseMessage = "정책을 스크랩하였습니다!";
        }else{

            policyScrapRepository.delete(foundScrapByUserAndPolicy);
            responseMessage = "정책의 스크랩을 취소하셨습니다!";
        }

        return responseMessage;

    }
}
