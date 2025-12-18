package models.user;

public interface User {
    String getIdString();
    String getFullname();
    String getEmail();
    String getPassword();
    UserType getUserType();
}