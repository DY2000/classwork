package caveExplorer;

public class CaveRoom {
	
	private String description;
	private String directions;//tells you which doors can be used
	private String contents;//a symbol should show you what is in the room ('x' when you are in the room)
	private String defaultContents;// what is in the room when you aren't in the room
	
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	//constants
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents("");
		contents = defaultContents;
		//NOTE: Arrays are instantiated with 'null' values
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}


	private void setDirections() {
		directions = "";
		boolean doorFound = false;
		for(int i = 0; i < doors.length; i++) {
			if(doors[i] != null) {
				doorFound = true;
				directions += "There is a "+doors[i].getDescription()+" to the "+
				toDirection(i)+". "+doors[i].getDetails()+"\n";
			}
		}
		if(!doorFound) {
			directions = "There is no way out. You are trapped in this room";
		}
		//hint: to check if a door is null (or not null), use:
		//doors[0] == null   (OR USE   doors[0] != null)
	}
	
	public static String toDirection(int dir) {
		String[] direction = {" THE NORTH", "THE EAST", "THE SOUTH", "THE WEST"};
		return direction[dir];
	}

	public void enter() {
		contents = "X";
	}
	public void leave() {
		contents = defaultContents;
	}
	
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}
	public void addRoom(int dir, CaveRoom caveRoom,Door door) {
		borderingRooms[dir] = caveRoom;
		doors[dir] = door;
		setDirections();
	}
	
	public void interpretInput(String input) {
		while(!isValid(input)) {
			System.out.println("You can only enter 'w','a','s', or 'd' .");
			input = CaveExplorer.in.nextLine();
		}
		int direction = "wdsa".indexOf(input);
		goToRoom(direction);
	}
	private boolean isValid(String input) {
		String words = "wdsa";
		return words.indexOf(input) != -1  && input.length() == 1;
	}
	/**
	 * cave editing guise
	 */
	public static void setUpCaves() {
		//1. Determine size of caves
		CaveExplorer.caves = new CaveRoom[5][5];
		CaveRoom[][] c = CaveExplorer.caves;//create a shortcut for accessing CaveExplorer.caves
		//2. Populate with default caves
		for(int row = 0; row < c.length; row++) {
			for (int col = 0; col < c[row].length;) {
				c[row][col] = new CaveRoom("This cave has coordinates "+row+", "+col);
			}
		}
		//3. Replace some default rooms with custom rooms (SAVE FOR LATER)
		
		//4.set starting room
		CaveExplorer.currentRoom = c[0][1];
		CaveExplorer.currentRoom.enter();
		
		//5. Set up doors
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
		c[1][1].setConnection(EAST, c[1][2], new Door());
		
		CaveRoom[][][] layers = new CaveRoom[3][][];
		layers[0] = new CaveRoom[3][4];
	}
	public void goToRoom(int direction) {
		if(borderingRooms[direction] != null && doors[direction] != null &&
				doors[direction].isOpen()) {
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
			
		}else {
			System.err.println("You can't do that!");
		}
	}
	public static int oppositeDirection(int dir) {
		int[] direction = {2,3,0,1};
		return direction[dir];
	}
	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDirections() {
		return directions;
	}


	public void setDirections(String directions) {
		this.directions = directions;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public Door getDoor(int direction) {
		return doors[direction];
	}

}
