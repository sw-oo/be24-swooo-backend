package org.example.be24swooobackend.upload;

import lombok.RequiredArgsConstructor;
import org.example.be24swooobackend.feed.FeedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/upload/images")
@RequiredArgsConstructor
@RestController
public class UploadController {
    private final CloudUploadService uploadService;

    @PostMapping
    public ResponseEntity uploadImages(@RequestParam List<MultipartFile> files) {
        return ResponseEntity.ok(uploadService.upload(files));
    }

}
