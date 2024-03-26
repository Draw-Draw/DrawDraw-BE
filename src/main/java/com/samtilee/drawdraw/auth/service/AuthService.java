package com.samtilee.drawdraw.auth.service;

import com.samtilee.drawdraw.auth.dto.response.SignInResponse;

public interface AuthService {

    SignInResponse signIn(String socialAccessToken);
}
