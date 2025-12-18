package services;

import interfaces.UserService;
import models.students.Student;
import models.students.StudentImpl;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements UserService<Student> {

    private static final String FILE = "data/student.txt";

    @Override
    public Student create(Student student) {
        String line = String.join("|",
                student.getIdString(),
                student.getFullname(),
                student.getEmail(),
                student.getPassword(),
                student.getStudentNim()
        );

        Fileservice.append(FILE, line);
        return student;
    }

    @Override
    public Student update(String id, Student student) {
        delete(id);
        return create(student);
    }

    @Override
    public boolean delete(String id) {
        List<String> lines = Fileservice.readAll(FILE);
        boolean removed = lines.removeIf(l -> l.startsWith(id + "|"));
        Fileservice.writeAll(FILE, lines);
        return removed;
    }

    @Override
    public Student findOne(String id) {
        return findAll().stream()
                .filter(s -> s.getIdString().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();

        for (String line : Fileservice.readAll(FILE)) {
            String[] d = line.split("\\|");

            students.add(new StudentImpl(
                    d[0], d[1], d[2], d[3], d[4]
            ));
        }
        return students;
    }
}
