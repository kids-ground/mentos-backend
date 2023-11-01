package com.rokwonk.mentor;


import com.rokwonk.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "mentor")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mentor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "mentor_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_group_id")
    private JobGroup jobGroup;

    @Column(columnDefinition = "TEXT")
    private String introduce;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 30)
    private String jobDetail;

    @Column(columnDefinition = "TEXT")
    private String kakaoChatLink;

    private Integer bookmarkCount;
    private Integer mentoringCount;
    private Integer reviewCount;
    private Double reviewScore;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "mentor_id")
    private List<MentoringReview> mentoringReviewList;
}
