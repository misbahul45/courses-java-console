package models.user;

public abstract class AbstractUser implements User {

    protected final String id;
    protected final String fullname;
    protected final String email;
    protected final String password;

    protected AbstractUser(String id, String fullname, String email, String password) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    @Override
    public String getIdString() {
        return id;
    }

    @Override
    public String getFullname() {
        return fullname;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public UserType getUserType() {
        return UserType.STUDENT; 
    }

}
