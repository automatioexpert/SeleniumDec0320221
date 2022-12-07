package model;

public class CreateUserWithoutDataModel {
    public String email;
    public String password;
    public  String phone_number;
    public String nid;
    public String role;
    public CreateUserWithoutDataModel(String email, String password, String phone_number, String nid, String role) {
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.nid = nid;
        this.role = role;
    }
}
