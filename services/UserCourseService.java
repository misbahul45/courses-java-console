package services;

import interfaces.UserCourseServiceInterface;
import models.course.Course;
import models.user.User;
import models.user.UserType;
import models.userCourse.UserCourse;
import models.userCourse.UserCourseImpl;
import models.userCourse.UserCourseStatus;

import java.util.ArrayList;
import java.util.List;

public class UserCourseService implements UserCourseServiceInterface {

    private static final String FILE = "data/userCourses.txt";

    private final UserService userService = new UserService();
    private final CourseService courseService = new CourseService();

    @Override
    public UserCourse enroll(UserCourse userCourse) {
        String line = String.join("|",
                userCourse.getUser().getIdString(),
                userCourse.getCourse().getId(),
                userCourse.getStatus()
        );

        Fileservice.append(FILE, line);
        return userCourse;
    }

    @Override
    public boolean updateStatus(String userId, String courseId, String status) {
        List<String> lines = Fileservice.readAll(FILE);
        boolean updated = false;

        for (int i = 0; i < lines.size(); i++) {
            String[] d = lines.get(i).split("\\|");
            if (d[0].equals(userId) && d[1].equals(courseId)) {
                lines.set(i, userId + "|" + courseId + "|" + status);
                updated = true;
                break;
            }
        }

        Fileservice.writeAll(FILE, lines);
        return updated;
    }

    @Override
    public boolean delete(String userId, String courseId) {
        List<String> lines = Fileservice.readAll(FILE);
        boolean removed = lines.removeIf(
                l -> l.startsWith(userId + "|" + courseId + "|")
        );
        Fileservice.writeAll(FILE, lines);
        return removed;
    }

    @Override
    public List<UserCourse> findAll() {
        List<UserCourse> result = new ArrayList<>();

        for (String line : Fileservice.readAll(FILE)) {
            String[] d = line.split("\\|");

            User user = userService.findOne(d[0], UserType.STUDENT);
            Course course = courseService.findOne(d[1]);

            result.add(new UserCourseImpl(
                    user,
                    course,
                    UserCourseStatus.valueOf(d[2])
            ));
        }
        return result;
    }

    @Override
    public List<UserCourse> findByUser(String userId) {
        List<UserCourse> result = new ArrayList<>();

        for (UserCourse uc : findAll()) {
            if (uc.getUser().getIdString().equals(userId)) {
                result.add(uc);
            }
        }
        return result;
    }
}
