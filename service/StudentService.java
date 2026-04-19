package service;

import dao.StudentDAO;
import java.util.ArrayList;
import model.Student;

public class StudentService {
	private StudentDAO dao = new StudentDAO();
	
	private static String fixName(String name) {
		String[] words = name.split(" ");
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < words.length; i++) {
			String word = words[i];
			
			result.append(Character.toUpperCase(word.charAt(0)));
			result.append(word.substring(1).toLowerCase());

			if(i != words.length - 1) {
				result.append(" ");
			}
		}
		
		return result.toString();
	}
		
	public void addStudent(Student s) throws Exception {		
		if(s.getName() != null && s.getName().length() != 1 && s.getEmail() != null && s.getEmail().contains("@") && s.getEmail().contains("@")) {
		    s.setName(fixName(s.getName()));
			dao.addStudent(s);
		} else {
			System.out.println("Invalid EMail.");
		}
	}
	
	public ArrayList<Student> getAllStudents() throws Exception {
		return dao.getAllStudents();
	}
	
	public void updateStudent(int id, String name, String email) throws Exception {
		dao.updateStudent(id, name, email);
	}
	
	public void deleteStudent(int id) throws Exception {
		dao.deleteStudent(id);
	}
	
	public Student searchStudent(int id) throws Exception {
		return dao.searchStudent(id);
	}
}
