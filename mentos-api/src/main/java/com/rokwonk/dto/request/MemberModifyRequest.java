package com.rokwonk.dto.request;

public record MemberModifyRequest(
        String nickname,
        String profileUrl
) {
}
