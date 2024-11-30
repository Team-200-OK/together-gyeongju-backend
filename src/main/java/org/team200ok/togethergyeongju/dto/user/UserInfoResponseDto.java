package org.team200ok.togethergyeongju.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.constant.Gender;
import org.team200ok.togethergyeongju.constant.JobCategory;
import org.team200ok.togethergyeongju.constant.SnsType;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class UserInfoResponseDto {
    private SnsType snsType;

    private String name;

    private String profileImage;

    private String email;

    private int age;

    private JobCategory jobCategory;

    private Gender gender;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static UserInfoResponseDto fromDto(UserInfoDto dto) {
        return UserInfoResponseDto.builder()
                .snsType(dto.getSnsType())
                .name(dto.getName())
                .age(dto.getAge())
                .jobCategory(dto.getJobCategory())
                .gender(dto.getGender())
                .profileImage(dto.getProfileImage())
                .email(dto.getEmail())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }
}
