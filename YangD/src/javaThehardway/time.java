package javaThehardway;

public class time {
	public static int binarySearch(int [] searchThis, int startIndex, int endIndex, int target) {
		int middle = (startIndex + endIndex) / 2;
		if(middle > target)
		{
			int middle = (middle + startIndex) / 2;
			
		}
		else if (middle < target){
			int middle = (middle + endIndex) / 2;
		}
		else {
			return 1;
		}
		return -1;
	}


	private int search(int[] searchThis, int target) {
		
		for(int i = 0; i < searchThis.length; i++) {
			if(target == searchThis[i]) return i;
				
		}
		

		return -1;
	}
}
