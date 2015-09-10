import java.util.Scanner;
public class tictactoe {

/**
 * @author Andrew Laurita
 * @param args
 * Main method which holds the game loop
 */
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
		char[] gameboard = new char[9];
		for (int i=0; i<9; i++){
			gameboard[i]= '_';
			if (i>5){
				gameboard[i]=' ';
			}
		}
		boolean game = true;
		int playernum = 1;
		int q = 0;
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
								q++;
								playernum = 2;
							}
							else if (playernum ==2){
								q++;
								playernum = 1;
							}
						}
						else if (playernum == 2 && gameboard[loc] != 'X' && gameboard[loc] != 'O'){
							gameboard[loc] = 'O';
							if (playernum == 1){
								q++;
								playernum = 2;
							}
							else if (playernum ==2){
								q++;
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
					drawGrid(gameboard);
					System.out.print("\n");
					if (playernum == 1){
						playernum = 2;
					}
					else if (playernum ==2){
						playernum = 1;
					}
					System.out.println("player "+playernum+" wins!");
					game = false;
					break;
				}
				if (q==9){
					drawGrid(gameboard);
					System.out.print("/n");
					System.out.print("tie");
					game = false;
				}
			}
		}
	/**
	 * 
	 * @param gameboard
	 * @return
	 * Method that checks the game board to see if either player has won yet
	 */
		public static boolean checkWinner(char[] gameboard){
			int k = 0;
			int i = 0;
			while (k==0){
				while(i<9){
					if (gameboard[i] =='_' || gameboard[i] ==' '){
						break;
					}
					else if(gameboard[i]!=gameboard[i+1]){
						break;
					}
					else if(gameboard[i]!=gameboard[i+2]){
						break;
					}
					else return true;
				}
				i=i+3;
				if(i>=9){
					k=k+1;
				}
			}
			i=0;
			while (k==1){
				while(i<3){
					if (gameboard[i] =='_' || gameboard[i] ==' '){
						break;
					}
					else if(gameboard[i]!=gameboard[i+3]){
						break;
					}
					else if(gameboard[i]!=gameboard[i+6]){
						break;
					}
					else return true;
				}
				i=i+1;
				if(i>=3){
					k=k+1;
				}
			}
			i=0;
			while (k==2){
					while(i<1){
						if (gameboard[i] =='_' || gameboard[i] ==' '){
							break;
						}
						else if(gameboard[i]!=gameboard[i+4]){
							break;
						}
						else if(gameboard[i]!=gameboard[i+8]){
							break;
						}
						else return true;
					}
					i=i+1;
					if(i>=3){
						k=k+1;
					}
			}
			i=2;
			while (k==3){
					while(i<3){
						if (gameboard[i] =='_' || gameboard[i] ==' '){
							break;
						}
						else if(gameboard[i]!=gameboard[i+2]){
							break;
						}
						else if(gameboard[i]!=gameboard[i+4]){
							break;
						}
						else return true;
					}
					i=i+1;
					if(i>=3){
						k=k+1;
					}
			}
			
			return false;
		}
	/**
	 * 
	 * @param gameboard
	 * Draws game board in output console
	 */
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
				else if (y>2){
					System.out.print("\n");
					t--;
					y=0;
				}
			}
		}
}
	

