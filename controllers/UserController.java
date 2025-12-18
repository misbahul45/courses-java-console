package controllers;

import models.admin.AdminImpl;
import models.students.StudentImpl;
import models.user.User;
import models.user.UserType;
import services.UserService;

import java.util.List;

public class UserController {

    private final UserService userService = new UserService();

    public User createAdmin(String id, String name, String email, String password) {
        return userService.create(
                new AdminImpl(id, name, email, password)
        );
    }

    public User createStudent(String id, String name, String email, String password, String nim) {
        return userService.create(
                new StudentImpl(id, name, email, password, nim)
        );
    }

    public User updateAdmin(String id, String name, String email, String password) {
        return userService.update(
                id,
                new AdminImpl(id, name, email, password)
        );
    }

    public User updateStudent(String id, String name, String email, String password, String nim) {
        return userService.update(
                id,
                new StudentImpl(id, name, email, password, nim)
        );
    }

    public User findOne(String id, UserType type) {
        return userService.findOne(id, type);
    }

    public List<? extends User> findAll(UserType type) {
        return userService.findAll(type);
    }

    public boolean delete(String id, UserType type) {
        return userService.delete(id, type);
    }
}
