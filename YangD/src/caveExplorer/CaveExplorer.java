package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {
	
	public static CaveRoom[][] caves;
	public static Scanner in;//for user input
	public static CaveRoom currentRoom;// changes as the user moves
	public static Inventory inventory; //dem haxs
	private static boolean playing = true;
	

	public static void main(String[] args) {
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();
		inventory = new Inventory();
		startExploring();

	}
	
	public static void print(String s) {
		System.out.println(s);//Later: consider replacing with the more sophisticated "printMultiLine"
	}
	private static void startExploring() {
		while(playing) {
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print(currentRoom.getDirections());
			print("What would you like to do?");
			currentRoom.interpretInput(in.nextline());
		}
	}

}
