import controllers.AuthController;
import models.user.User;
import models.user.UserType;
import services.AuthService;
import views.AdminView;
import views.AnonymusView;
import views.UserView;

public class Main {

    public static void main(String[] args) {

        AuthService authService = new AuthService();
        AuthController authController = new AuthController(authService);

        AdminView adminView = new AdminView(authController);
        UserView userView = new UserView(authController);
        AnonymusView anonymusView = new AnonymusView(authController);

        while (true) {
            User currentUser = authController.currentUser();

            if (currentUser == null) {
                anonymusView.show();
                continue;
            }

            if (currentUser.getUserType() == UserType.ADMIN) {
                adminView.show();
                continue;
            }

            if (currentUser.getUserType() == UserType.STUDENT) {
                userView.show();
            }
        }
    }
}
