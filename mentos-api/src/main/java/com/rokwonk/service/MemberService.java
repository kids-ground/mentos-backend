package com.rokwonk.service;

import com.rokwonk.dto.request.LoginType;
import com.rokwonk.member.Member;
import com.rokwonk.member.MemberDevice;
import com.rokwonk.member.MemberOAuth;
import com.rokwonk.member.vo.MemberOAuthId;
import com.rokwonk.member.vo.MemberProfileImage;
import com.rokwonk.repository.MemberDeviceRepository;
import com.rokwonk.repository.MemberOAuthRepository;
import com.rokwonk.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberOAuthRepository memberOAuthRepository;
    private final MemberDeviceRepository memberDeviceRepository;

    @Transactional
    Optional<Long> getMemberByOAuth(LoginType oauthType, String id) {
        MemberOAuthId memberOAuthId = new MemberOAuthId(oauthType.toOAuthType(), id);
        MemberOAuth memberOAuth = memberOAuthRepository.findById(memberOAuthId).orElse(null);

        if (memberOAuth == null) return Optional.empty();
        Long memberId = memberOAuth.getMember().getId();

        return Optional.of(memberId);
    }

    @Transactional
    public Long createMember(LoginType oauthType, String id) {
        MemberOAuthId memberOAuthId = new MemberOAuthId(oauthType.toOAuthType(), id);
        Member member = Member.builder()
                .profileImage(new MemberProfileImage())
                .nickname("뉴유저")
                .build();

        memberRepository.save(member);
        memberOAuthRepository.save(
                MemberOAuth.builder()
                        .oauth(memberOAuthId)
                        .member(member)
                        .build()
        );
        memberDeviceRepository.save(
                MemberDevice.builder()
                        .member(member)
                        .build()
        );

        return member.getId();
    }
}
