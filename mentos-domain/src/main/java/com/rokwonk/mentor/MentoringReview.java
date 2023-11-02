package com.rokwonk.mentor;


import com.rokwonk.common.entity.BaseTimeEntity;
import com.rokwonk.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "mentoring_review")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MentoringReview extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "mentoring_review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

    private Double score;

    @Column(columnDefinition = "TEXT")
    private String description;
}
