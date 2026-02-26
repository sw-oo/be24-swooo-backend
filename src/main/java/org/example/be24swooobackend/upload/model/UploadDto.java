package org.example.be24swooobackend.upload.model;

import lombok.Builder;
import lombok.Getter;

public class UploadDto {
    @Getter
    @Builder
    public static class UploadRes {
        private Long idx;
        private String imageUrl;

        public static UploadRes from(Upload entity) {
            return UploadRes.builder()
                    .idx(entity.getIdx())
                    .imageUrl(entity.getImageUrl())
                    .build();
        }
    }
}
