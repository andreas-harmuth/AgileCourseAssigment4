package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assigment4.Checkers;
import assigment4.Player;

public class CheckersTest {
	Player p1,p2;
	Checkers game;
	
	@Before
	public void createGame() {
		p1 = new Player(1,"Test Person 1");
		p2 = new Player(2,"Test Person 2");
		
		game = new Checkers(p1,p2);
	}
	@Test
	public void testMove() {
		//To get most code coverage hit the keys (followed by enter):
		// f
		// 1
		// 1
		// 2
		// 1
		// 2
		// 2
		// 2
		// 1
		// 2
		// 3
		// 2
		// 1
		// 3
		// 2
		
		// Uncomment to try
		//game.move();
	}

	
	@Test
	public void testMain() {
		// Uncomment for code coverage
		//game.main(null);
	}
	
	@Test
	public void togglePlayer() {
		assertEquals(p1,game.getPlayerTurn());
		game.togglePlayer();
		assertEquals(p2,game.getPlayerTurn());
		game.togglePlayer();
		assertEquals(p1,game.getPlayerTurn());
	}
}
