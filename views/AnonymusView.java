package views;

import controllers.AuthController;
import controllers.CourseController;
import models.course.Course;
import models.user.UserType;
import java.util.List;
import java.util.Scanner;

public class AnonymusView {

    private final Scanner scanner = new Scanner(System.in);
    private final CourseController courseController = new CourseController();
    private final AuthController authController;

    public AnonymusView(AuthController authController) {
        this.authController = authController;
    }

    public void show() {
        System.out.println("\n=== ANONYMUS MENU ===");
        System.out.println("1. List Courses");
        System.out.println("2. Course Detail");
        System.out.println("3. Login");
        System.out.println("0. Exit");
        System.out.print("Pilih: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> listCourses();
            case 2 -> courseDetail();
            case 3 -> login();
            case 0 -> System.exit(0);
            default -> System.out.println("Menu tidak valid");
        }
    }

    private void listCourses() {
        List<Course> courses = courseController.findAll();
        courses.forEach(c ->
                System.out.println(c.getId() + " - " + c.getTitle())
        );
    }

    private void courseDetail() {
        System.out.print("Masukkan Course ID: ");
        String id = scanner.nextLine();
        Course course = courseController.findOne(id);

        if (course == null) {
            System.out.println("Course tidak ditemukan");
            return;
        }

        System.out.println("Title : " + course.getTitle());
        System.out.println("Desc  : " + course.getDescription());
        System.out.println("Credit: " + course.getCredits());
    }

    private void login() {
        System.out.print("Email    : ");
        String email = scanner.nextLine();
        System.out.print("Password : ");
        String password = scanner.nextLine();
        System.out.print("Type (ADMIN/STUDENT): ");
        UserType type = UserType.valueOf(scanner.nextLine().toUpperCase());

        authController.login(email, password, type);
    }
}
