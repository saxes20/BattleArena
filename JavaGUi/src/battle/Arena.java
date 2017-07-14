package battle;
import java.util.Random;
import java.util.Scanner;

import battle.Character;
import differentchars.*;

public class Arena {
	public static Random randomGen = new Random();
	
	public Character character;
	public Character character2;
	public Scanner myScanner;
	public String decision;
	
	//private static String[] nameList = {"Geoff", "Steve","Kruger", "Killer Keemstar"};
	
	public void runBattle(Character player1, Character player2) {
		
		myScanner = new Scanner(System.in);
		boolean decisionMade = false;
		while (!decisionMade)  {
			System.out.println("Would you like the battle to run manually or automatically?");
			decision = myScanner.next();
			if (decision.equalsIgnoreCase("manually")) {
				decision = "manually";
				decisionMade = true;
			}
			else if (decision.equalsIgnoreCase("automatically")) {
				decision = "automatically";
				decisionMade = true;
			}
			else {
				System.out.println("Please enter either 'automatically' or 'manually'");
			}
		} 
		
		//Character player2 = new Character();
		
		/* player2.name = nameList[Arena.rrandomGen.nextInt(nameList.length)];
		player2.strength = Arena.randomGen.nextInt(5) + 8;
		player2.health = Arena.randomGen.nextInt(31) + 20;
		player2.defense = Arena.randomGen.nextInt(3) + 4; */
		
		/* 
		if (player2.name.equals(player1.name)){
            player2.name += " 2";
        } */
         
		//player2.health = 50;
		System.out.println("" + player1.name + " vs. " + player2.name);
		System.out.println("" + player1.name + " HP: " + player1.health + " vs. " + player2.name + " HP: " + player2.health);
		System.out.println("" + player1.name + " is a " + player1.myClass + " while " + player2.name + " is a " + player2.myClass);
		
		if (decision.equals("automatically")) {
			int turns = 0;
			while (player1.isAlive() && player2.isAlive()) {
				turns++;
				int randomPick = randomGen.nextInt(2);
				if (randomPick == 0) {
					int damage = player1.attack(player2);
					if (damage > 0) {
						player2.health -= damage;
					} else {
						damage = 0;
					}
				
					if (turns > 20) {
						if (player2.myClass.equalsIgnoreCase("Tank")) {
							
						} else {
							int decreaseChance = randomGen.nextInt(10) + 1;
							if (decreaseChance == 5) {
								player2.defense -= 2;
							}
						}
					}
				
					if (player2.isMedic) {
						if (randomGen.nextInt(100) < 20) {
							player2.health = player2.regainHealth(player2.health);
						}
					}
				
					if (player2.health < 0) {
						player2.health = 0;
					} 
				
					System.out.println("" + player2.name +  " took " + damage + " damage. His health is now "  + player2.health);
				} else{
					int damage = player2.attack(player1);
					if (damage > 0) {
						player1.health -= damage;
					} else {
						damage = 0;
					}
				
					if (turns > 20) {
						if (player1.myClass.equalsIgnoreCase("Tank")) {
						
						} else {
							int decreaseChance = randomGen.nextInt(10) + 1;
							if (decreaseChance == 5) {
								player1.defense -= 2;
							}
						}
					}
				
					if (player1.isMedic) {
						if (randomGen.nextInt(100) < 20) {
							player1.health = player1.regainHealth(player1.health);
						}
					}
				
					if (player1.health < 0) {
						player1.health = 0;
					} 
				
					System.out.println("" + player1.name + " took " + damage + " damage. His health is now "  + player1.health);
				}//end if else
			
			}//end while
		
		} 
		
		if (decision.equals("manually")) {
			int turns = 0;
			while (player1.isAlive() && player2.isAlive()) {
				System.out.println("Type in anything to progress through the battle.");
				Scanner myScanner2 = new Scanner(System.in);
				String start = myScanner2.nextLine();
				boolean go = false;
				if (start != " ") {
					go = true;
					while (go) {
						turns++;
						int randomPick = randomGen.nextInt(2);
						if (randomPick == 0) {
							int damage = player1.attack(player2);
							if (damage > 0) {
								player2.health -= damage;
							} else {
								damage = 0;
							}
						
							if (turns > 20) {
								if (player2.myClass.equalsIgnoreCase("Tank")) {
									
								} else {
									int decreaseChance = randomGen.nextInt(10) + 1;
									if (decreaseChance == 5) {
										player2.defense -= 2;
										if (player2.defense < 0) {
											player2.defense = 0;
										}
										System.out.println("" + player2.name + " has lost 2 points of defense due to armor withering. His defense is now " + player2.defense);
									}
								}
							}
							
							if (player1.isMedic) {
								if (randomGen.nextInt(100) < 20) {
									player1.health = player1.regainHealth(player1.health);
								}
							}
						
							if (player2.isMedic) {
								if (randomGen.nextInt(100) < 20) {
									player2.health = player2.regainHealth(player2.health);
								}
							}
						
							if (player2.health < 0) {
								player2.health = 0;
								//player2Alive = false;
							} 
						
							System.out.println("" + player2.name +  " took " + damage + " damage. His health is now "  + player2.health);
						} else{
							int damage = player2.attack(player1);
							if (damage > 0) {
								player1.health -= damage;
							} else {
								damage = 0;
							}
						
							if (turns > 20) {
								if (player1.myClass.equalsIgnoreCase("Tank")) {
								
								} else {
									int decreaseChance = randomGen.nextInt(10) + 1;
									if (decreaseChance == 5) {
										player1.defense -= 2;
										if (player1.defense < 0) {
											player1.defense = 0;
										}
										System.out.println("" + player1.name + " has lost 2 points of defense due to armor withering. His defense is now " + player1.defense);
									}
								}
							}
							
							if (player2.isMedic) {
								if (randomGen.nextInt(100) < 20) {
									player2.health = player2.regainHealth(player2.health);
								}
							}
						
							if (player1.isMedic) {
								if (randomGen.nextInt(100) < 20) {
									player1.health = player1.regainHealth(player1.health);
								}
							}
						
							if (player1.health < 0) {
								player1.health = 0;
								//player1Alive = false;
							} 
						
							System.out.println("" + player1.name + " took " + damage + " damage. His health is now "  + player1.health);
						}
						go = false;
					}//end second while
				}//end start if
			}//end main while
		}//end manually if
		
		if (player1.health > 0) {
			System.out.println("" + player1.name + " wins with " + player1.health + " health remaining!");
		} else {
			System.out.println("" + player2.name + " wins with " + player2.health + " health remaining!");
		}//end if
		
		myScanner.close();

	}//end void

	public static void main(String[] args) {
		// TODO Create more Character classes and randomly choose classes
		
	}//end main void
}//end class
