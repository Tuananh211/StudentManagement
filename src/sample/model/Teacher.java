package sample.model;

import java.util.Objects;

public class Teacher extends Common{
    private String pass;
    private String authentic_code;

    public Teacher() {
    }

    public Teacher(String id, String name, String department, String phone, String email) {
        super(id, name, department, phone, email);
    }

    public Teacher(String pass, String authentic_code) {
        this.pass = pass;
        this.authentic_code = authentic_code;
    }

    public Teacher(String id, String pass, String name, String phone, String email, String department, String authentic_code) {
        super(id, name, department, phone, email);
        this.pass = pass;
        this.authentic_code = authentic_code;
    }

    public Teacher(String id, String pass, String name, String phone, String email, String department) {
        super(id, name, department, phone, email);
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getAuthentic_code() {
        return authentic_code;
    }

    public void setAuthentic_code(String authentic_code) {
        this.authentic_code = authentic_code;
    }
}
