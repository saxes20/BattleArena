package differentchars;

import battle.Character;

import java.util.Random;

public class Tank extends Character{
	public int randChance = 20;
	public Random randGen = new Random();
	
	public Tank() {
		super();
	}
	
	public int takeDamage(int damage) {
		boolean selected = randGen.nextInt(100) < randChance;
		if (selected) {
			System.out.println("*** Ultra Armor Triggered for " + this.name + " ***");
			return 0;
		} else {
			int damageTaken = damage - super.defense;
			return damageTaken;
		}
	}
}
