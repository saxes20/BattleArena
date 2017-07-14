package differentchars;

import battle.Character;

import java.util.Random;

public class Medic extends Character {
	
	public Medic() {
		super();
		this.strength -= 2;
		this.health += 10;
		this.defense -= 2;
		this.isMedic = true;
	}
	
	public int regainHealth(int health) {
		int originalHealth = health;
		health += 20;
		System.out.println("*** Ultra Heal for " + this.name + " ***");
		System.out.println("" + this.name + " gained " + (health - originalHealth) + " health");
		return health;
	}
}
