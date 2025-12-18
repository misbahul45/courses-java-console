package models.students;

import models.user.User;

public interface Student extends User {
    String getStudentNim();
}