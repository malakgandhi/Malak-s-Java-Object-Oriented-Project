package dao;

import model.Student;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
	public void addStudent(Student s) throws Exception {
		Connection con = DBConnection.getConnection();
		String query = "INSERT INTO students(name, email) VALUES(?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, s.getName());
		ps.setString(2, s.getEmail()); 
		ps.executeUpdate();
		con.close();
	}
	
	public ArrayList<Student> getAllStudents() throws Exception {
		Connection con = DBConnection.getConnection();
		ArrayList<Student> list = new ArrayList<>();
		
		String query = "SELECT * FROM students";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Student s = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
			list.add(s);
		}
		
		con.close();
		return list;
	}
	
	public void updateStudent(int id, String name, String email) throws Exception {
		Connection con = DBConnection.getConnection();
		String query = "UPDATE students SET name=?, email=? WHERE id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1,  name);
		ps.setString(2,  email);
		ps.setInt(3,  id);
		ps.executeUpdate();
		con.close();
	}
	
	public void deleteStudent(int id) throws Exception {
		Connection con = DBConnection.getConnection();
		String query = "DELETE FROM students WHERE id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,  id);
		ps.executeUpdate();
		con.close();
	}
	
	public Student searchStudent(int id) throws Exception {
		Connection con = DBConnection.getConnection();
		String query = "SELECT * FROM students WHERE id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,  id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			Student s = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
			con.close();
			return s;
		}
		con.close();
		return null;
	}
}
