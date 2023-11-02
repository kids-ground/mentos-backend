package com.rokwonk.dto.request;

import java.util.List;

public record MentorListRequest(
        Long curosr,
        List<Long> ids
) {
}
