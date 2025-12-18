package interfaces;

import models.userCourse.UserCourse;
import java.util.List;

public interface UserCourseServiceInterface {

    UserCourse enroll(UserCourse userCourse);

    boolean updateStatus(String userId, String courseId, String status);

    boolean delete(String userId, String courseId);

    List<UserCourse> findAll();

    List<UserCourse> findByUser(String userId);
}
