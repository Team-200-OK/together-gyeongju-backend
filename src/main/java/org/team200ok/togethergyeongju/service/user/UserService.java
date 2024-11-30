package org.team200ok.togethergyeongju.service.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.team200ok.togethergyeongju.domain.User;
import org.team200ok.togethergyeongju.dto.user.UserInfoDto;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    public UserInfoDto getUserInfo(User user) {
        return UserInfoDto.fromEntity(user);
    }
}
