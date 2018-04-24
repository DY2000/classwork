package algoritms;

public class NEW {
	

	
	public static String repeat(int num)
	{
		String bounce =  " " + (num / 7) ;
	
		if(num % 5  > 2 || num > 12){
			return bounce + repeat(num / 2);
			
		}
		return bounce;

		
	}
	

	public static void main(String [] args) {
		System.out.print(repeat(49));
	}
}


