package testingStuffBecause;

import java.util.Scanner;

public class Game {

	static Scanner input = new Scanner(System.in); 
	static Player player = new Player("", 100, 0, 0); 
	static boolean win_game;
	static Shop theShop = new Shop();
	
	/**
	 * This amalgamation of while loops and if statements is our poor excuse for a main method.
	 * It runs through a basic story where you make two choices and there are four endings.
	 * It also calls on several variables from other classes to control stats like your money,
	 * experience, and items. You get the items from the shop, which is also called on from
	 * another class. You buy the items with the money. It all makes sense now. At the beginning
	 * of the method it asks you if you want to play through the original game or the improved
	 * game, which is held in a different class and employs the use of 2D arrays.
	 * 
	 * @author Jasper Bull
	 */
	
	public static void main(String[] args) {
		boolean whileGame = true;
		while(whileGame) {
		System.out.println("Do you want to play the real game or the better game? (real/better)");
		String whatGame = input.nextLine();
		if (whatGame.equals("better")) {
			BetterGame betterGame = new BetterGame(player);
			betterGame.playGame();
		} else if (whatGame.equals("real")) {
		
		boolean runGame = true;
		while (runGame) {
			System.out.println("Type \"shop\" to enter the shop, and type \"stats\" to check your stats.");
			System.out.println("Type the name of an item to use the item.");
			System.out.println("What is your name?");
			player.whatName(input.nextLine());
			System.out.println("Glad to meet you, " + player.getName());
			player.printStats(0);
		
			System.out.println("Welcome to the fantastical world of Design Tech High School!");
			System.out.println("As you may know, the mascot of this school is the Dragons.");
			System.out.println("Unfortunately for you, a dragon is attacking this school right now.");
		
			boolean choice1 = true;
			while(choice1) {
				System.out.println("Would you like to fight the dragon, or run away? (fight/run)");
		
				String fightDragon = input.nextLine();
				fightDragon = fightDragon.toLowerCase();
		
		
				if (fightDragon.equals("fight")) {
					choice1 = false;
					System.out.println("You decided to fight the dragon. You heroically you run towards the dragon");
					System.out.println("There is a sword laying on the ground, and 50 money. You take the money.");
					player.addMoney(50);
			
					boolean choice2 = true;
					while (choice2) {
						System.out.println("Do you pick up the sword or fight the dragon mano on mano? (sword/mano)");
						String sword = input.nextLine();
						sword = sword.toLowerCase();
			
						if (sword.equals("sword")) {
							System.out.println("You manage to stab the dragon in the throat. You gain 75 experience. But the sword");
							System.out.println("goes in too far. You fall into the dragons stomach. Unfortunately you die. The end.");
							player.addExp(75);
							choice2 = false;
				
						} else if (sword.equals("mano")) {
							System.out.println("You idiot. You absolute buffoon. You think you can take on a dragon unarmed?");
							System.out.println("You're either the dumbest or the most confident person on earth,");
							if (player.getExp() > 996469859) {
								System.out.println("You take the dragon in a intense hand on hand battle. The dragon is no match");
								System.out.println("for your " + player.getExp() + ". You kill the dragon and take all of its experience.");
								System.out.println("You win. The end.");
								player.addExp(996469859);
								win_game = true;
								choice2 = false;
							} else {
								System.out.println("Either way, that doesn't change the fact that your current experience is " + player.getExp() + ".");
								System.out.println("The dragon has 99646985 experience. Fool. In fact, because of that decision,");
								System.out.println("I'm making you lose all your experience. You are but a flea to the dragon. You");
								System.out.println("are killed instantly. You die. The end.");
								player.setExp(0);
								choice2 = false;
							}
			
						} else if (sword.equals("shop")) {
							theShop.printItems(player);
						} else if (sword.equals("slayers sword")) {
							if (player.hasSword()) {
								win_game = true;
								System.out.println("You kill the Dragon. You win. The end.");
								choice2 = false;
								player.addExp(1000);
							} else {
								System.out.println("You don't have the Slayers Sword.");
							}
			
						} else if (sword.equals("stats")) {
							player.printStats(0);
							player.printInventory();
						} else {
							System.out.println("Not an option.");
						}
					}
		
				} else if (fightDragon.equals("run")) {
					choice1 = false;
					System.out.println("You decided to run away.");
					System.out.println("Heroically, you dodge through rubble and avoid the dragon's fiery blasts");
					System.out.println("as fireball after fireball shoot in your direction. You gain 50 experience and 75 money.");
					System.out.println("As you hastefully dash away from the action, you encounter your good friend,");
					System.out.println("Fred, trapped under the rubble.");
					player.addExp(50);
					player.addMoney(75);
			
					boolean choice3 = true;
					while (choice3) {
						System.out.println("Do you help Fred, or run away? (help/run)");
			
						String helpFred = input.nextLine();
						helpFred = helpFred.toLowerCase();
			
						if (helpFred.equals("help")) {
							System.out.println("You run to the aid of your helplessly trapped friend. Unfortunately,");
							System.out.println("the dragon is still hot on your heels and you both die in a fire.");
							System.out.println();
							System.out.println("The end.");
							choice3 = false;
				
						} else if (helpFred.equals("run")) {
							System.out.println("You wisely notice that  you are unable to help your friend, due to the");
							System.out.println("direness of your situation. Fred, however, bears a grudge. You successfully");
							System.out.println("escape from the dragon. Your now enemy Fred is saved later by the paramedics.");
							System.out.println("Later that night, Fred sneaks out of the hospital and into your place of residence.");
							System.out.println("He is angry. You are murdered. You die. He steals all your money and you lose all");
							System.out.print("your experience.");
							if (player.hasTrap()) {
								System.out.println(" The Fred trap did not work.");
							} else {
								System.out.println();
							}
							System.out.println("The end.");
							player.setMoney(0);
							player.setExp(0);
							choice3 = false;
				
						} else if (helpFred.equals("shop")) {
							theShop.printItems(player);
						} else if (helpFred.equals("slayers sword")) {
							if (player.hasSword()) {
								win_game = true;
								System.out.println("You kill the Dragon. You win. The end.");
								choice3 = false;
								player.addExp(1000);
							} else {
								System.out.println("You don't have the Slayers Sword.");
							}
			
						} else if (helpFred.equals("stats")) {
							player.printStats(0);
							player.printInventory();
						} else {
							System.out.println("Not an option.");
						}
					}
		
				} else if (fightDragon.equals("shop")) {
					theShop.printItems(player);
				} else if (fightDragon.equals("slayers sword")) {
					if (player.hasSword()) {
						win_game = true;
						System.out.println("You kill the Dragon. You win. The end.");
						choice1 = false;
						player.addExp(1000);
					} else {
						System.out.println("You don't have the Slayers Sword.");
					}
		
				} else if (fightDragon.equals("stats")) {
					player.printStats(0);
					player.printInventory();
				} else {
					System.out.println("Not an option.");
				}
			}
			if (win_game) {
				player.printStats(2);
			} else {
				player.addDeath();
				player.printStats(1);
				player.setMoney(100);
			}
			boolean repeatGame = true;
			while (repeatGame) {
				System.out.println("Would you like to play again? (yes/no)");
				String repeat = input.nextLine();
				repeat = repeat.toLowerCase();
				if (repeat.equals("yes")) {
					runGame = true;
					repeatGame = false;
					player.reset();
				}else if (repeat.equals("no")) {
					runGame = false;
					repeatGame = false;
					whileGame = false;
				}else {
					System.out.println("Not an option.");
				}
			}
		}
		} else {
			System.out.println("Not an option. Please select \"real\" or \"better\"");
		}
		}
	}
}
