package com.rokwonk.dto.request;

public record MentorModifyRequest(
        String introduce,
        String description,
        String kakaoChatLink,
        Integer careerYears,
        Integer jobGroup,
        String jobDetail
) {
}
