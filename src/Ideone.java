/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		boolean battle = true;
		System.out.println("Pick a hero, player");
		Scanner scanner = new Scanner(System.in);
	    String heroname = scanner.nextLine();
	    System.out.println("Now select a weapon");
	    String wpnname = scanner.nextLine();
	    Weapon yo = new Weapon(wpnname);
	    Champion lol = new Champion(heroname,yo);
	    while (battle = true){
	    	Monster evil = new Monster((int)(Math.random()*4)+1);
	    	toBattle();
	    }
	     
		// ask the user to create a weapon and then create a champion. Extra credit if you build a battle function
	}
	public static void toBattle(){
		
	}
}
class Monster
{
	private String name;
	private int health;
	private int dmg;
	
	public Monster(int m)
	{
		switch (m){
			case 1: name = "Wolf";
					health = 40;
					dmg = 15;
			case 2: name = "Goblin";
					health = 50;
					dmg = 13;
			case 3: name = "Bandit";
					health = 80;
					dmg = 11;
			case 4: name = "Troll";
					health = 150;
					dmg = 5;
		}
	}
	public int getHealth(){
		return health;
	}
	public void takeDmg(int dmgdealt){
		health -= dmgdealt;
	}
}

class Champion  //if this class was in a separate file it would need to be called public
{

	private int health;
	private String name;
	private Weapon arm;

	public Champion(String heroname, Weapon wpnname)   //set the parameters of this constructor
	{
		health = 100;
		name = heroname;
		arm = wpnname;

	}

	 public int getHealth()    //this is called a helper asset, you need to create a setHealth too. 
	{
		return health;
	}
	 public void takeDmg(int dmgdealt){
		 health -= dmgdealt;
	 }
}

class Weapon
{

	private int dmg;  //let's learn to manage private functions
	private String name;

	public Weapon(String wpnname)  
	{
		name = wpnname;
		dmg = (int)(Math.random()*5)+10;
	}

	//create get functions a SET is not required

}
