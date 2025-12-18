package services;

import interfaces.CourseServiceInterface;
import models.course.Course;
import models.course.CourseImpl;

import java.util.ArrayList;
import java.util.List;

public class CourseService implements CourseServiceInterface {

    private static final String FILE = "data/courses.txt";

    @Override
    public Course create(Course course) {
        String line = String.join("|",
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                String.valueOf(course.getCredits())
        );

        Fileservice.append(FILE, line);
        return course;
    }

    @Override
    public Course update(String id, Course course) {
        delete(id);
        create(course);
        return course;
    }

    @Override
    public boolean delete(String id) {
        List<String> lines = Fileservice.readAll(FILE);
        boolean removed = lines.removeIf(l -> l.startsWith(id + "|"));
        Fileservice.writeAll(FILE, lines);
        return removed;
    }

    @Override
    public Course findOne(String id) {
        return findAll().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();

        for (String line : Fileservice.readAll(FILE)) {
            String[] d = line.split("\\|");

            courses.add(new CourseImpl(
                    d[0],
                    d[1],
                    d[2],
                    Integer.parseInt(d[3])
            ));
        }
        return courses;
    }
}
