package org.example.be24swooobackend.user;

import lombok.RequiredArgsConstructor;
import org.example.be24swooobackend.user.model.AuthUserDetails;
import org.example.be24swooobackend.user.model.UserDto;
import org.example.be24swooobackend.utils.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity create(@RequestBody UserDto.CreateReq dto) {
        UserDto.CreateRes res = userService.save(dto);
        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDto.LoginReq dto) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword(), null);

        Authentication authentication = authenticationManager.authenticate(token);
        AuthUserDetails user = (AuthUserDetails) authentication.getPrincipal();

        if(user != null) {
            String jwt = JwtUtil.createToken(user.getIdx(), user.getUsername(), user.getName(), "ROLE_USER");
            return ResponseEntity.ok().header("Set-Cookie", "ATOKEN=" + jwt + "; Path=/").body(UserDto.LoginRes.from(user));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
    }
}
