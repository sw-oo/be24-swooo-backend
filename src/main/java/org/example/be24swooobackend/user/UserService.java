package org.example.be24swooobackend.user;

import lombok.RequiredArgsConstructor;
import org.example.be24swooobackend.user.model.AuthUserDetails;
import org.example.be24swooobackend.user.model.User;
import org.example.be24swooobackend.user.model.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDto.CreateRes save(UserDto.CreateReq dto) {
        User user = dto.toEntity();
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return UserDto.CreateRes.from(userRepository.save(user));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow();

        return AuthUserDetails.from(user);
    }
}
