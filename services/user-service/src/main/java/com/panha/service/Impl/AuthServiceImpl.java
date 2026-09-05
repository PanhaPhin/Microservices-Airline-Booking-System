package com.panha.service.Impl;

import com.panha.enums.UserRole;
import com.panha.model.User;
import com.panha.payload.dto.UserDTO;
import com.panha.payload.response.AuthResponse;
import com.panha.respoitory.UserRepository;
import com.panha.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;




    @Override
    public AuthResponse login(String email, String password) {


        return null;
    }

    @Override
    public AuthResponse signup(UserDTO req) throws Exception {
        User existingUser = userRepository.findByEmail(req.getEmail());
        if(existingUser!=null){
            throw new Exception("email already registered !");

        }
        if(req.getRole()== UserRole.ROLE_SYSTEM_ADMIN){
            throw new Exception("You cannot sign up system admins!");
        }


        User newUser = User.builder()
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .phone(req.getPhone())
                .role(req.getRole())
                .fullName(req.getFullName())
                .lastLogin(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        User savedUser= userRepository.save(newUser);
        return null;
    }
}