package views;

import controllers.AuthController;
import controllers.CourseController;
import java.util.Scanner;

public class AdminView {

    private final Scanner scanner = new Scanner(System.in);
    private final CourseController courseController = new CourseController();
    private final AuthController authController;

    public AdminView(AuthController authController) {
        this.authController = authController;
    }

    public void show() {
        while (true) {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1. Create Course");
            System.out.println("2. List Courses");
            System.out.println("3. Logout");
            System.out.print("Pilih: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> createCourse();
                case 2 -> courseController.findAll()
                        .forEach(c -> System.out.println(c.getId() + " - " + c.getTitle()));
                case 3 -> {
                    authController.logout();
                    return;
                }
                default -> System.out.println("Menu tidak valid");
            }
        }
    }

    private void createCourse() {
        System.out.print("ID       : ");
        String id = scanner.nextLine();
        System.out.print("Title    : ");
        String title = scanner.nextLine();
        System.out.print("Desc     : ");
        String desc = scanner.nextLine();
        System.out.print("Credits  : ");
        int credits = scanner.nextInt();
        scanner.nextLine();

        courseController.create(id, title, desc, credits);
        System.out.println("Course berhasil dibuat");
    }
}
