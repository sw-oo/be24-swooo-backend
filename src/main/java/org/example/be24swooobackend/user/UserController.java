package org.example.be24swooobackend.user;

import lombok.RequiredArgsConstructor;
import org.example.be24swooobackend.user.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity create(@RequestBody UserDto.CreateReq dto) {
        UserDto.CreateRes res = userService.save(dto);
        return ResponseEntity.ok().body(res);
    }
}
