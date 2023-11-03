package com.rokwonk.controller;

import com.rokwonk.common.annotation.RequestUser;
import com.rokwonk.dto.internal.UserInfo;
import com.rokwonk.dto.request.AuthEmailRequest;
import com.rokwonk.dto.request.MentorListRequest;
import com.rokwonk.dto.request.MentorModifyRequest;
import com.rokwonk.dto.request.MentorRegistrationRequest;
import com.rokwonk.dto.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentors")
@RequiredArgsConstructor
public class MentorController {
    @PostMapping
    public ResponseEntity<MentorRegistrationResponse> mentorRegistration(
            @RequestUser UserInfo requestUser,
            @RequestBody MentorRegistrationRequest request
    ) {
        return ResponseEntity.ok(new MentorRegistrationResponse(1L));
    }

    @PatchMapping
    public ResponseEntity<SimpleResponse> modifyMentorInfo(
            @RequestUser UserInfo requestUser,
            @RequestBody MentorModifyRequest request
    ) {
        return ResponseEntity.ok(new SimpleResponse(200, "성공"));
    }

    @GetMapping("/{mentorId}")
    public ResponseEntity<MentorResponse> getMentorInfo(
            @RequestUser UserInfo requestUser,
            @PathVariable(name = "mentorId") Long mentorId
    ) {
        return ResponseEntity.ok(new MentorResponse(
                1L,
                "저는 구글에서 백엔드 엔지니어로 일하고 있습니다.",
                "저에대한 설명은 문의주시며 자세하게 해드릴게요. 말씀드릴게 많아서요ㅎㅎ",
                "https://open.kakao.com/o/slMRPgQf",
                1L,
                "백엔드 개발자",
                8,
                3,
                0,
                0,
                0D,
                // MemberResponse
                new MemberResponse(
                        1L,
                        "로건",
                        "https://images.velog.io/images/chang626/post/c9533c4f-adbb-4411-bce4-b09293d64fbf/A03EACB4-4DFA-439A-A3FE-084635A89FE6.png",
                        "https://images.velog.io/images/chang626/post/c9533c4f-adbb-4411-bce4-b09293d64fbf/A03EACB4-4DFA-439A-A3FE-084635A89FE6.png",
                        true,
                        "Googole",
                        "DevOps"
                )
        ));
    }

    @GetMapping
    public ResponseEntity<MentorListResponse> getMentorList(
            @RequestUser UserInfo requestUser,
            MentorListRequest request
    ) {
        return ResponseEntity.ok(new MentorListResponse(
                List.of(
                        new MentorResponse(
                                1L,
                                "저는 구글에서 백엔드 엔지니어로 일하고 있습니다.",
                                "저에대한 설명은 문의주시며 자세하게 해드릴게요. 말씀드릴게 많아서요ㅎㅎ",
                                "https://open.kakao.com/o/slMRPgQf",
                                1L,
                                "백엔드 개발자",
                                8,
                                3,
                                0,
                                0,
                                0D,
                                // MemberResponse
                                new MemberResponse(
                                        1L,
                                        "로건",
                                        "https://images.velog.io/images/chang626/post/c9533c4f-adbb-4411-bce4-b09293d64fbf/A03EACB4-4DFA-439A-A3FE-084635A89FE6.png",
                                        "https://images.velog.io/images/chang626/post/c9533c4f-adbb-4411-bce4-b09293d64fbf/A03EACB4-4DFA-439A-A3FE-084635A89FE6.png",
                                        true,
                                        "Googole",
                                        "DevOps"
                                )
                        ),
                        new MentorResponse(
                                2L,
                                "메타에서 DevOps 엔지니어로 일하고 있습니다.",
                                "DevOps에 대해 궁금하신 분, 메타에 대해서 궁금하신 분 모두 환영입니다. 연락주세요!",
                                "https://open.kakao.com/o/slMRPgQf",
                                1L,
                                "DevOps",
                                5,
                                12,
                                0,
                                0,
                                0D,
                                new MemberResponse(
                                        2L,
                                        "데브웁스 시니어",
                                        "https://www.techm.kr/news/photo/202107/86116_89522_1929.png",
                                        "https://www.techm.kr/news/photo/202107/86116_89522_1929.png",
                                        true,
                                        "Meta",
                                        "DevOps"
                                )
                        )
                )
        ));
    }
}
