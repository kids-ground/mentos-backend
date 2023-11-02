package com.rokwonk.dto.response;

import java.util.List;

public record CommentListResponse(
        List<CommentResponse> result
) {
}
