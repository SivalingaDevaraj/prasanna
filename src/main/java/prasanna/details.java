package prasanna;

public class details {

	private int roll_number;
	private String student_name;
	private int english;
	private int tamil;
	private int maths;
	private int science;
	private int social;

	
	
	public details( String student_name,int roll_number, int english, int tamil, int maths, int science, int social) {
	
		this.roll_number = roll_number;
		this.student_name = student_name;
		this.english = english;
		this.tamil = tamil;
		this.maths = maths;
		this.science = science;
		this.social = social;
	}
	

	public int getRoll_number() {
		return roll_number;
	}

	public void setRoll_number(int roll_number) {
		this.roll_number = roll_number;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getTamil() {
		return tamil;
	}

	public void setTamil(int tamil) {
		this.tamil = tamil;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social = social;
	}

	
}
