package org.example.be24swooobackend.user;

import lombok.RequiredArgsConstructor;
import org.example.be24swooobackend.user.model.UserDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserDto.CreateRes save(UserDto.CreateReq dto) {
        return UserDto.CreateRes.from(userRepository.save(dto.toEntity()));
    }
}
