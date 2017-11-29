package pocketMonsters;

public class Pokemon {
	private int level;
	private int hp;
	private String name;
	private boolean poisoned;
	public static void main(String[] args) {
		 Pokemon squirtle = new Pokemon("Squirtle",26);
		 Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		 squirtle.iChooseYou();
		 bulbasaur.iChooseYou();
		 System.out.println("Squirtle is preparing to attack with water blast");
		 squirtle.attack(bulbasaur, new Attack() {
		 
		 public void attack(Pokemon target) {
		 int hp = target.getHP();
		 target.setHP(hp/2);
		 }
		 });
		 System.out.println("Bulbasaur is preparing to attack with poison.");
		 bulbasaur.attack(squirtle, new Attack() {
		 
		 public void attack(Pokemon target) {
		 target.setPoisoned(true);
		 }
		 });
		 squirtle.lapse();
		 bulbasaur.lapse();
		 printScore(squirtle, bulbasaur);
		 System.out.println(x);
		 squirtle.attack(bulbasaur, new Attack())
		 
		 	public void attack(Pokemon target) {
			 int hp = target.setHp(hp-100);
		 }
			 
			 
		 
		 }
	public Pokemon(String name, String level) {
		hp = 100;
		poisoned = false;
	}
	public void iChooseYou() {
		System.out.print(name+", "+name+"!");
		
	}
	private String getName() {
		return name;
	}
	public int getHP() {
		return hp;
	}
	public void setHp(int newHP) {
		hp = newHP;
	}
	
	public void levelUp(Effect e) {
		level++;
		e.happen();
	}
	private void setPoisoned(boolean b) {
		poisoned = true;
	}
	private void lapse() {
		if(poisoned) {
			hp -= 15;
		}
	}
}
