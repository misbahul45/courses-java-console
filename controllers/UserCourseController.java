package controllers;
import models.course.Course;
import models.user.User;
import models.user.UserType;
import models.userCourse.UserCourse;
import models.userCourse.UserCourseImpl;
import models.userCourse.UserCourseStatus;
import services.CourseService;
import services.UserCourseService;
import services.UserService;

import java.util.List;

public class UserCourseController {

    private final UserService userService = new UserService();
    private final CourseService courseService = new CourseService();
    private final UserCourseService userCourseService = new UserCourseService();

    public UserCourse enroll(String userId, UserType userType, String courseId) {
        User user = userService.findOne(userId, userType);
        Course course = courseService.findOne(courseId);

        if (user == null || course == null) {
            throw new IllegalArgumentException("User atau Course tidak ditemukan");
        }

        return userCourseService.enroll(
                new UserCourseImpl(user, course, UserCourseStatus.ENROLLED)
        );
    }

    public boolean updateStatus(String userId, String courseId, UserCourseStatus status) {
        return userCourseService.updateStatus(
                userId,
                courseId,
                status.name()
        );
    }

    public UserCourse findOne(String userId, String courseId) {
        return userCourseService.findAll().stream()
                .filter(uc ->
                        uc.getUser().getIdString().equals(userId)
                                && uc.getCourse().getId().equals(courseId)
                )
                .findFirst()
                .orElse(null);
    }

    public List<UserCourse> findAll() {
        return userCourseService.findAll();
    }

    public List<UserCourse> findByUser(String userId) {
        return userCourseService.findByUser(userId);
    }

    public boolean delete(String userId, String courseId) {
        return userCourseService.delete(userId, courseId);
    }
}
