package models.admin;

import models.user.AbstractUser;
import models.user.UserType;

public class AdminImpl extends AbstractUser implements Admin {

    public AdminImpl(
        String id,
        String fullname,
        String email,
        String password
    ){
        super(id, fullname, email, password);
    }

    @Override
    public UserType getUserType() {
        return UserType.ADMIN;
    }

}
