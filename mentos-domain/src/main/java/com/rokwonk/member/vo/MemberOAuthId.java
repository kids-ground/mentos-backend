package com.rokwonk.member.vo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class MemberOAuthId implements Serializable {
    @Column(name = "oauth_type")
    @Enumerated(EnumType.STRING)
    private MemberOAuthType oauthType;

    private String oauthId;
}
