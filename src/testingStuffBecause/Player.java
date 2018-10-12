package testingStuffBecause;

public class Player {
	private String name;
	private int money;
	private int exp;
	private int death;
	private int currSlot = 0;
	private boolean luck;
	private boolean sword;
	private boolean trap;
	private Equipment[] inventory = new Equipment[5];
	
	private Room currRoom;
	
	Player(String name, int money, int exp, int death) {
		this.name = name;
		this.money = money;
		this.exp = exp;
		this.death = death;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean addItem(Equipment newItem) {
		if (this.money - newItem.getPrice() >= 0) {
			if (currSlot >= 5) {
				System.out.println("Your inventory is full");
				return false;
			} else {
				inventory[currSlot] = newItem;
				this.money -= newItem.getPrice();
				currSlot++;
				if (newItem.getName().equals("Free Money")) {
					addMoney(5000);
				}
				return true;
			}
		} else {
			System.out.println("Not enough money");
			return false;
		}
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public int getExp() {
		return this.exp;
	}
	
	public int getDeath() {
		return this.death;
	}
	
	public void whatName(String newName) {
		this.name = newName;
	}
	
	public void setRoom(Room newRoom) {
		currRoom = newRoom;
	}
	
	public Room getRoom() {
		return currRoom;
	}

	
	public void addMoney(int add) {
		if (luck) {
			this.money += 3 * add;
		} else {
			this.money += add;
		}
	}
	
	public void setMoney (int set) {
		this.money = set;
	}
	
	public void addDeath() {
		this.death++;
	}
	
	public void addExp(int add) {
		this.exp += add;
	}
	
	public void setExp(int set) {
		this.exp = set;
	}
	
	public void setLuck(boolean set) {
		luck = set;
	}
	
	public void setSword(boolean set) {
		sword = set;
	}
	
	public boolean hasSword() {
		return sword;
	}
	
	public void setTrap(boolean set) {
		trap = set;
	}
	
	public boolean hasTrap() {
		return trap;
	}
	
	public void reset() {
		inventory[0] = null;
		inventory[1] = null;
		inventory[2] = null;
		inventory[3] = null;
		inventory[4] = null;
		sword = false;
		luck = false;
		trap = false;
		money = 100;
		currSlot = 0;
	}
	
	public void printStats(int die) {
		if (die == 0) {
			System.out.println("You have " + this.money + " money. " + this.exp + " experience.");
			System.out.println("You have died " + death + " times");
		}else if(die == 1) {
			System.out.println("You died with " + this.money + " money and " + this.exp + " experience.");
			System.out.println("You have died " + death + " times");
		}else if(die == 2) {
			System.out.println("You won the game with " + this.money + " money and " + this.exp + " experience.");
		}
		
	}
	
	public void printInventory() {
		System.out.println("Inventory:");
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null) {
				System.out.println("Name: " + inventory[i].getName());
			}
		}
	}
	
}
