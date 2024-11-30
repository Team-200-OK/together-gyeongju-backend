package org.team200ok.togethergyeongju.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.team200ok.togethergyeongju.constant.Gender;
import org.team200ok.togethergyeongju.constant.JobCategory;
import org.team200ok.togethergyeongju.constant.SnsType;
import org.team200ok.togethergyeongju.domain.User;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class UserInfoDto {
    private SnsType snsType;

    private String name;

    private int age;

    private JobCategory jobCategory;

    private Gender gender;

    private String profileImage;

    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static UserInfoDto fromEntity(User user) {
        return UserInfoDto.builder()
                .snsType(user.getSnsType())
                .name(user.getName())
                .age(user.getAge())
                .jobCategory(user.getJobCategory())
                .gender(user.getGender())
                .profileImage(user.getProfileImage())
                .email(user.getEmail())
                .build();
    }
}
