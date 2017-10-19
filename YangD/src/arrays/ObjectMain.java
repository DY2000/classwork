package arrays;

public class ObjectMain {

	public ObjectMain() {
		Person[] people = new Person[20];
		populate(people);
		// people[0] = new Thing("toaster oven");
		//Person[] group = selectGroup(people, 5);
		for(Person pep: people)
			pep.mingle(people);
			System.out.println(pep);
			pep.stateYourFriends();
		}
		
	
	
	private void analyzeCommonalities(Person[] people, Person[] group) {
		double averageCommonalities = 0;
		double trials = 500;
		
		double sumCounts = 0;
		for(int i = 0; i < trials; i++)
	}
	
	private void populate(Object[] people) {
		for(int i = 0; i < people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START,
					Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START,
					Person.LAST_MIDDLE, Person.LAST_END);
			Borough home = randomBorough();
			//BIG IDEA:
			//In an Object array, you can have multiple data types!
			//(this is unlike a primitive array, like int[], boolean[] etc
			if(Math.random() < .6) {
				//60% of the time
				int money = (int)(Math.random()*20+1)*100000;
				people[i] = new Athlete(firstName,lastName,home,money);
			}
				else {
					// the other 40% of the time
					people[i] = new Person(firstName, lastName, home);
				}
			}
			
		}
	
	private Person[] selectGroup(Person[]population, int length) {
		Person[] group = new Person[length];
		for(int i = 0; i < length; i ++) {
			Person toAdd = randomPerson(population);
			while(alreadyContains(group, toAdd)) {
				toAdd = randomPerson(population);
			}
			group[i] = toAdd;
		}
		return group;
	}
	
	private Person randomPerson(Person[] population) {
		int index = ((int)Math.random() * population.length);
			return population[index];
	}
	
	private boolean alreadyContains(Person [] population, Person pep) {
		for(int i = 0; i < population.length; i ++)
			if(population[i] == pep) {
				return true;
			}
				return false;
			}

	private Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int)(Math.random()*Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {
		return get(a)+get(b)+get(c);
	}

	private String get(String[] a) {
		return a[(int)(Math.random() * a.length)];
	}

	public static void main(String[] args) {
		ObjectMain obj = new ObjectMain();
	}
	

}
