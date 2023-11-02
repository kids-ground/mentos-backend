package com.rokwonk.dto.request;

public record CommentWriteRequest(
        String content,
        Long taggingMemberId
) {
}
