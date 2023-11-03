package com.rokwonk.member;

import com.rokwonk.member.vo.MemberOAuthId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member_oauth")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberOAuth {

    @EmbeddedId
    private MemberOAuthId oauth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
