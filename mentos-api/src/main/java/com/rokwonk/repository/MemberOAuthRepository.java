package com.rokwonk.repository;

import com.rokwonk.member.MemberOAuth;
import com.rokwonk.member.vo.MemberOAuthId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberOAuthRepository extends JpaRepository<MemberOAuth, MemberOAuthId> {
}
