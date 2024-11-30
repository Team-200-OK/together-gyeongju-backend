package org.team200ok.togethergyeongju.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@EntityListeners(AuditingEntityListener.class)
public class SurveySatisfied {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Survey survey;

    @Column(nullable = false)
    private String item;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public static SurveySatisfied of(Survey survey, String item) {
        return SurveySatisfied.builder()
                .survey(survey)
                .item(item)
                .build();
    }
}
