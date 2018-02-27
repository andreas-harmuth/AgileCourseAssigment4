package assigment4;

import java.util.NoSuchElementException;

public class Player {
	protected int playerID;
	private String name; 
	private Piece chosenPiece;
	public Player(int playerID, String name) {
		this.playerID = playerID;
		this.setName(name);		
		chosenPiece = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// Chooses a piece and returns boolean if choice is valid or not
	public boolean choosePiece(Checkers game, int x, int y) {
		Piece p = game.getBoard().selectPiece(x,y);
		if(p != null ) {
			// If this player "owns" the piece
			if(p.getPlayer() == this) {
				// Set chosen piece
				this.chosenPiece = p;
				return true;
			}
			// Err msg
			else {
				System.out.println("That is not your piece!");
			}
		}
		else {
			System.out.println("That is not a valid piece!");
		}
		this.chosenPiece = null;
		return false;
		
	}
	
	public boolean movePiece(Checkers game, int x, int y) {
		Piece newP = game.getBoard().selectPiece(x,y);
		Piece p = this.chosenPiece;
		
		// Error (This will not happen, but the method is public so..)
		if (p==null) throw new NoSuchElementException("No valid piece chosen to move!");
		
		// If the piece position is empty
		if(newP != null) {
			if(newP.getPlayer()==null) {
				// If the piece move diagonal
				if(Math.abs(p.getX()-x)==1 && Math.abs(p.getY()-y)==1) {
						// TODO: Check if this does not reset p, as it takes a new place on the board
						game.getBoard().setPiece(p.getX(), p.getY(), newP);
						game.getBoard().setPiece(x, y, p);
						return true;
					}
				else {
					System.out.println("Illigal move");
				}
				}
			else {
				System.out.println("That position is not free!");
			}
		}
		
		return false;
	}
}
