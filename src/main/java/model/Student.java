package model;

public class Student {
	String stud_id;
	String stud_name;
	String stud_location;

	public Student(String sid, String sname, String slocation) {
		this.stud_id = sid;
		this.stud_name = sname;
		this.stud_location = slocation;
	}

	public String getStud_id() {
		return stud_id;
	}

	public void setStud_id(String stud_id) {
		this.stud_id = stud_id;
	}

	public String getStud_name() {
		return stud_name;
	}

	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}

	public String getStud_location() {
		return stud_location;
	}

	public void setStud_location(String stud_location) {
		this.stud_location = stud_location;
	}

}
