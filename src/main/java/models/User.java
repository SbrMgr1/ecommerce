package models;

import helpers.MyHelper;

public class User {
    private long id;
    private String name;
    private String email;
    private String password;
    private UserRoles role = UserRoles.USER;

    public User() {this.id = MyHelper.getRandomInt();}

    public User(String name,String email, String password){
        this.id = MyHelper.getRandomInt();
        this.email = email;
        this.password = password;
        this.name = name;
    }

//    public User(String id, String name,String email, String password){
//        this.id = id;
//        this.email = email;
//        this.password = password;
//        this.name = name;
//    }
    public User(String name,String email, String password,UserRoles role){
        this.id = MyHelper.getRandomInt();
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }
    public boolean checkPassword(String password) {
        return password.equals(this.password);
    }

    public Long getId() {
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

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }
}
