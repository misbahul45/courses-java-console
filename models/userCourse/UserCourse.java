package models.userCourse;

import models.course.Course;
import models.user.User;

public interface UserCourse {
    User getUser();
    Course getCourse();
    String getStatus(); // ENROLLED, COMPLETED, DROPPED
}
