
public class tictactoe {

	private static final char g = 0;
	private static final char _ = 0;

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
			System.out.print(gameboard[i]+" ");
			}
		//char seven, eight, nine = ;
		boolean game = true;
		boolean drawgrid = true;
		
		while (game=true);
			while (drawgrid = true); {}
				for (int x=0; x<3; x++); {
					System.out.println("");
				};
	}
}

	

