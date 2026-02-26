package org.example.be24swooobackend.feed.model;

import lombok.Builder;
import lombok.Getter;
import org.example.be24swooobackend.upload.model.Upload;
import org.example.be24swooobackend.user.model.User;

import java.util.List;

public class FeedDto {

    @Getter
    public static class CreateReq {
        private String contents;
        private List<Upload> uploadList;

        public Feed toEntity(User user) {
            return Feed.builder()
                    .contents(getContents())
                    .user(user)
                    .uploadList(getUploadList())
                    .build();
        }
    }

    @Getter
    @Builder
    public static class ListReq {

    }
}
