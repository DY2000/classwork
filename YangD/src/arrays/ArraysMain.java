package arrays;

import java.util.Arrays;

public class ArraysMain {
	
	//private int[] testArray;
	private String[] suits;
	private String[] values;
	
	public ArraysMain() {
		wednesdayMethods();
	}
	
	private void wednesdayMethods() {
		int[] diceRolls = new int[10000];
		populate(diceRolls);
		int[] data = longestConsecutiveSeqAndIndex(diceRolls);
		int max = 1;
		int longest = data[0];
		System.out.println("The longest sequence is " + 
		longest + " rolls. It happened on roll #"+data[1]+" the sequence was "
				+ Arrays.toString(subArray(diceRolls, data[1], data[0]))+ ".");
		while(longest != 11) {
			populate(diceRolls);
			data = longestConsecutiveSeqAndIndex(diceRolls);
			longest = data[0];
			if(longest > max) {
				max = longest;
				System.out.println("The longest sequence is " + 
						longest + " rolls. It happened on roll #"+data[1]+
						" the sequence was: "
						+ Arrays.toString(subArray(diceRolls, 
								data[1], data[0]))+".");
			}
		}
	}
/**
 * Big Idea!
 * Usually a method returns ONE piece of data(i.e. 'int', 'boolean', etc)
 * If we ever want more than one piece of data, one way of doing that
 * is by using an array, as you can see here, a method that returns the Length
 * of the sequence and its START position (both ints)
 * @param arr
 * @return
 */
	private int[] longestConsecutiveSeqAndIndex(int[] arr) {
		//use an int[] to store the data
		int[] data = new int[2]; // element at zero is length, at 1 is position
		data[0] = 1;
		int currentCount = 1;
		for(int i = 0; i < arr.length; i++) {
			while(i + currentCount < arr.length &&
					isConsecutive(arr, i, i+currentCount)) {
			currentCount++;
		}
			if(currentCount > data[0] ) {
				data[0] = currentCount;
				//also store the index where this started
				data[1] = i;
				
			}
			i = i + currentCount-1;
			currentCount = 1;
		}
		return data;
	}

	private void tuesdayMethods() {
		int[] orderTest = {1,2,3,4,5,1,6,7,8,9,10};
//		cycleThrough(orderTest, 5);
//		System.out.println(Arrays.toString(orderTest));
		System.out.println(longestConsecutiveSequence(orderTest));
	}

	private void cycleThrough(int[] arr, int n) {
	for(int i = 0; i < arr.length-1; i++) {
			frontToBack(arr);
	}
	}
	private int longestConsecutiveSequence(int[] arr) {
		int maxLength = 1;
		int currentCount = 1;
		for(int i = 0; i < arr.length; i++) {
			while(i + currentCount < arr.length &&
					isConsecutive(arr, i, i+currentCount)) {
			currentCount++;
		}
			if(currentCount > maxLength ) {
				maxLength = currentCount;
				
			}
			i = i + currentCount-1;
			currentCount = 1;
		}
		return maxLength;
	}	
	/**
	 * returns true if all of the elements from start to end are increasing by 1
	 * example:
	 * iC({1,7,3,6,7,8,12},3,5) -> true;
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private boolean isConsecutive(int[] arr, int start, int end) {
		
		for(int i = start; i < end; i++ ) {
			if(arr[i] + 1 != arr[i+1]) {
				return false;
			}
		}
			return true;
		
		}
		
	

	private void frontToBack(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			swap(arr,i,i+1);
		}
	}
	private void warmUpMethods() {
		int[] orderTest = {1,2,3,4,5,6,7,8,9,10};
		reverseOrder(orderTest);
		System.out.println(Arrays.toString(orderTest));
		System.out.println(Arrays.toString(subArray(orderTest,3,4)));
	}

	
	public void cardMethods() {
		suits = new String[4];
		suits[0] = "Clubs";
		suits[1] = "Hearts";
		suits[2] = "Diamonds";
		suits[3] = "Spades";
		values = new String[13];
		for(int i = 0; i < values.length; i++) {
			values[i] = ""+(i+1);
		}
		values[0] = "Ace";
		values[1] = "King";
		values[2] = "Queen";
		values[3] = "Jack";
		printDeck();
		
		//reverseOrder(testArray);
		//testArray = new int[50];
		//populate1ToN(testArray);
		//shuffle(testArray);
		//swap(testArray, 0,1);
		//populate(testArray);
		//countOccurences(testArray,2,12);
		//System.out.println(Arrays.toString(testArray));

		}
	
	private int[] subArray(int[] arr, int psn, int length) {
		int[] sub = new int[length];
		for(int i = 0; i < length; i++) {
			sub[i] = arr[i+psn];
		}
		return sub;
		
	}
	private String[] printDeck() {
		String[] deck = new String[52];
		int index = 0;
		for (String suit: suits) {
			for(String value: values) {
				deck[index] = value + " of " + suit;
				index++;
			}
		}
			return deck;
		}
		

	private void shuffle(int[] arr) {
		for(int i = 0; i < arr.length; i++)
			swap(arr,i,(int)(Math.random()*arr.length));
		
	}
	private void swap(int[] arr, int i, int j) {
		int placeholder = arr[i];
		arr[i] = arr[j];
		arr[j] = placeholder;

	}
	private void reverseOrder(int[] arr) {
		for(int i = 0; i < arr.length/2; i++) 
			swap(arr,i,arr.length-1-i);
	}
	private void populate1ToN(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (i+1);
		}
		
	}
	/**
	 * Populate arr with numbers from 1 to arr.length, in order
	 * @param arr
	 */
	
	private void countOccurences(int[] arr, int start, int end) {
		int[] counter = new int[end - start + 1];
			for(int value: arr) {
				counter[value - start]++;
			}
			for(int i =0; i < counter.length; i++) {
				System.out.println("The value "+(i+start)+ " was rolled "+counter[i]+ " times.");
			}
	}
	/**
	 * This method populates arr with results from rolling 2 dice
	 * @param arr
	 */
	private void populate(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = diceRoll(2);
		}
		
	}
	public void arrayNotes() {
		//two ways to construct an array:
		int[] first = {0,1,2,3,4,5};
		//this way will only work with the declaration.
		//will not work:
		//first = {6,7,8,9,10};
		
		String[] second = new String[5];
		//you can go on like so, creating values at each index:
		//second[0] = 1;
		//second[1] = 10;
		// Two ways to iterate through an array:
		for (int i = 0; i < second.length; i++) {
			System.out.println("The #"+i+" element is "+second[i]);
		}
		//for(int value: second) {
			//"For each int in secondWay"
		for(String value: second) {
			System.out.println("Element is "+value);
		}
	}
	
	public static void main(String[] args) {
		ArraysMain sample = new ArraysMain();
		//1. Arrays are collections of primitives and Objects
		//Note: This is the ONLY collection of primitives
		
		//2. Size cannot be edited
		
		/*3. Elements of an array are REFERENCES to objects. In
		* other words, changing an element of an array changes the reference,
		* not the object.
		*/
		
	}
	/**
	 * returns the result after rolling n number of dice
	 * @param n
	 * @return
	 */
	public int diceRoll(int n) {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			 	int diceRoll = (int)(Math.random() * 6)+1;
				sum += diceRoll;
			}
			return sum;
		}
	
}
