package differentchars;
import battle.Character;
import java.util.Random;

public class Assassin extends Character {
	public int randomChance = 35;
	public Random randGen = new Random();
	
	public Assassin() {
		super();
	}
	
	public int attack (Character target) {
		boolean selected = randGen.nextInt(100) < randomChance;
		int damageDealt = super.strength + randGen.nextInt(super.critChance);
		if(selected) {
			damageDealt = damageDealt/2;
			damageDealt = damageDealt * 3;
			System.out.println("*** Serrated Strikes for " + this.name + " ***");
		} 
		System.out.println(damageDealt + " attack damage.");
		return target.takeDamage(damageDealt);
	}
	
}
