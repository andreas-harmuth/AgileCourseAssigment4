package assigment4;


import java.util.Scanner;

public class Checkers {
	// Input
	private Scanner userInput;
	
	
	
	private Player p1,p2,playerTurn;
	
	private Board board;
	
	public Checkers(Player p1, Player p2) {
		this.setBoard(new Board(p1,p2));
		this.p1 = p1;
		this.p2 = p2;
		this.playerTurn = p1;
		this.userInput = new Scanner(System.in);
	}
	
	public Player getPlayerTurn(){
		return this.playerTurn;
	}
	// Toggle the player
	public void togglePlayer(){
		this.playerTurn = this.playerTurn==this.p1?this.p2:this.p1;
	}
	
	public void move() {
		int status = 0;
		int coordInput;
		int x = 0;
		this.getBoard().printBoard();
		System.out.println(this.playerTurn.getName()+"'s turn");
		
		// If the status is 4 (or above), then the user is done
		while(status<4) {
			// Usr msg
			if(status==0) System.out.print("Select piece at row: ");
			
			// If there is an input
			if(this.userInput.hasNextLine()) {
				try {
					// Try to read an integer
					coordInput = this.userInput.nextInt();
					
					// Do appropriate to the current status
					switch(status) {
					case 0:
						x = coordInput;
						status++;
						System.out.print("Select piece at column:");
						break;
					case 1:
						if(this.playerTurn.choosePiece(this, x, coordInput)) {
							status++;
							System.out.print("Move piece to row: ");
						}
						else {
							// Redo
							status = 0;
						}
						break;
					case 2:
						x = coordInput;
						status++;
						System.out.print("Move piece to column: ");
						break;
					case 3:
						
						if(this.playerTurn.movePiece(this, x, coordInput)) {
							status++;
						}
						else {
							// Redo
							status = 0;
						}
						break;
				}
				}
				// Catch ALL exceptions - but we are mainly looking for when the user is not putting in an integer
				catch (Exception e) {
					System.out.println("Select again");
					this.userInput.nextLine(); // Clear input
					status = 0;
	            }
			}
		}
	}
	
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	public static void main(String[] args) {
		Player p1 = new Player(1,"Player 1");
		Player p2 = new Player(2,"Player 2");
			
		Checkers game = new Checkers(p1,p2);
		System.out.println("Starting game");
		while(true) {
			game.move();
			game.togglePlayer();
		}
	}
		
	
}
