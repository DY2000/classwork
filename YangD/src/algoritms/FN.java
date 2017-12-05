package algoritms;

public class FN {
	
	public static void main(String[] args) {
		String starts = "A";
		String helps = "B";
		String ends = "C";
			hanoi(3,starts,helps,ends);
		}

			public static void hanoi(int n, String start, String help, String end) {
				if(n == 1) {
					System.out.println(start + " to " +end);
				}
				else {
					hanoi(n-1,start,end,help);
					System.out.println(start + " to " +end);
					hanoi(n-1,help,start,end);
				}
		}
}
