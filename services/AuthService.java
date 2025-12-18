package services;
import models.user.User;
import models.user.UserType;
import java.util.List;

public class AuthService {

    private User currentUser;

    private final UserService userService = new UserService();

    public User login(String email, String password, UserType type) {
        List<? extends User> users = userService.findAll(type);

        for (User user : users) {
            if (user.getEmail().equals(email)
                    && user.getPassword().equals(password)) {

                currentUser = user;
                return user;
            }
        }
        return this.currentUser;
    }

    public void logout() {
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isAuthenticated() {
        return currentUser != null;
    }
}
