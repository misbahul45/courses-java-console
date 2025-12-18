package services;

import models.admin.Admin;
import models.students.Student;
import models.user.User;
import models.user.UserType;

import java.util.List;

public class UserService {

    private final AdminService adminService = new AdminService();
    private final StudentService studentService = new StudentService();

    public User create(User user) {
        if (user instanceof Admin admin) {
            return adminService.create(admin);
        }

        if (user instanceof Student student) {
            return studentService.create(student);
        }

        throw new IllegalArgumentException("Tipe user tidak dikenal");
    }

    public User update(String id, User user) {
        if (user instanceof Admin admin) {
            return adminService.update(id, admin);
        }

        if (user instanceof Student student) {
            return studentService.update(id, student);
        }

        throw new IllegalArgumentException("Tipe user tidak dikenal");
    }

    public boolean delete(String id, UserType type) {
        return switch (type) {
            case ADMIN -> adminService.delete(id);
            case STUDENT -> studentService.delete(id);
        };
    }

    public User findOne(String id, UserType type) {
        return switch (type) {
            case ADMIN -> adminService.findOne(id);
            case STUDENT -> studentService.findOne(id);
        };
    }

    public List<? extends User> findAll(UserType type) {
        return switch (type) {
            case ADMIN -> adminService.findAll();
            case STUDENT -> studentService.findAll();
        };
    }
}
