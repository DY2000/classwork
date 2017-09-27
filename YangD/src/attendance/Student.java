package attendance;

public class Student implements Attendee {
	private String first;
	private String last;
	private String absent;
	private boolean present;
	

public Student(String firstName,String lastName){
	this.first = firstName;
	this.last = lastName;
	
}
public void setPresent(boolean present) {
	this.present = present;
}
public boolean isPresent() {
	return this.present;
			
}

public String getFirstName(){
	return "Devin";
}
public String getLastName(){
	return "Yang";
}
public boolean mathces(String first, String last) {
	if(this.first.compareTo(first) == 0 && this.last.compareTo(last) == 0) {
		return true;
	}
	else
		return false;
}
public boolean matches(String first) {
	if(this.first.compareTo(first) == 0) {
		return true;
	}
	else
		return false;
	
}
public String getReportString() {
	
	while(this.first.length() < 20)
{
	this.first += "";
}
	this.last = this.first + this.last;
	while (this.last.length() < 40)
	{
		this.last += "";
	}
		return this.absent = this.last + "Absent";
	
}
}

