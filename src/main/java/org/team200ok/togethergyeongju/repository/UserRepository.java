package org.team200ok.togethergyeongju.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team200ok.togethergyeongju.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findBySnsId(String snsId);
}
