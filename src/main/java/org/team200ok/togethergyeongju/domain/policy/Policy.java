package org.team200ok.togethergyeongju.domain.policy;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.team200ok.togethergyeongju.constant.JobCategory;
import org.team200ok.togethergyeongju.domain.User;

import java.time.LocalDateTime;

@Entity(name = "policy")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private JobCategory jobCategory;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String summary;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    @CreatedDate
    private LocalDateTime createdAt;

}
