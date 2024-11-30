package org.team200ok.togethergyeongju.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@EntityListeners(AuditingEntityListener.class)
public class UserSurveySatisfied {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SurveySatisfied surveySatisfied;

    @ManyToOne
    private User user;

    @CreatedDate
    private LocalDateTime createdAt;

    public static UserSurveySatisfied of(User user, SurveySatisfied surveySatisfied) {
        return UserSurveySatisfied.builder()
                .user(user)
                .surveySatisfied(surveySatisfied)
                .build();
    }
}
