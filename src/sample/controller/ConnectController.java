package sample.controller;

import javafx.scene.control.Alert;
import sample.model.Student;
import sample.model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectController {
    static String DB_INFOR = "jdbc:mysql://localhost:3306/test";
    static String USER_NAME = "root";
    static String PASS = "tuananhvu211";
    static Connection conn;

    private void getConnection() throws SQLException {
        conn = DriverManager.getConnection(DB_INFOR, USER_NAME, PASS);
    }

    public void showError(String mess) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ERROR");
        alert.setContentText(mess);
        alert.show();
    }

    public List<Teacher> getListTeacher() {
        String query;
        List<Teacher> listTeacher = new ArrayList<>();
        try {
            if (conn == null || conn.isClosed()) {
                getConnection();
            }
            Statement sqlFile = conn.createStatement();
            query = "select * from  teacher ";
            ResultSet resultSet = sqlFile.executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString(2);
                String name = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String email = resultSet.getString(6);
                String depart = resultSet.getString(7);
                Teacher teacher = new Teacher(id, name, phone, email, depart);
                listTeacher.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listTeacher;
    }

    public List<Student> getListStudent(){
        String query;
        List<Student> listStudent = new ArrayList<>();
        try {
            if (conn == null || conn.isClosed()) {
                getConnection();
            }
            Statement sqlFile = conn.createStatement();
            query = "select * from  student";
            ResultSet resultSet = sqlFile.executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString(2);
                String name = resultSet.getString(3);
                String department = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String email = resultSet.getString(6);
                String father = resultSet.getString(7);
                String mother = resultSet.getString(8);
                int year = resultSet.getInt(9);
                int semester = resultSet.getInt(10);
                String address = resultSet.getString(11);
                float result = resultSet.getFloat(12);
                Student student = new Student(id, name, department, phone, email, father, mother, year, semester, address, result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listStudent;
    }
    public boolean checkTeacher(String id, String pass, String name, String phone, String email, String depart, String code) {
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        String emailreg = "^(.+)@(\\S+)$";
        if (id == null || id.equals("") || !id.startsWith("GV")) {
            showError("Hãy nhập id bắt đầu bằng GV");
            return false;
        }
        if (pass == null || pass.equals("")) {
            showError("Hãy nhập mật khẩu");
            return false;
        }
        if (name == null || name.equals("")) {
            showError("Hãy nhập tên");
            return false;
        }
        if (phone == null || phone.equals("") || !phone.matches(reg)) {
            showError("Hãy nhập số điện thoại");
            return false;
        }
        if (email == null || email.equals("") || !email.matches(emailreg)) {
            showError("Email chưa được nhập hoặc không hợp lệ");
            return false;
        }
        if (depart == null || depart.equals("")) {
            showError("Hãy nhập khoa");
            return false;
        }
        if (code == null || code.equals("")) {
            showError("Hãy nhập code xác thực");
            return false;
        }
        return true;
    }

    public void addTeacher(Teacher teacher) {
        try {
            if (conn == null || conn.isClosed()) {
                getConnection();
            }
            String sql = " insert into teacher (MGV,PASS,NAME,PHONE,EMAIL,DEPARTMENT,CODE) values (?, ?, ?, ?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, teacher.getId());
            preparedStatement.setString(2, teacher.getPass());
            preparedStatement.setString(3, teacher.getName());
            preparedStatement.setString(4, teacher.getPhone());
            preparedStatement.setString(5, teacher.getEmail());
            preparedStatement.setString(6, teacher.getDepartment());
            preparedStatement.setString(7, teacher.getAuthentic_code());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        showError("Thêm thành công");
    }

    public boolean checkStudent(String id, String name, String department, String phone, String email, String father, String mother, String year, String semester, String address, String result) {
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        String emailreg = "^(.+)@(\\S+)$";
        if (id == null || id.equals("") || !id.startsWith("SV")) {
            showError("Hãy nhập id bắt đầu bằng SV");
            return false;
        }
        if (name == null || name.equals("")) {
            showError("Hãy nhập tên");
            return false;
        }
        if (department == null || department.equals("")) {
            showError("Hãy nhập khoa");
            return false;
        }
        if (phone == null || phone.equals("") || !phone.matches(reg)) {
            showError("Hãy nhập số điện thoại");
            return false;
        }
        if (email == null || email.equals("") || !email.matches(emailreg)) {
            showError("Email chưa được nhập hoặc không hợp lệ");
            return false;
        }

        if (father == null || father.equals("")) {
            showError("Hãy nhập tên của bố");
            return false;
        }
        if (mother == null || mother.equals("")) {
            showError("Hãy nhập tên của mẹ");
            return false;
        }
        if (year.equals("") || year == null || Integer.parseInt(year) < 0) {
            showError("Hãy nhập năm");
            return false;
        }
        if (semester.equals("") || semester == null || Integer.parseInt(semester) < 0) {
            showError("Hãy nhập học kì");
            return false;
        }
        if (address.equals("") || address == null) {
            showError("Hãy nhập địa chỉ");
            return false;
        }
        if (Float.parseFloat(result) < 0) {
            showError("Hãy lại kết quả");
            return false;
        }
        return true;
    }

    public void addStudent(Student student) {
        try {
            if (conn == null || conn.isClosed()) {
                getConnection();
            }
            String sql = " insert into student (MSV,NAME,DEPARTMENT,PHONE,EMAIL,FATHER,MOTHER,YEAR,SEMESTER,ADDRESS,RESULT) values (?, ?, ?, ?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getDepartment());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getFather());
            preparedStatement.setString(7, student.getMother());
            preparedStatement.setInt(8, student.getYear());
            preparedStatement.setInt(9, student.getSemester());
            preparedStatement.setString(10, student.getAddress());
            preparedStatement.setFloat(11, student.getResult());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        showError("Thêm thành công");
    }

    public Teacher login(String id, String pass) {
        String query;
        Teacher teacher = null;
        if (id == null || id.equals("") || !id.startsWith("GV")) {
            showError("Hãy nhập id bắt đầu bằng GV");
            return null;
        }
        if (pass == null || pass.equals("")) {
            showError("Hãy nhập mật khẩu");
            return null;
        }
        try {
            if (conn == null || conn.isClosed()) {
                getConnection();
            }
            Statement sqlFile = conn.createStatement();
            query = "select * from  teacher where  MGV='" + id + "'and PASS='" + pass + "'";
            ResultSet resultSet = sqlFile.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String email = resultSet.getString(6);
                String depart = resultSet.getString(7);
                teacher = new Teacher(id, pass, name, phone, email, depart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return teacher;
    }

    public Student loginStudent(String id, String pass) {
        String query;
        Student student = null;
        if (id == null || id.equals("") || !id.startsWith("SV")) {
            showError("Hãy nhập id bắt đầu bằng SV");
            return null;
        }
        if (pass == null || pass.equals("")) {
            showError("Hãy nhập mật khẩu");
            return null;
        }
        try {
            if (conn == null || conn.isClosed()) {
                getConnection();
            }
            Statement sqlFile = conn.createStatement();
            query = "select * from  student where  MSV='" + id + "'and PASS='" + pass + "'";
            ResultSet resultSet = sqlFile.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString(3);
                String department = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String email = resultSet.getString(6);
                String father = resultSet.getString(7);
                String mother = resultSet.getString(8);
                int year = resultSet.getInt(9);
                int semester = resultSet.getInt(10);
                String address = resultSet.getString(11);
                float result = resultSet.getFloat(12);
                student = new Student(id, name, department, phone, email, father, mother, year, semester, address, result, pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    public void updatePassTeacher(String ma, String pass) {
        PreparedStatement preparedStatement = null;
        try {
            if (conn == null || conn.isClosed()) {
                getConnection();
            }
            String sql = " update teacher set PASS=?  where MGV = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, pass);
            preparedStatement.setString(2, ma);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                showError("Sửa thành công");
            } else showError("Sửa thất bại");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updatePassStudent(String ma, String pass) {
        PreparedStatement preparedStatement = null;
        try {
            if (conn == null || conn.isClosed()) {
                getConnection();
            }
            String sql = " update student set PASS=?  where MSV = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, pass);
            preparedStatement.setString(2, ma);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                showError("Sửa thành công");
            } else showError("Sửa thất bại");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> getListID() {
        String query;
        List<String> listID = new ArrayList<>();
        try {
            if (conn == null || conn.isClosed()) {
                getConnection();
            }
            Statement sqlFile = conn.createStatement();
            query = "select MSV from  student ";
            ResultSet resultSet = sqlFile.executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                listID.add(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listID;
    }

    public Student getStudent(String id) {
        String query;
        Student student = null;
        if (id == null) {
            showError("Hãy chọn mã sinh viên");
            return null;
        }
        try {
            if (conn == null || conn.isClosed()) {
                getConnection();
            }
            Statement sqlFile = conn.createStatement();
            query = "select * from  student where  MSV='" + id + "'";
            ResultSet resultSet = sqlFile.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString(3);
                String department = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String email = resultSet.getString(6);
                String father = resultSet.getString(7);
                String mother = resultSet.getString(8);
                int year = resultSet.getInt(9);
                int semester = resultSet.getInt(10);
                String address = resultSet.getString(11);
                float result = resultSet.getFloat(12);
                student = new Student(id, name, department, phone, email, father, mother, year, semester, address, result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    public boolean checkUpdateStudent(String id, String name, String department, String phone, String email, String father, String mother, String year, String semester, String address, String result) {
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        String emailreg = "^(.+)@(\\S+)$";
        if (id == null || id.equals("") || !id.startsWith("SV")) {
            showError("Hãy nhập id bắt đầu bằng SV");
            return false;
        }
        if (name == null || name.equals("")) {
            showError("Hãy nhập tên");
            return false;
        }
        if (department == null || department.equals("")) {
            showError("Hãy nhập khoa");
            return false;
        }
        if (phone == null || phone.equals("") || !phone.matches(reg)) {
            showError("Hãy nhập số điện thoại");
            return false;
        }
        if (email == null || email.equals("") || !email.matches(emailreg)) {
            showError("Email chưa được nhập hoặc không hợp lệ");
            return false;
        }

        if (father == null || father.equals("")) {
            showError("Hãy nhập tên của bố");
            return false;
        }
        if (mother == null || mother.equals("")) {
            showError("Hãy nhập tên của mẹ");
            return false;
        }
        if (year.equals("") || year == null || Integer.parseInt(year) < 0) {
            showError("Hãy nhập năm");
            return false;
        }
        if (semester.equals("") || semester == null || Integer.parseInt(semester) < 0) {
            showError("Hãy nhập học kì");
            return false;
        }
        if (address.equals("") || address == null) {
            showError("Hãy nhập địa chỉ");
            return false;
        }
        if (Float.parseFloat(result) < 0) {
            showError("Hãy lại kết quả");
            return false;
        }
        return true;
    }

    public void updateStudent(Student student) {
        PreparedStatement preparedStatement = null;
        try {
            if (conn == null || conn.isClosed()) {
                getConnection();
            }
            String sql = " update student set NAME =?,DEPARTMENT=?,PHONE=?,EMAIL=?,FATHER=?,MOTHER=?,YEAR=?,SEMESTER=?,ADDRESS=?,RESULT=? where MSV = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDepartment());
            preparedStatement.setString(3, student.getPhone());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getFather());
            preparedStatement.setString(6, student.getMother());
            preparedStatement.setInt(7, student.getYear());
            preparedStatement.setInt(8, student.getSemester());
            preparedStatement.setString(9, student.getAddress());
            preparedStatement.setFloat(10, student.getResult());
            preparedStatement.setString(11, student.getId());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                showError("Cập nhật thành công");
            } else showError("Cập nhật thất bại");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteStudent(String id) {
        if (id.equals("") || id == null) {
            showError("Hãy chọn id Sinh viên muốn xóa");
            return;
        }
        try {
            if (conn == null || conn.isClosed()) {
                getConnection();
            }
            String sql = "delete from student where MSV='" + id + "'";
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        showError("Xóa thành công");
    }
}
