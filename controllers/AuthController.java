package controllers;

import services.AuthService;
import models.user.*;

public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public User login(String email, String password, UserType type) {
        return authService.login(email, password, type);
    }

    public void logout() {
        authService.logout();
    }

    public User currentUser() {
        return authService.getCurrentUser();
    }
}
