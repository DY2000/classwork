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
	private Hobby hobby;
	private Person[] friends;

	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		friends = new Person[3];
		hobby = Hobby.randomHobby();
	}
	
	public void stateYourFriends() {
		String statement = "My friends ";
		for(int i = 0; i < friends.length - 1; i++) {
			statement += friends[i].firstName + " " + friends[i].lastName+",";
			}
			statement += "and " + friends[friends.length - 1];
			System.out.println(statement);
	}
	
	public void mingle(Person[] peers) {
		for(Person pep: peers) {
			if(pep !=this) {
				setInFirstPlace(pep);
			}
		}
	}
	public void setInFirstPlace(Person f) {
		for(int i = friends.length - 1; i > 0; i--) {
			
			friends[i] = friends[i-1];
		}
			friends[0] = f;
		
	}
		public String toString() {
		return "My name is "+firstName+" "+lastName+" and I am from "+home+".";	
				}
	
}

