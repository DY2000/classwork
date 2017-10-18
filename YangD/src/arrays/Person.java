package arrays;

public class Person {
	
	public static final String[] FIRST_START = {"D","Y","Th","B"};
	public static final String[] FIRST_MIDDLE = {"evi","ina","a","o"};
	public static final String[] FIRST_END = {"na","ck","en","o"};
	
	public static final String[] LAST_START = {"T","Am","Sh","Chr"};
	public static final String[] LAST_MIDDLE = {"go","eri","e","i"};
	public static final String[] LAST_END = {"vin","min","les","son"};
	
	private String firstName;
	private String lastName;
	private Borough home;

	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
	}
	
	public String toString() {
		return "My name is "+firstName+" "+lastName+" and I am from "+home+".";	
				}
	
}

