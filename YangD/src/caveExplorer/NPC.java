package caveExplorer;

public class NPC {	
	//fields needed to program navigation
	private CaveRoom[][] floor;//area where NPC is in
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;
	
	//these fields are about interaction with NPC
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;
	
	public NPC() {
		this.floor = CaveExplorer.caves;
		this.activeDescription = "There is a person standing in the room"
				+ " waiting to talk to you. Press 'e' to talk.";
		this.inactiveDescription = "The person you spoke to earlier"
				+ " is standing here.";
		this.currentCol = -1;
		this.currentRow = -1;
		currentRoom = null;
		active = true;
	}	
	public void act() {
		CaveExplorer.print("There is nothing to interact with.");
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("e")) {
			CaveExplorer.print("Far off in the distance, you hear a damsel in distress.");
			 s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("Far off in the distance, you hear a damsel in distress.");
		active = true;
	}


	public void interact() {
		CaveExplorer.print("Let's interact! Type 'bye' to Stop!");
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("bye")) {
			CaveExplorer.print("Yeah... I don't do a lot...");
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("Later, Aligator!");
		active = false;
	}

	public boolean isActive() {
		// TODO Auto-generated method stub
		return active;
	}
	
	public String getDescription() {
		// TODO Auto-generated method stub
		return activeDescription;
	}

	public String getInactiveDescription() {
		// TODO Auto-generated method stub
		return inactiveDescription;
	}

	public String getSymbol() {
		// TODO Auto-generated method stub
		return "P";
	}

	public void setPosition(int row, int col) {
		// TODO Auto-generated method stub
		if(row >= 0 && row < floor.length && col >= 0 && col < floor[row].length 
				&& floor[row][col] instanceof NPCRoom)
		{
			if(currentRoom != null) {
				currentRoom.leaveNPC();
			}
			currentRow= row;
			currentCol = col;
			//cast the CaveRoom to NPCRoom
			currentRoom = (NPCRoom)floor[row][col];
			currentRoom.enterNPC(this);
		}
	}

	public void autoMove() {
		// TODO Auto-generated method stub
		if(active) {
			int[] move = calculateMove();
			int newRow = currentRow + move[0];
			int newCol = currentCol + move[1];
			setPosition(newRow, newCol);
		}
	}
	private int[] calculateMove() {
		int[][] possibleMoves = {{-1,0},{0,1},{1,0},{0,-1}};
		int index = (int)(Math.random() * possibleMoves.length);
		int[] newPosition = new int[2];
		newPosition[0] = currentRow + possibleMoves[index][0];
		newPosition[1] = currentCol + possibleMoves[index][1];
		while(currentRoom.getDoor(index) == null ||
			!(CaveExplorer.caves[newPosition[0]][newPosition[1]]instanceof NPCRoom)) {
			index = (int)(Math.random() * possibleMoves.length);
			newPosition[0] = currentRow + possibleMoves[index][0];
			newPosition[1] = currentCol + possibleMoves[index][1];
		}
		return newPosition;
	}
}