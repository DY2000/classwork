package intro;

public class IntroMain {
	
	public static final String[] DESCRIPTIONS = {"is a teacher at BTHS","is a student at BTHS"};
	
	
	
	//first method
	public static void main(String[] args) {
		
		
		int numberOfPeople = 10;
		for (int i = 0; i < numberOfPeople; i++)
		{
		
		//this is the declaration of an instance of CodingConvetions
		//in the same line of code, it is also being instantiated
		//note the use of the word "new" this word is always used when calling constructors
		
		CodingConventions conventionsInstance = new CodingConventions("Devin Yang",0);
		//local variables are only used in the scope of a method
		//after the method, they are destroyed 
		/*
		 instance method call (the method belongs to the instance, not the class)
		 */
		conventionsInstance.doStuff();
		}
		
	}
}
