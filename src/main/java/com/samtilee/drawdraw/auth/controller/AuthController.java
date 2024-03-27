package com.samtilee.drawdraw.auth.controller;

import com.samtilee.drawdraw.auth.service.AuthService;
import com.samtilee.drawdraw.common.dto.Response;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import static com.samtilee.drawdraw.auth.message.SuccessMessage.SUCCESS_SIGN_IN;
import static com.samtilee.drawdraw.auth.message.SuccessMessage.SUCCESS_SIGN_OUT;
import static com.samtilee.drawdraw.common.dto.Response.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<Response> signIn(@RequestHeader("Authorization") String socialAccessToken) {
        val response = authService.signIn(socialAccessToken);
        return ResponseEntity.ok(success(SUCCESS_SIGN_IN.getMessage(), response));
    }

    @PostMapping("/logout")
    public ResponseEntity<Response> signOut(Principal principal) {
        val memberId = Long.parseLong(principal.getName());
        authService.signOut(memberId);
        return ResponseEntity.ok(success(SUCCESS_SIGN_OUT.getMessage()));
    }
}
