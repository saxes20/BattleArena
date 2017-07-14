package differentchars;
import battle.Character;

import java.util.Random;

public class Rogue extends Character {
	public int dexterity = 20;
	public Random randomGen = new Random();
	
	public Rogue() {
		super();
	}
	
	public int attack (Character target) {
		boolean critHit = randomGen.nextInt(100) < dexterity;
		int damageDealt = super.strength + randomGen.nextInt(super.critChance);
		if(critHit){
            damageDealt *= 2;
            System.out.println("*** Critical Hit for " + this.name + " ***");
        }
		System.out.println(damageDealt + " attack damage.");
		return target.takeDamage(damageDealt);
	}
}
