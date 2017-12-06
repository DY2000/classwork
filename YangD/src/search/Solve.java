package search;


//HW 3.3
public class Solve {
	public static int mystery(int x)
	{
	 if (x == 0)
	 {
	  return 0;
	 }
	 else
	 {
	  return (x + mystery(x / 2) + mystery(x / 4));
	  /*
	   * 10 + mystery(5) + mystery(2.5);
	   * 10 + 5 + mystery(2.5) + mystery(1.25) + mystery(2.5);
	   * 10 + 5 + 3 + mystery(1.25) + mystery(0.625) + mystery(2.5);
	   * 10 + 5 + 3 + 1 + 0 + 3 + 1 + 0 = 23 OR
	   * 10 + 5  + 2 + 1 + 0 + 2 + 1 + 0 = 21
	   * closest value is 22 as an answer choice, in between 21 and 23 is 22.
	   *  however, wouldn't it just keep on looping infinitely towards 0, which gives it a stack overflow error?
	   * 
	   */
	 }
	}
	public static int mystery1(int x)
	{
	 if (x == 1)
	  return 2;
	 else
	  return 2 * mystery1(x-1);
	 /*
	  * 2 * 2(m5) * 2(m4) * 2(m3) * 2(m2) * 2 = 64
	  * (m5) = 2 * (m4)
	  * (m4) = 2 * (m3)
	  * (m3) = 2 * (m2)
	  * (m2) = 2 * (m1)
	  * (m1) = 2
	  * 
	  */
	}
	public static int mystery2(int x)
	{
	 if (x == 0)
	 {
	  return 0;
	 }
	 else
	 {
	  return ((x % 10) + mystery2(x / 10));
	  /*
	   * 3 + m2(354.3)
	   * 3 + 4.3 + m2(35.43)
	   * 3 + 4.3 + 5.43 + m2(3.543)
	   * 3 + 4.3 + 5.43 + 3.543 + m2(0.3543) (not sure what to do with decimals, ignore them? Same with mystery, it'll give a stack overflow error if it doesn't ignore decimals.)
	   * 3 + 4 + 5 + 3 = 15
	   */
	 }
	}
	public static int mystery3(int x)
	{
	 if (x <= 1)
	 {
	  return 1;
	 }
	 else
	 {
	  return 2 * mystery3(x - 2);
	  /*
	   * 2 * 2(m8) * 2(m6) * 2(m4) * 2(m2) * 1 (m0)
	   * same concept as mystery1
	   */
	 }
	}
	
	public static int mystery4(int x, int y)
	{
	 if (x >= 100 || y <= 0)
	 {
	  return 1;
	 }
	 else
	 {
	  return mystery4(x + 10, y - 3);
	  /*
	   * self explanatory, if either x >= 100 or y <= 0, it'll equal true.
		* y will fulfill the base case first, which makes the solution 1.
	   */
	 }
	}


	   

	   public static void main(String[] args) {
		   	int number = 10;
		   	int six = 6;
		   	int bignum = 3543;
		  System.out.println(mystery(number));
		  System.out.println(mystery1(six));
		  System.out.println(mystery2(bignum));
		  System.out.println(mystery3(number));
		  System.out.println(mystery4(30,18));
		 
	   }
}
