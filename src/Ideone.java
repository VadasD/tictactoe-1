/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
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
	     
		// ask the user to create a weapon and then create a champion. Extra credit if you build a battle function
	}
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
				dmgdealt = ((int)(Math.random()*5)+12)*-1;
				System.out.println(lol.getName()+" drinks a potion and restores "+-dmgdealt);
				lol.takeDmg(dmgdealt);
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
	 public String getName(){
			return name;
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
	public int getDmg(){
		return dmg;
	}
	public String getName(){
		return name;
	}
	//create get functions a SET is not required

}
