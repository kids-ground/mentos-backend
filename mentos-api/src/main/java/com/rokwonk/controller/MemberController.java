package com.rokwonk.controller;

import com.rokwonk.common.annotation.RequestUser;
import com.rokwonk.dto.internal.UserInfo;
import com.rokwonk.dto.request.AuthEmailRequest;
import com.rokwonk.dto.request.MemberModifyRequest;
import com.rokwonk.dto.request.NotificationSetRequest;
import com.rokwonk.dto.response.MemberResponse;
import com.rokwonk.dto.response.SimpleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    @GetMapping
    public ResponseEntity<MemberResponse> getMemberInfo(
        @RequestUser UserInfo requestUser
    ) {
        return ResponseEntity.ok(new MemberResponse(
                1L,
                "로건",
                "https://images.velog.io/images/chang626/post/c9533c4f-adbb-4411-bce4-b09293d64fbf/A03EACB4-4DFA-439A-A3FE-084635A89FE6.png",
                "https://images.velog.io/images/chang626/post/c9533c4f-adbb-4411-bce4-b09293d64fbf/A03EACB4-4DFA-439A-A3FE-084635A89FE6.png",
                true,
                "Googole",
                "DevOps"
        ));
    }

    @PatchMapping
    public ResponseEntity<MemberResponse> modifyMemberInfo(
        @RequestUser UserInfo requestUser,
        @RequestBody MemberModifyRequest request
    ) {
        return ResponseEntity.ok(new MemberResponse(
                1L,
                "로건",
                "https://images.velog.io/images/chang626/post/c9533c4f-adbb-4411-bce4-b09293d64fbf/A03EACB4-4DFA-439A-A3FE-084635A89FE6.png",
                "https://images.velog.io/images/chang626/post/c9533c4f-adbb-4411-bce4-b09293d64fbf/A03EACB4-4DFA-439A-A3FE-084635A89FE6.png",
                true,
                "Googole",
                "DevOps"
        ));
    }

    @DeleteMapping
    public ResponseEntity<SimpleResponse> deleteMember(
        @RequestUser UserInfo requestUser
    ) {
        return ResponseEntity.ok(new SimpleResponse(200, "회원탈퇴"));
    }

    @PostMapping("/notifications")
    public ResponseEntity<SimpleResponse> setAlarmOn(
        @RequestUser UserInfo requestUser,
        @RequestBody NotificationSetRequest request
    ) {
        return ResponseEntity.ok(new SimpleResponse(200, "회원탈퇴"));
    }
}
