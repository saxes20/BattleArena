package battle;
import java.util.Random;

public class Character {
	    public String name;
	    public String myClass; 
	    
	    // Private stats we don't want outside classes changing
	    public int strength = 10;
	    public int health = 20;
	    public int defense = 5;
	    public int critChance = 4;
	    public boolean isMedic = false;
	    
	    public Random randGen = new Random();
	     
	    public Character(){
	        // Class constructor
	  
	    }
	     
	     
	    public Character(int strength, int defense, int health){
	        this();
	        this.strength = strength;
	        this.defense = defense;
	        this.health = health;
	         
	     }
	     
	     
	    // The code to run when this character attacks
	    public int attack(Character target){
	    	if (this.strength > 8) {
	    		critChance = 5;
	    	}
	    	int damageDealt = this.strength + Arena.randomGen.nextInt(critChance);
			System.out.println(damageDealt + " attack damage.");
			return target.takeDamage(damageDealt);
	         
	    }
	     
	    // The code to run when this character takes some damage
	    public int takeDamage(int damage){
	    	int damageTaken = damage - this.defense;
			/* this.health -= damageTaken;
			if (this.health < 0) {
				this.health = 0;
			} */
			return damageTaken;
	    }
	     
	    // This method will return the player's health so other classes can read it, but not change it.
	    public int getHealth(){
	        return this.health;
	    }
	     
	     
	    // This method checks if the character is alive
	    public boolean isAlive(){
	        return this.health > 0;
	    }
	    
	    public int regainHealth(int health) {
	    	return health;
	    }
	     
}
