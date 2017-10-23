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
			if(doors[0] != null) {
				doorFound = true;
				directions += "There is a "+doors[i].getDescription()+" to the "+
				toDirection(i)+"."+doors[i].getDetails()+ "\n";
			}
			if(!doorFound) {
				directions = "There is no way out. You are trapped in this room";
	}
	
	public static String toDirection(int dir) {
		String[] direction = {" THE NORTH", "THE EAST", "THE SOUTH", "THE WEST"};
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

}
