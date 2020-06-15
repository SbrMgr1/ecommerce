package models;

import helpers.MyHelper;

public class User {
    private long id;
    private String name;
    private String email;
    private String password;
    private UserRoles role = UserRoles.USER;

    public User(String name,String email, String password){
        this.id = MyHelper.getRandomInt();
        this.email = email;
        this.name = name;
        this.password = password;
    }
    public User(String name,String email, String password,UserRoles role){
        this.id = MyHelper.getRandomInt();
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public boolean checkPassword(String password) {
        return password.equals(this.password);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UserRoles getRole() {
        return role;
    }
}
