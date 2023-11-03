package com.rokwonk.controller;


import com.rokwonk.common.annotation.RequestUser;
import com.rokwonk.dto.internal.UserInfo;
import com.rokwonk.dto.request.AuthEmailRequest;
import com.rokwonk.dto.request.CommentWriteRequest;
import com.rokwonk.dto.request.PostListRequest;
import com.rokwonk.dto.request.PostWriteRequest;
import com.rokwonk.dto.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    @PostMapping
    public ResponseEntity<PostWriteResponse> createPost(
            @RequestUser UserInfo requestUser,
            @RequestBody PostWriteRequest request
    ) {
        return ResponseEntity.ok(new PostWriteResponse(1L));
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<SimpleResponse> modifyPost(
            @RequestUser UserInfo requestUser,
            @PathVariable(name = "postId") Long postId,
            @RequestBody PostWriteRequest request
    ) {
        return ResponseEntity.ok(new SimpleResponse(200, "게시글 수정 완료"));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<SimpleResponse> deletePost(
            @RequestUser UserInfo requestUser,
            @PathVariable(name = "postId") Long postId
    ) {
        return ResponseEntity.ok(new SimpleResponse(200, "게시글 삭제 완료"));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> getOnePost(
            @RequestUser UserInfo requestUser,
            @PathVariable(name = "postId") Long postId
    ) {
        return ResponseEntity.ok(new PostResponse(
                1L,
                List.of("구글", "실리콘밸리"),
                "실리콘밸리에서 일하고 싶습니다.",
                "실리콘 밸리에서 일하고 싶은데 어디서부터 어떻게 공부해야할지 모르겠습니다. 누구 아시는 분 있으시다면 도움을 주세요!!",
                12,
                3,
                LocalDateTime.now(),
                LocalDateTime.now(),
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
    public ResponseEntity<PostListResponse> getPostList(
            @RequestUser UserInfo requestUser,
            PostListRequest request
    ) {
        return ResponseEntity.ok(new PostListResponse(
                List.of(
                        new PostResponse(
                                1L,
                                List.of("구글", "실리콘밸리"),
                                "실리콘밸리에서 일하고 싶습니다.",
                                "실리콘 밸리에서 일하고 싶은데 어디서부터 어떻게 공부해야할지 모르겠습니다. 누구 아시는 분 있으시다면 도움을 주세요!!",
                                12,
                                3,
                                LocalDateTime.now(),
                                LocalDateTime.now(),
                                new MemberResponse(
                                        1L,
                                        "로건",
                                        "https://images.velog.io/images/chang626/post/c9533c4f-adbb-4411-bce4-b09293d64fbf/A03EACB4-4DFA-439A-A3FE-084635A89FE6.png",
                                        "https://images.velog.io/images/chang626/post/c9533c4f-adbb-4411-bce4-b09293d64fbf/A03EACB4-4DFA-439A-A3FE-084635A89FE6.png",
                                        true,
                                        "Googole",
                                        "백엔드"
                                )
                        ),
                        new PostResponse(
                                2L,
                                List.of("DevOps", "AWS"),
                                "시니어 DevOps 멘토 분 계신가요?",
                                "DevOps로 현업에 일하고 있는데 조언을 받고 싶어서요! 어려운게 너무 많은 분야인거 같아요ㅠㅜ",
                                32,
                                1,
                                LocalDateTime.now(),
                                LocalDateTime.now(),
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

    @PostMapping("/{postId}/comments")
    public ResponseEntity<CommentWriteResponse> createComment(
            @RequestUser UserInfo requestUser,
            @PathVariable(name = "postId") Long postId,
            @RequestBody CommentWriteRequest request
    ) {
        return ResponseEntity.ok(new CommentWriteResponse(1L));
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<CommentListResponse> getCommentList(
            @RequestUser UserInfo requestUser,
            @PathVariable(name = "postId") Long postId
    ) {
        return ResponseEntity.ok(new CommentListResponse(
                List.of(
                        new CommentResponse(
                                1L,
                                "저도 구해요..",
                                LocalDateTime.now(),
                                new MemberResponse(
                                        1L,
                                        "로건",
                                        "https://images.velog.io/images/chang626/post/c9533c4f-adbb-4411-bce4-b09293d64fbf/A03EACB4-4DFA-439A-A3FE-084635A89FE6.png",
                                        "https://images.velog.io/images/chang626/post/c9533c4f-adbb-4411-bce4-b09293d64fbf/A03EACB4-4DFA-439A-A3FE-084635A89FE6.png",
                                        true,
                                        "Googole",
                                        "백엔드"
                                ),
                                null
                        ),
                        new CommentResponse(
                                2L,
                                "저랑 같은 분이 계셨군요ㅠㅍ",
                                LocalDateTime.now(),
                                new MemberResponse(
                                        2L,
                                        "데브웁스 시니어",
                                        "https://www.techm.kr/news/photo/202107/86116_89522_1929.png",
                                        "https://www.techm.kr/news/photo/202107/86116_89522_1929.png",
                                        true,
                                        "Meta",
                                        "DevOps"
                                ),
                                new MemberResponse(
                                        1L,
                                        "로건",
                                        "https://images.velog.io/images/chang626/post/c9533c4f-adbb-4411-bce4-b09293d64fbf/A03EACB4-4DFA-439A-A3FE-084635A89FE6.png",
                                        "https://images.velog.io/images/chang626/post/c9533c4f-adbb-4411-bce4-b09293d64fbf/A03EACB4-4DFA-439A-A3FE-084635A89FE6.png",
                                        true,
                                        "Googole",
                                        "백엔드"
                                )
                        )
                )
        ));
    }
}
