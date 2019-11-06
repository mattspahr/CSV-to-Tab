import java.util.ArrayList;
import java.io.*;

public class Driver {
	
	private static ArrayList<Student> studentList;
	private static ArrayList<String> schoolList;
	
	public ArrayList<Student> getStudentList() {
		return this.studentList;	
	}
	
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;	
	}
	
	/*
		Reads data from the csv file and creates a Student and stores 
		it in the list. 
	*/
	public static void csvToList(File csvFile) {
		
		try {
		
			studentList = new ArrayList<Student>();
			schoolList = new ArrayList<String>();
			String row; 
			
			BufferedReader csvReader = new BufferedReader(new FileReader(csvFile));
			while ((row = csvReader.readLine()) != null) {
				String[] rawStudent = row.split(",");
				Student student = new Student(Integer.valueOf(rawStudent[0]), rawStudent[1], rawStudent[2]);
				studentList.add(student);
				if (!schoolList.contains(rawStudent[2])) {
					schoolList.add(rawStudent[2]);
				}
			}
			csvReader.close();
		} catch (Exception e) {
			System.out.println("Error");	
		}
	}
	
	/*
		Creates and write to a .txt file.
		Tab delimited. 
		Does this for one school.
	*/
	public static void tsvForSchool(String school) {
		
		File tsv = new File("data/" + school + ".txt");
		String TAB = "\t";
		String EOL = "\n";
		
		try {
			FileWriter tsvWriter = new FileWriter(tsv);
			for (int i = 0; i < studentList.size(); i++) {
				StringBuilder sb = new StringBuilder();
				if (studentList.get(i).getSchool().equals(school)) {
						
					sb.append(studentList.get(i).getId());
					sb.append(TAB);
					sb.append(studentList.get(i).getName());
					sb.append(TAB);
					sb.append(school + EOL);
					tsvWriter.write(sb.toString());
			
				}
				
			}
			tsvWriter.close();
		} catch (IOException e) {
			System.out.println("Error");
		}	
	}
	
	public static void main(String[] args) {
		
		File testFile = new File("testFile.csv");
		csvToList(testFile);
		
		for (int i = 0; i < schoolList.size(); i++) {
			tsvForSchool(schoolList.get(i));
		}
		
	}
	
}