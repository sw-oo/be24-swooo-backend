package org.example.be24swooobackend.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UserDto {

    @Getter
    public static class CreateReq{
        private String email;
        private String name;
        private String password;

        public User toEntity() {
            return User.builder()
                    .email(getEmail())
                    .name(getName())
                    .password(getPassword())
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class CreateRes {
        private Long idx;
        private String email;
        private String name;

        public static CreateRes from(User entity) {
            return CreateRes.builder()
                    .idx(entity.getIdx())
                    .email(entity.getEmail())
                    .name(entity.getName())
                    .build();
        }
    }

    @Getter
    public static class LoginReq {
        private String email;
        private String password;
    }

    @Builder
    @Getter
    public static class LoginRes {
        private Long idx;
        private String email;
        private String name;

        public static LoginRes from(AuthUserDetails entity) {
            return LoginRes.builder()
                    .idx(entity.getIdx())
                    .email(entity.getEmail())
                    .name(entity.getName())
                    .build();
        }
    }
}
