

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * 
 * @author Andrew Laurita
 * a text based fighting game between an unnamed hero and various enemies
 */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		boolean battle = true; int score = 0;
		System.out.println("Pick a hero, player");
		Scanner scanner = new Scanner(System.in);
	    String heroname = scanner.nextLine();
	    System.out.println("Now select a weapon");
	    String wpnname = scanner.nextLine();
	    Weapon yo = new Weapon(wpnname);
	    Champion lol = new Champion(heroname,yo);
	    while (battle = true){
	    	Monster evil = new Monster((int)(Math.random()*4)+1);
	    	toBattle(heroname, evil, lol, yo);
	    	if (lol.getHealth()<=0){
	    		System.out.print("game over, score: "+score);
	    		break;
	    	}
	    	score++;
	    } 
	}
	/**
	 * battle function
	 * @param heroname
	 * @param evil
	 * @param lol
	 * @param yo
	 */
	public static void toBattle(String heroname, Monster evil, Champion lol, Weapon yo){
		System.out.println(heroname+" has encountered a "+ evil.getName());
		int dmgdealt; int choice;
		Scanner scanner = new Scanner(System.in);
		while ((evil.getHealth()>0) && (lol.getHealth()>0)){
			System.out.println("Press 1 to attack and 2 to heal");
			choice = scanner.nextInt();
			if (choice==1){
				dmgdealt = yo.getDmg() + (int)(Math.random()*5)+2;
				System.out.println(evil.getName()+" was stuck by "+ yo.getName());
				evil.takeDmg(dmgdealt);
				System.out.println(dmgdealt+" damage was dealt to the "+evil.getName());
			}
			else if (choice==2){
				if (lol.getHealth()>=100){
					System.out.println("your health is already full");
				}
				else {
				dmgdealt = ((int)(Math.random()*5)+12)*-1;
				System.out.println(lol.getName()+" drinks a potion and restores "+-dmgdealt);
				lol.takeDmg(dmgdealt);
				}
			}
			System.out.println("the "+evil.getName()+" attacks");
			dmgdealt=evil.getDmg()+ (int)(Math.random()*3)+1;
			lol.takeDmg(dmgdealt);
			System.out.println(dmgdealt+" damage dealt to "+lol.getName());
			System.out.println(lol.getName()+" has "+lol.getHealth()+" health remaining");
			System.out.println("the "+evil.getName()+" has "+evil.getHealth()+" health remaining");
			if (evil.getHealth()<0){
				System.out.println("the "+evil.getName()+" was slain");
			}
		}
	}
}
/**
 * 
 * @author Andrew
 * class for the various monsters
 */
class Monster
{
	private String name;
	private int health;
	private int dmg;
	
	public Monster(int m)
	{
		switch(m){
			case 1: name = "Wolf";
					health = 40;
					dmg = 15;
					break;
			case 2: name = "Goblin";
					health = 50;
					dmg = 13;
					break;
			case 3: name = "Bandit";
					health = 80;
					dmg = 11;
					break;
			case 4: name = "Troll";
					health = 150;
					dmg = 5;
					break;
		}
	}
	public int getHealth(){
		return health;
	}
	public void takeDmg(int dmgdealt){
		health -= dmgdealt;
	}
	public String getName(){
		return name;
	}
	public int getDmg(){
		return dmg;
	}
}
/**
 * 
 * @author Andrew_2
 * Champion class
 */
class Champion  
{

	private int health;
	private String name;
	private Weapon arm;

	public Champion(String heroname, Weapon wpnname)   
	{
		health = 100;
		name = heroname;
		arm = wpnname;

	}

	 public int getHealth()    
	{
		return health;
	}
	 public void takeDmg(int dmgdealt){
		 health -= dmgdealt;
	 }
	 public String getName(){
			return name;
	}
}
/**
 * 
 * @author Andrew_2
 * Class that holds the weapon data
 */
class Weapon
{

	private int dmg; 
	private String name;

	public Weapon(String wpnname)  
	{
		name = wpnname;
		dmg = (int)(Math.random()*5)+10;
	}
	public int getDmg(){
		return dmg;
	}
	public String getName(){
		return name;
	}
	

}
