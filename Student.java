/*
	Student class defines a student at a university. 
	Each student has an ID, name, and respective university. 
*/

public class Student {
	
	private int id;
	private String name;
	private String school;
	
	public Student(int id, String name, String school) {
		this.id = id;
		this.name = name;
		this.school = school;
	}
	
	public int getId() {
		return this.id;	
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;	
	}
	
	public void setName(String name) {
		this.name = name;	
	}
	
	public String getSchool() {
		return this.school;	
	}
	
	public void setSchool(String school) {
		this.school = school;
	}
}