package arrays;

import java.util.Arrays;

public class ArraysMain {
	
	//private int[] testArray;
	private String[] suits;
	private String[] values;
	
	public ArraysMain() {
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
		
		//testArray = new int[50];
		//populate1ToN(testArray);
		//shuffle(testArray);
		//swap(testArray, 0,1);
		//populate(testArray);
		//countOccurences(testArray,2,12);
		//System.out.println(Arrays.toString(testArray));
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