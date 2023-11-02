package com.rokwonk.dto.response;

import java.util.List;

public record MentorListResponse(
        List<MentorResponse> result
) {
}
