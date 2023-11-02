package com.rokwonk.dto.response;

import com.rokwonk.member.Member;

public record MemberResponse(
        Long id,
        String nickname,
        String profileUrl,
        String thumbnailUrl,
        Boolean alarmOn,
        String currentCorporationName,
        String currentJobDetail
) {
    public MemberResponse(Member member) {
        this(
                member.getId(),
                member.getNickname(),
                member.getProfileImage().getProfileUrl(),
                member.getProfileImage().getThumbnailUrl(),
                member.getAlarmOn(),
                member.getCurrentCorporationName(),
                member.getCurrentJobDetail()
        );
    }
}
