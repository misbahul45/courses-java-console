package interfaces;

import models.course.Course;
import java.util.List;

public interface CourseServiceInterface {

    Course create(Course course);

    Course update(String id, Course course);

    boolean delete(String id);

    Course findOne(String id);

    List<Course> findAll();
}
