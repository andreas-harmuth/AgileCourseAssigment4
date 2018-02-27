package test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import assigment4.Checkers;
import assigment4.Piece;
import assigment4.Player;

public class PlayerTest {
	Player p1,p2;
	Checkers game;
	
	@Before
	public void createPlayer() {
		p1 = new Player(1,"Test Person 1");
		p2 = new Player(2,"Test Person 2");
		
		game = new Checkers(p1,p2);
	}
	
	@Test
	public void testChoosePieceNotOnBoard() {
		assertFalse(p1.choosePiece(game, 10, 0));
	}
	
	@Test
	public void testChoosePieceOwnership() {
		assertFalse(p1.choosePiece(game, 5, 0));
	}
	@Test
	public void testChoosePiece() {
		assertTrue(p1.choosePiece(game, 1, 0));
	}
	
	@Test
	public void testGetName() {
		assertEquals("Test Person 1", p1.getName());
	}
	
	@Test
	public void testMovePiece() {
		p1.choosePiece(game, 2, 1);
		assertTrue(p1.movePiece(game, 3, 2));
	}
	
	
	
	@Test
	public void testMovePieceNotDiagonal1() {
		p1.choosePiece(game, 2, 1);
		assertFalse(p1.movePiece(game, 3, 1));
	}
	
	@Test
	public void testMovePieceNotDiagonal2() {
		p1.choosePiece(game, 2, 1);
		assertFalse(p1.movePiece(game, 2, 0));
	}
	
	@Test
	public void testMovePieceNotValidSpace1() {
		// Is checked before diagonal 
		p1.choosePiece(game, 2, 1);
		assertFalse(p1.movePiece(game, 2, 10));
	}
	@Test
	public void testMovePieceNotValidSpace2() {
		// Is checked before diagonal 
		p1.choosePiece(game, 2, 1);
		assertFalse(p1.movePiece(game, 5, 0));
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testMovePieceNoPiece() {
		p1.movePiece(game, 1, 2);
	}

}
