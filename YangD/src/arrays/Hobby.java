package arrays;

public class Hobby extends Thing {

	public Hobby(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public static Hobby randomHobby() {
		Hobby[] c = {new Hobby("Playing video games"),
					new Hobby("yugioh"),
					new Hobby("walking on da beach")
		};
	
		return c[(int)(Math.random()*c.length)];

}
}