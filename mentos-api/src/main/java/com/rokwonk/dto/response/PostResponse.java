package com.rokwonk.dto.response;

import com.rokwonk.post.Post;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public record PostResponse(
        Long postId,
        List<String> tags,
        String title,
        String description,
        Integer hit,
        Integer commentCount,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        MemberResponse writer
) {
    public PostResponse(Post post) {
        this(
                post.getId(),
                Arrays.stream(post.getTags().split(",")).toList(),
                post.getTitle(),
                post.getDescription(),
                post.getHit(),
                post.getCommentCount(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                new MemberResponse(post.getMember())
        );
    }
}
