package assigment4;

import java.util.NoSuchElementException;

public class Board {
	private Piece[][] board;
	public Board(Player p1, Player p2) {	
		// Init board
		 this.board = new Piece[][] {
		        {new Piece(0,0),new Piece(p1,0,1),new Piece(0,2),new Piece(p1,0,3),new Piece(0,4),new Piece(p1,0,5),new Piece(0,6),new Piece(p1,0,7)},
		        {new Piece(p1,1,0),new Piece(1,1),new Piece(p1,1,2),new Piece(1,3),new Piece(p1,1,4),new Piece(1,5),new Piece(p1,1,6),new Piece(1,7)},
		        {new Piece(2,0),new Piece(p1,2,1),new Piece(2,2),new Piece(p1,2,3),new Piece(2,4),new Piece(p1,2,5),new Piece(2,6),new Piece(p1,2,7)},
		        {new Piece(3,0),new Piece(3,1),new Piece(3,2),new Piece(3,3),new Piece(3,4),new Piece(3,5),new Piece(3,6),new Piece(3,7)},
		        {new Piece(4,0),new Piece(4,1),new Piece(4,2),new Piece(4,3),new Piece(4,4),new Piece(4,5),new Piece(4,6),new Piece(4,7)},
		        {new Piece(p2,5,0),new Piece(5,1),new Piece(p2,5,2),new Piece(5,3),new Piece(p2,5,4),new Piece(5,5),new Piece(p2,5,6),new Piece(5,7)},
		        {new Piece(6,0),new Piece(p2,6,1),new Piece(6,2),new Piece(p2,6,3),new Piece(6,4),new Piece(p2,6,5),new Piece(6,6),new Piece(p2,6,7)},
		        {new Piece(p2,7,0),new Piece(7,1),new Piece(p2,7,2),new Piece(7,3),new Piece(p2,7,4),new Piece(7,5),new Piece(p2,7,6),new Piece(7,7)}
		        };
	}
	
	// Get a piece from the board
	public Piece selectPiece(int x, int y) {
		if((x>=0 && x <8) && (y>=0 && y <8)){
			return this.board[x][y];
		}
		else {
			System.out.println("x and y must be between the values 0 and 7!");
			return null;
		}
		
	}
	// Set piece
	public void setPiece(int x, int y, Piece p) {
		// Throw an error if the position is out of bounds/not on the board
		if (this.selectPiece(x,y)==null) throw new NoSuchElementException("x and/or y not on board");
		// Set new position
		p.setX(x);
		p.setY(y);
		this.board[x][y] = p;
	}
	
	public void printBoard() {
		System.out.println("\n\n" );
		System.out.print(" +");
        for(int i = 0; i<this.board.length;i++){
            System.out.print(" " + i);
        }
        System.out.print("+\n");
		for(int row = 0; row<this.board.length;row++){
            System.out.print(row+"|");
            for(int col = 0; col<this.board[row].length;col++){
            	Player p = this.board[row][col].getPlayer();
            	if(p!=null) {
            		System.out.print(" "+p.playerID);
            	}
            	else {
            		System.out.print("  ");
            	}
                
            }
            System.out.print("|\n");

        }
		System.out.print(" +");
		for(int i = 0; i<this.board.length*2;i++){
            System.out.print("-");
        }
        System.out.print("+\n");
	}
	
		
		
}
