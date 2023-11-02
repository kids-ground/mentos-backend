package com.rokwonk.dto.request;

import java.util.List;

public record PostWriteRequest(
        List<String> tags,
        String title,
        String description
) {
}
