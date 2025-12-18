package controllers;

import models.course.Course;
import models.course.CourseImpl;
import services.CourseService;

import java.util.List;

public class CourseController {

    private final CourseService courseService = new CourseService();

    public Course create(String id, String title, String desc, int credits) {
        return courseService.create(
                new CourseImpl(id, title, desc, credits)
        );
    }

    public Course update(String id, String title, String desc, int credits) {
        return courseService.update(
                id,
                new CourseImpl(id, title, desc, credits)
        );
    }

    public Course findOne(String id) {
        return courseService.findOne(id);
    }

    public List<Course> findAll() {
        return courseService.findAll();
    }

    public boolean delete(String id) {
        return courseService.delete(id);
    }
}
