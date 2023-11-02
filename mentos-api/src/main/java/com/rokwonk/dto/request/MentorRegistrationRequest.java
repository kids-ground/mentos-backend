package com.rokwonk.dto.request;

public record MentorRegistrationRequest(
        String introduce,
        String description,
        String kakaoChatLink,
        Integer careerYears,
        Integer jobGroup,
        String jobDetail
) {
}
