package org.example.be24swooobackend.feed.model;

import lombok.Builder;
import lombok.Getter;
import org.example.be24swooobackend.user.model.User;

public class FeedDto {

    @Getter
    public static class CreateReq {
        private String contents;

        public Feed toEntity(User user) {
            return Feed.builder()
                    .contents(getContents())
                    .user(user)
                    .build();
        }
    }

    @Getter
    @Builder
    public static class ListReq {

    }
}
