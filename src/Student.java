import java.util.HashMap;

public class Student {
	private String name;
	private HashMap<String, Integer> grades = new HashMap<>();
	private static final int MIN_GRADE = 0;
	private static final int MAX_GRADE = 100;
	
	Student(String name) {
		this.name = name;
	}
	
	public String getName() {return name;}
	
	public void setGrade(String subject, int grade) {
		grades.put(subject, grade);
	}
	
	public static String validateGrade(int grade) {
		if (grade < MIN_GRADE) return "The grade must be 0 or above!";
		if (grade > MAX_GRADE) return "The grade must be 100 or below!";
		return null;
	}
	
	public String validateNewSubject(String subject) {
		if(subject.isBlank()) return "Enter a subject!";
		if(grades.containsKey(subject)) return "This subject is already in the student's gradebook!";
		return null;
	}
	
	public String validateExistingSubject(String subject) {
		if(subject.isBlank()) return "Enter a subject!";
		if(!grades.containsKey(subject)) return "This subject is not in the student's gradebook!";
		return null;
	}
	
	public Integer viewGrade(String subject) {
		return grades.get(subject);
	}
	
	public double calculateAverage() {
		double sum = 0;
		int count = 0;
		
		for(Integer value : grades.values()) {
			sum += value;
			count ++;
		}
		
		return sum / count;
	}
	
	public boolean validateGradesList() {
		return !grades.isEmpty();
	}
	
	public String viewHighestSubject() {
		String subject = null;
		int max = 0;
		for(String key: grades.keySet()) {
			if(grades.get(key) > max) {
				subject = key;
				max = grades.get(key);
			}
		}
		
		return subject;
	}
}
