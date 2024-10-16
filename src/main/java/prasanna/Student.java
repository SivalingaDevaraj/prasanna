package prasanna;

public class Student {

	private String student_name;
	private int roll_number;
	private int total_mark;
	
	
	public Student(String student_name, int roll_number, int total_mark) {
		
		this.student_name = student_name;
		this.roll_number = roll_number;
		this.total_mark = total_mark;
	}


	public String getStudent_name() {
		return student_name;
	}


	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}


	public int getRoll_number() {
		return roll_number;
	}


	public void setRoll_number(int roll_number) {
		this.roll_number = roll_number;
	}


	public int getTotal_mark() {
		return total_mark;
	}


	public void setTotal_mark(int total_mark) {
		this.total_mark = total_mark;
	}
	
	
	
	
}
