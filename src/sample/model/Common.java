package sample.model;

import java.util.Objects;

public  class Common {
    private String id;
    private String name;
    private String department;
    private String phone;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Common common = (Common) o;
        return id.equals(common.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Common() {
    }

    public Common(String id, String name, String department, String phone, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
