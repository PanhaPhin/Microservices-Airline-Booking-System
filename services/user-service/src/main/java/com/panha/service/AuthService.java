package com.panha.service;

import com.panha.payload.dto.UserDTO;
import com.panha.payload.response.AuthResponse;

public interface AuthService {

    AuthResponse login(String email, String password);

    AuthResponse signup(UserDTO req) throws Exception;
}