package intro;

public class CodingConventions {
	
	//fields are at the top
	private String name;//Note: Declare fields only, Instantiate in the constructor
	private String description;
	
	
	//this is a constructor, it is like a method except the "return type" is a instance of a class.
	// for this reason, a constructor must always be named after the class.
	public CodingConventions(String name, int descriptionIndex) {
		
		//instantiate variables now
		
		// two variables called "name, local variable and the field
		//distinguish between the two using the reserved word "this" (field)
		this.name = "Devin Yang";
		description = IntroMain.DESCRIPTIONS[descriptionIndex];
	}
	
	//normal method "void" is return type
	public void doStuff() {
		//static method call;
			String output = name + description; //use spaces such as 1 + 1 = 2, not 1+1=2
			System.out.println(output);
	}
}
