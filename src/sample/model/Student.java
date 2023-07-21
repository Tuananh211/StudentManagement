package sample.model;

import java.util.Objects;

public class Student extends Common{
    private String father;
    private String mother;
    private int year;
    private int semester;
    private String address;
    private float result;
    private String pass;

    public Student() {
    }

    public Student(String id, String name, String department, String phone, String email) {
        super(id, name, department, phone, email);
    }
    public Student(String father, String mother, int year, int semester, String address, float result, String pass) {
        this.father = father;
        this.mother = mother;
        this.year = year;
        this.semester = semester;
        this.address = address;
        this.result = result;
        this.pass = pass;
    }

    public Student(String id, String name, String department, String phone, String email, String father, String mother, int year, int semester, String address, float result, String pass) {
        super(id, name, department, phone, email);
        this.father = father;
        this.mother = mother;
        this.year = year;
        this.semester = semester;
        this.address = address;
        this.result = result;
        this.pass = pass;
    }
    public Student(String id, String name, String department, String phone, String email, String father, String mother, int year, int semester, String address, float result) {
        super(id, name, department, phone, email);
        this.father = father;
        this.mother = mother;
        this.year = year;
        this.semester = semester;
        this.address = address;
        this.result = result;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
