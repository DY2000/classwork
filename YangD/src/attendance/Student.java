package attendance;

public class Student implements Attendee {
	private String first1;
	private String last1;
	private String lineoftext;
	private boolean present;
	

public Student(String firstName,String lastName){
	this.first1 = firstName;
	this.last1 = lastName;
	present = false;
	
	
}
public void setPresent(boolean present) {
	this.present = present;
}
public boolean isPresent() {
	return this.present;
			
}

public String getFirstName(){
	return first1;
}
public String getLastName(){
	return last1;
}
public boolean mathces(String first, String last) {
		return first.toLowerCase().equals(first1.toLowerCase()) && last.toLowerCase().equals(last1.toLowerCase());

	}


public boolean matches(String last) {
	return last.toLowerCase().equals(last1.toLowerCase());
}

	

public String getReportString() {
		this.lineoftext = this.last1;
		while(lineoftext.length() > 20)
		{
			lineoftext += " ";
		}
		this.lineoftext+= this.first1;
		while(lineoftext.length() > 40)
		{
			lineoftext += " ";
		}
		if (this.present == true)
		{
			this.lineoftext+="PRESENT";
			return lineoftext;
		}
		else
		{
			this.lineoftext +="ABSENT";
			return lineoftext;
		}
		
}
	
}

