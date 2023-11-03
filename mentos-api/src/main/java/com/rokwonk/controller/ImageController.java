package com.rokwonk.controller;

import com.rokwonk.common.annotation.RequestUser;
import com.rokwonk.dto.internal.UserInfo;
import com.rokwonk.dto.response.ImageUrlUploadResponse;
import com.rokwonk.dto.response.SimpleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {
    @GetMapping("/url")
    public ResponseEntity<ImageUrlUploadResponse> getPreSignUrl(
            @RequestUser UserInfo requestUser
    ) {
        return ResponseEntity.ok(new ImageUrlUploadResponse("https://aaaaaaa.com"));
    }

    @GetMapping("/upload")
    public ResponseEntity<SimpleResponse> uploadImage(
            @RequestUser UserInfo requestUser,
            @RequestPart MultipartFile image
    ) {
        return ResponseEntity.ok(new SimpleResponse(200, "업로드 성공"));
    }
}
