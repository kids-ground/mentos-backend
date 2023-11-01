package com.rokwonk.member.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberProfileImage {
    private String profileUrl;
    private String thumbnailUrl;
}