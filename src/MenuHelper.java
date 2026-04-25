import java.util.Scanner;
import java.util.function.*;

public class MenuHelper {
	public static final int FIRST_MENU = 1;
	public static final int LAST_MENU = 7;
	
	public static void printStartMenu() {
		System.out.println();
		System.out.println("Menu");
		System.out.println();
		System.out.println("1. Add Student");
		System.out.println("2. Exit");
	}
	
	public static void printSecondMenu() {
		System.out.println();
		System.out.println("Menu");
		System.out.println();
		System.out.println("1. Add Student");
		System.out.println("2. Add Grade");
		System.out.println("3. View all Students");
		System.out.println("4. Exit");
	}
	
	public static void printFullMenu() {
		System.out.println();
		System.out.println("Menu");
		System.out.println();
		System.out.println("1. Add Student");
		System.out.println("2. Add Grade");
		System.out.println("3. View all Students");
		System.out.println("4. View a Student's Grades");
		System.out.println("5. Calculate a Student's Average");
		System.out.println("6. Show Highest Grade for a Student");
		System.out.println("7. Exit");
	}
	
	public static void printExitMsg() {
		System.out.println("Goodbye!");
	}
	
	public static int getMenuChoice(Scanner scanner) {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Error. Enter a number between 1 and 7!");
			}
		}
	}
	
	public static String getName(Scanner scanner, Function<String, String> validator) {
		System.out.println("Enter the student's name below:");
		String name = scanner.nextLine();
		
		String error;
		while ((error = validator.apply(name)) != null) {
			System.out.println(error);
			System.out.println("Enter a name!");
			name = scanner.nextLine();
		}
		return name;
	}
	
	public static String getSubject(Scanner scanner, Function<String, String> validator) {
		System.out.println("Enter the subject:");
		String subject = scanner.nextLine();
		String error;
		while((error = validator.apply(subject)) != null) {
			System.out.println(error);
			System.out.println("Enter the subject:");
			subject = scanner.nextLine();
		}
		return subject;
	}
	
	public static int getGrade(Scanner scanner, String subject) {
		String error;
		while(true) {
			System.out.println("Enter the grade:");
			try {
				int grade = Integer.parseInt(scanner.nextLine());
				
				if((error = Student.validateGrade(grade)) != null) {
					System.out.println(error);
				} else {
					return grade;
				}
				
			} catch (NumberFormatException e) {
				System.out.println("Enter a valid number!");
			}
		}
	}
	
	public static void printGrade(int grade, String subject, String name) {
		System.out.println("For " + subject + ", " + name + "'s grade is: " + grade);
		System.out.println();
	}
}
