package views;

import controllers.AuthController;
import controllers.UserCourseController;
import models.user.User;
import java.util.Scanner;

public class UserView {

    private final Scanner scanner = new Scanner(System.in);
    private final AuthController authController;
    private final UserCourseController userCourseController = new UserCourseController();

    public UserView(AuthController authController) {
        this.authController = authController;
    }

    public void show() {
        User user = authController.currentUser();

        while (true) {
            System.out.println("\n=== USER MENU ===");
            System.out.println("1. Enroll Course");
            System.out.println("2. My Courses");
            System.out.println("3. Logout");
            System.out.print("Pilih: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> enrollCourse(user);
                case 2 -> userCourseController.findByUser(user.getIdString())
                        .forEach(uc ->
                                System.out.println(
                                        uc.getCourse().getTitle() +
                                                " [" + uc.getStatus() + "]"
                                ));
                case 3 -> {
                    authController.logout();
                    return;
                }
                default -> System.out.println("Menu tidak valid");
            }
        }
    }

    private void enrollCourse(User user) {
        System.out.print("Course ID: ");
        String courseId = scanner.nextLine();

        userCourseController.enroll(
                user.getIdString(),
                user.getUserType(),
                courseId
        );

        System.out.println("Berhasil enroll course");
    }
}
