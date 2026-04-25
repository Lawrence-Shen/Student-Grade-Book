import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StudentService currentSession = new StudentService();
		
		//Declarations
		MenuHelper.printStartMenu();
		Scanner scanner = new Scanner(System.in);
		int input = MenuHelper.getMenuChoice(scanner);
		
		//First round Menu - Add Student & Exit
		switch (input) {
		case 1: //Add Student
			currentSession.addStudent(MenuHelper.getName(scanner, currentSession::validateNewName));
			break;
		case 2: //Exit
			MenuHelper.printExitMsg();
			return;
		}
		
		//Second round Menu - Add Student, Add Grade, View Students - repeats until grade is added
		boolean second = true;
		while(second) {
			MenuHelper.printSecondMenu();
			input = MenuHelper.getMenuChoice(scanner);
			
			switch(input) {
			case 1: //Add Student
				currentSession.addStudent(MenuHelper.getName(scanner, currentSession::validateNewName));
				break;
			case 2: //Add Grade
				case2(scanner, currentSession);
				second = false;
				break;
			case 3: //View all Students
				currentSession.viewStudents(scanner);
				break;
			case 4: //Exit
				MenuHelper.printExitMsg();
				return;
			}
		}
		
		//Full Menu Available
		while(true) {
			MenuHelper.printFullMenu();
			input = MenuHelper.getMenuChoice(scanner);
			
			switch (input) {
			
			case 1: { //Add Student
				currentSession.addStudent(MenuHelper.getName(scanner, currentSession::validateNewName));
				break;
			}
				
			case 2: { //Add Grade
				case2(scanner, currentSession);
				break;
			}
			
			case 3: { //View all students
				currentSession.viewStudents(scanner);
				break;
			}
				
			case 4: { //View a student's grades
				String name = MenuHelper.getName(scanner, currentSession::validateExistingName);
				Student s = currentSession.studentsMap.get(name);
				if(s.validateGradesList()) {
					String subject = MenuHelper.getSubject(scanner, s::validateExistingSubject);
					int grade = s.viewGrade(subject);
					MenuHelper.printGrade(grade, subject, name);
				} else {
					System.out.println("There are no grades for the student!");
				}
				break;
			}
			
			case 5: { //Calculate a Student's Average
				String name = MenuHelper.getName(scanner, currentSession::validateExistingName);
				Student s = currentSession.studentsMap.get(name);
				if (s.validateGradesList()) {
					System.out.println(name + "'s Average is " + s.calculateAverage());
				} else {
					System.out.println("There are no grades for the student!");
				}
				break;
			}
			
			case 6: {//Show Highest Grade for a Student
				String name = MenuHelper.getName(scanner, currentSession::validateExistingName);
				Student s = currentSession.studentsMap.get(name);
				if(s.validateGradesList()) {
					String highestSubject = s.viewHighestSubject();
					int highestGrade = s.viewGrade(highestSubject);
					
					System.out.println(name + "'s highest grade is a " + highestGrade + " in " + highestSubject);
					System.out.println();
				} else {
					System.out.println("There are no grades for the student!");
				}
				break;
			}
			
			case 7: //Exit
				MenuHelper.printExitMsg();
				return;
				
			default: //Error Catching
				System.out.println("Please enter a number between 1 and 7!");
				break;
			}		
		}
	}
	
	public static void case2(Scanner scanner, StudentService currentSession) {
		String name = MenuHelper.getName(scanner, currentSession::validateExistingName);
		Student s = currentSession.studentsMap.get(name);
		String subject = MenuHelper.getSubject(scanner, s::validateNewSubject);
		
		s.setGrade(subject, MenuHelper.getGrade(scanner, subject));
	}
	

}
