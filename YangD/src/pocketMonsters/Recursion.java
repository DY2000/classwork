package pocketMonsters;

public class Recursion {
	 
	 public static void main(String[] args){
		 int value = 18;
		 System.out.println(value+"! is equal to "+factorial(value));
		 System.out.println(value+ " has "+countPrimeFactors(value, 2)+" prime factors.");
		 }

		 public static int countPrimeFactors(int value, int testPrime) {
			 if(value / testPrime) {
				 
			 }
		 }

		 public static int factorial(int value) {
			 int factors = value;
		 
			 if(value > 0) {
				 factors = factors * (value - 1);
				 value = value - 1;
				 
			 }
			 	return factors;
		 }
}