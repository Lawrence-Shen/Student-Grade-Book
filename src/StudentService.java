import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StudentService {

	ArrayList<Student> students = new ArrayList<>();
	HashMap<String, Student> studentsMap = new HashMap<>();
	
	public String validateNewName(String name) {
		if (name.isBlank()) return "Enter a name!";
		if (studentsMap.containsKey(name)) return "This name already exists!";
		return null;
	}
	
	public String validateExistingName(String name) {
		if (name.isBlank()) return "Enter a name!";
		if (!studentsMap.containsKey(name)) return "This student does not exist!";
		return null;
	}
	
	public void addStudent(String name) {
			Student s = new Student(name);
			students.add(s);
			studentsMap.put(name, s);
	}
	
	public void viewStudents(Scanner scanner) {
		for (Student s : students) {
			System.out.println(s.getName());
		}
		System.out.println();
	}
}
