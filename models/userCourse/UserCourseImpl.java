package models.userCourse;

import models.course.Course;
import models.user.User;

public class UserCourseImpl implements UserCourse {

    private final User user;
    private final Course course;
    private final UserCourseStatus status;

    public UserCourseImpl(User user, Course course, UserCourseStatus status) {
        this.user = user;
        this.course = course;
        this.status = status;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public Course getCourse() {
        return course;
    }

    @Override
    public String getStatus() {
        return status.name();
    }

    public UserCourseStatus getStatusEnum() {
        return status;
    }
}
