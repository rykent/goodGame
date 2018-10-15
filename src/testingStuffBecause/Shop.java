//Hi how are ya

package testingStuffBecause;

import java.util.Scanner;

public class Shop {
	
	static Scanner input = new Scanner(System.in);
	
	private Equipment[] shopInventory = new Equipment[5];
	Shop() {
		shopInventory[0] = new Equipment("Luck Voucher", "Triples money recieved", 50);
		shopInventory[1] = new Equipment("Big Chest", "Instantly gives you 1000 money", 200);
		shopInventory[2] = new Equipment("Experience Boost", "Instantly gives you 1000 experience", 200);
		shopInventory[3] = new Equipment("Fred Trap", "Protects against Fred", 250);
		shopInventory[4] = new Equipment("Slayers Sword", "Instantly kills dragon", 3000);
	}
	
	public void printItems(Player player) {
		System.out.println("You currently have " + player.getMoney() + " money.");
		for (int i = 0; i < shopInventory.length; i++) {
			System.out.println("Name: " + shopInventory[i].getName() + ". Price: " + shopInventory[i].getPrice());
			System.out.println("Description: " + shopInventory[i].getDesc());
		}
		boolean shopChoice = true;
		
		while (shopChoice) {
			System.out.println("What do you want to buy? Type \"exit\" to exit the shop.");
			String whatItem = input.nextLine();
			whatItem = whatItem.toLowerCase();
			
			if (whatItem.equals("luck voucher")) {
				buyLuck(player);
			} else if (whatItem.equals("big chest")) {
				buyChest(player);
			} else if (whatItem.equals("experience boost")) {
				buyExp(player);
			} else if (whatItem.equals("fred trap")) {
				buyTrap(player);
			} else if (whatItem.equals("slayers sword")) {
				buySword(player);
			} else if (whatItem.equals("exit")) {
				shopChoice = false;
			} else {
				System.out.println("Not an item.");
			}
		}
		System.out.println("Thanks for shopping!");
		
	}
	
	public void buyLuck(Player player) {
		if (player.addItem(shopInventory[0])) {
			System.out.println("You have bought the Luck Voucher");
			player.setLuck(true);
		}
	}
	public void buyChest(Player player) {
		if (player.addItem(shopInventory[1])) {
			System.out.println("You have bought the Big Chest");
			player.addMoney(1000);
		}
	}
	public void buyExp(Player player) {
		if (player.addItem(shopInventory[2])) {
			System.out.println("You have bought the Experience Boost");
			player.addExp(1000);
		}
	}
	public void buyTrap(Player player) {
		if (player.addItem(shopInventory[3])) {
			System.out.println("You have bought the Fred Trap");
			player.setTrap(true);
		}
	}
	public void buySword(Player player) {
		if (player.addItem(shopInventory[4])) {
			System.out.println("You have bought the Slayers Sword");
			player.setSword(true);
		}
		
	}
}
