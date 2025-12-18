package models.students;

import models.user.AbstractUser;
import models.user.UserType;

public class StudentImpl extends AbstractUser implements Student {
    private final String nim;

    public StudentImpl(String id, String fullname, String email, String password,String nim) {
        super(id,fullname, email, password);
        this.nim = nim;
    }

    @Override
    public String getStudentNim() {
        return nim;
    }
    @Override
    public UserType getUserType() {
        return UserType.STUDENT; 
    }

}
