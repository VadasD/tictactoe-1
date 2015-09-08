import java.util.Scanner;
public class tictactoe {


	public static void main(String[] args) {
		/*psuedo code for tic tac toe
		program starts and creates 9 variables one for each square
		example:    1|2|3
					4|5|6
					7|8|9
		displays an empty grid in output area
		example:    _|_|_
		            _|_|_
		             | |   
		a scanner is then created and awaits for player ones responses
		says "player 1 please select a spot 1-9"
		player one responds with a number 1-9 (anything else returns "invalid number, please pick a number 1-9")
		whichever variable is picked has its value changed to "X"
		grid is redisplayed with the X in place
		example:    _|_|_
		 			_|X|_
		 			 | | 
		 			player 2 please select an empty spot 1-9
		game continues until program detects that a group of three variables have the same value
		responds with "player 1/2 wins!"
		example:    O|_|_
		 			X|X|X
		 			 |O|O
		 			player 1 wins!*/
		//char one, two, three, four, five, six = _;
		char[] gameboard = new char[9];
		for (int i=0; i<9; i++){
			gameboard[i]= '_';
			if (i>5){
				gameboard[i]=' ';
			}
			//System.out.print(gameboard[i]);
		}
		//char seven, eight, nine = ;
		boolean game = true;
		int playernum = 1;
			while (game==true){
				drawGrid(gameboard);
				System.out.print("\n");
				System.out.println("player "+ playernum + " select a square 1-9");
				Scanner in = new Scanner (System.in);
				String coordinate = in.nextLine();
				try {
					int loc = Integer.parseInt(coordinate.trim());
					if (loc>0 && loc<10 ){
						loc--;
						if (playernum == 1 && gameboard[loc] != 'X' && gameboard[loc] != 'O'){
							gameboard[loc] = 'X';
							if (playernum == 1){
								playernum = 2;
							}
							else if (playernum ==2){
								playernum = 1;
							}
						}
						else if (playernum == 2 && gameboard[loc] != 'X' && gameboard[loc] != 'O'){
							gameboard[loc] = 'O';
							if (playernum == 1){
								playernum = 2;
							}
							else if (playernum ==2){
								playernum = 1;
							}
						}
						else {
							System.out.println("location already occupied");
						}
					}
					else{
						System.out.println("please pick a number 1-9");
					}
				}
				catch (NumberFormatException nfe) {
					System.out.println("invalid coordinate, please pick a number 1-9");
				}
				if (checkWinner(gameboard)){
					System.out.println("end");
					game = false;
				}
			}
		}
		
		public static boolean checkWinner(char[] gameboard){
			int i = 0;
			while (i==0){
				if (gameboard [i]=='_' || gameboard[i]==' '){
					break;
				}
				else if(gameboard[i]!=gameboard[i++]){
					break;
				}
				else if(gameboard[i]!=gameboard[i+2]){
					break;
				}
				else return true;
			}
			return false;
			
			/*if (gameboard[0]==('X'|'O')){
				if (gameboard[0]==(gameboard[1]&gameboard[2])){
					return true;
				}
				if (gameboard[0]==(gameboard[4]&gameboard[8])){
					return true;
				}
				if (gameboard[0]==(gameboard[3]&gameboard[6])){
					return true;
				}
			}
			else if (gameboard[1]==('X'|'O')){
				if (gameboard[1]==(gameboard[4]&gameboard[7])){
					return true;
				}
			}
			else if (gameboard[2]==('X'|'O')){
				if (gameboard[2]==(gameboard[5]&gameboard[8])){
					return true;
				}
			}
			else if (gameboard[3]==('X'|'O')){
				if (gameboard[3]==(gameboard[4]&gameboard[5])){
					return true;
				}
			}
			else if (gameboard[6]==('X'|'O')){
				if (gameboard[6]==(gameboard[7]&gameboard[8])){
					return true;
				}
				if (gameboard[6]==(gameboard[4]&gameboard[2])){
					return true;
				}
			}
			return false;
			*/
		}
	
		public static void drawGrid(char[] gameboard) {
			int y = 0;
			for (int t=0; t<9; t++) {
				if (y<2){
					System.out.print(gameboard[t]+"|");
					y++;
				}
				else if (y==2){
					System.out.print(gameboard[t]);
					y++;
				}
			//System.out.print(y);
				else if (y>2){
					System.out.print("\n");
					t--;
					y=0;
				}
			}
		}
}
	

