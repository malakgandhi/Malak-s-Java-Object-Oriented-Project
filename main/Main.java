package main;

import model.Student;
import service.StudentService;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StudentService service = new StudentService();
		
		int choice = 0;
		
		while (true) {
			boolean isValid = true;
			
			System.out.println("\n1. Add Student");
			System.out.println("2. View Students");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Search Student");
			System.out.println("6. Exit");
			
			try {
				choice = sc.nextInt();
				sc.nextLine();
			} catch(Exception e) {
				System.out.println("Invalid input!\nPlease retry.");
				sc.nextLine();
				isValid = false;
			}
			
			if (isValid) {
				switch(choice) {
				case 1:
					System.out.print("Enter name: ");
					String name = sc.nextLine();
					
					System.out.print("Enter email: ");
					String email = sc.nextLine();
					
					service.addStudent(new Student(name, email));
					break;
				case 2:
					for(Student s: service.getAllStudents()) {
						s.display();
					}
					break;
				case 3:
					int idUpdate = sc.nextInt();
					sc.nextLine();
					
					System.out.print("Enter new name:");
					String newName = sc.nextLine();
					
					System.out.print("Enter new email:");
					String newEMail = sc.nextLine();
					
					service.updateStudent(idUpdate, newName, newEMail);
					break;
				case 4:
					System.out.print("Enter id:");
					int idDelete = sc.nextInt();
					service.deleteStudent(idDelete);
					break;
				case 5:
					System.out.print("Enter id:");
					int idSearch = sc.nextInt();
					
					Student s = service.searchStudent(idSearch);
					if(s != null) {
						s.display();
					} else {
						System.out.print("Student not found.");
					}
					break;
				case 6:
					sc.close();
					System.exit(0);
				default:
					System.out.println("Student not found.");
				}
			}
		}
	}
}
