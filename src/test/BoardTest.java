package test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import assigment4.Board;
import assigment4.Piece;
import assigment4.Player;


public class BoardTest {
	
	Board board;
	@Before
	public void CreateGame() {
		Player p1 = new Player(1,"Player 1");
		Player p2 = new Player(2,"Player 2");
			
		board = new Board(p1,p2);
	}
	
	@Test
	public void testSelectPieceNull() {
		assertEquals(null,board.selectPiece(0,10));
		assertEquals(null,board.selectPiece(-1,5));
		assertEquals(null,board.selectPiece(10,5));
		assertEquals(null,board.selectPiece(0,-1));}
	
	@Test
	public void testSelectPiecePos() {
		Piece p = board.selectPiece(1,2);
		assertEquals(1,p.getX());
		assertEquals(2,p.getY());
	}

	@Test
	public void testGetAndSetPiece() {
		
		Piece p = board.selectPiece(1, 6);
		// Show that the piece is being moved
		assertEquals(1,p.getX());
		assertEquals(6,p.getY());
		board.setPiece(2,5,p);
		assertEquals(2,p.getX());
		assertEquals(5,p.getY());
		
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testGetAndSetPieceError() {
		
		Piece p = board.selectPiece(1, 6);
		// Show that the piece is being moved
		assertEquals(1,p.getX());
		assertEquals(6,p.getY());
		board.setPiece(10,5,p);
	}

	// Just for code coverage
	@Test
	public void testPrintBoard() {
		board.printBoard();
	}

}
