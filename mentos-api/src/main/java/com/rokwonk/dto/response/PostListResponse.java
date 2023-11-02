package com.rokwonk.dto.response;

import java.util.List;

public record PostListResponse(
        List<PostResponse> result
) {
}
