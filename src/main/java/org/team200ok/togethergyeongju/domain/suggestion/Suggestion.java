package org.team200ok.togethergyeongju.domain.suggestion;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.team200ok.togethergyeongju.constant.PolicyCategory;
import org.team200ok.togethergyeongju.domain.User;
import org.team200ok.togethergyeongju.dto.suggestion.save.SuggestionSaveRequestDto;

import java.time.LocalDateTime;

@Entity(name = "suggestion")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private PolicyCategory policyCategory;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String description;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public static Suggestion of(User user, SuggestionSaveRequestDto suggestionSaveRequestDto) {

        return Suggestion.builder()
                .title(suggestionSaveRequestDto.getTitle())
                .policyCategory(suggestionSaveRequestDto.getPolicyCategory())
                .description(suggestionSaveRequestDto.getDescription())
                .user(user)
                .build();

    }
}
