

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
	private String nickname;

	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		friends = new Person[3];
		hobby = Hobby.randomHobby();
	}
	/**
	 * PASS BY VALUE
	 * the parameters of a method contain only values, not references
	 * therefore, when they are changed, the REFERENCES to the original
	 * object does not change
	 * @param name
	 * @return
	 */
	public static String createNickname(String name) {
		String nickname = "";
		int count = 0;
		for (int i = 0; i < name.length(); i ++) {
			String letter = name.substring(i,i+1);
			if(isVowel(letter)) {
				count++;
				if (count != 2) {
					nickname += letter;
				}
			}else {
				return nickname;
			}
		}else {
			
					nickname += letter;
				
		}
	}
		return name;
public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
		
		private static boolean isVowel(String letter) {
			letter = letter.toLowerCase();
			return letter.equals("e") || letter.equals("a") || letter.equals("i")
					|| letter.equals("o") || letter.equals("u");
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

