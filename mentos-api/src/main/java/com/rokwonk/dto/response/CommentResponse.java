package com.rokwonk.dto.response;

import com.rokwonk.member.Member;
import com.rokwonk.post.Comment;

import java.time.LocalDateTime;

public record CommentResponse(
        Long commentId,
        String content,
        LocalDateTime createdAt,
        MemberResponse writer,
        MemberResponse taggedMember
) {
    public CommentResponse(Comment comment) {
        this(
                comment.getId(),
                comment.getContent(),
                comment.getCreatedAt(),
                new MemberResponse(comment.getWriter()),
                comment.getTaggedMember() != null ? new MemberResponse(comment.getTaggedMember()) : null
        );
    }
}
