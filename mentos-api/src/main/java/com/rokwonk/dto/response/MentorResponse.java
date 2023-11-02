package com.rokwonk.dto.response;

import com.rokwonk.mentor.Mentor;

public record MentorResponse(
        Long mentorId,
        String introduce,
        String description,
        String kakaoChatLink,
        Long jobGroup,
        String jobDetail,
        Integer careerYears,
        Integer bookmarkCount,
        Integer reviewCount,
        Integer mentoringCount,
        Double reviewScore,
        // MemberResponse
        MemberResponse member
) {
    public MentorResponse(Mentor mentor) {
        this(
                mentor.getId(),
                mentor.getIntroduce(),
                mentor.getDescription(),
                mentor.getKakaoChatLink(),
                mentor.getJobGroup().getId(),
                mentor.getJobDetail(),
                mentor.getCareerYears(),
                mentor.getBookmarkCount(),
                mentor.getReviewCount(),
                mentor.getMentoringCount(),
                mentor.getReviewScore(),
                new MemberResponse(mentor.getMember())
        );
    }
}
