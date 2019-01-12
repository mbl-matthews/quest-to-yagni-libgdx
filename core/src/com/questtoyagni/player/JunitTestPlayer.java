
package com.questtoyagni.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.questtoyagni.board.Board;
import com.questtoyagni.coordinates.Coordinate;
import com.questtoyagni.field.Walls;
/**
 * @author: Lukas H
 */

public class JunitTestPlayer {

	Board board = new Board(5,7);
	@Test
	void testRichtung() {
		Player p = new Player("Player1",new Coordinate(1,1),board );
		Assertions.assertEquals(true, p.move("north"),"Die Richtung ist blockiert");
		Assertions.assertEquals(false, p.move("south"),"Die Richtung ist blockiert");
		Assertions.assertEquals(true, p.move("west"),"Die Richtung ist blockiert");
		Assertions.assertEquals(true, p.move("east"),"Die Richtung ist blockiert");
	}
	
	@Test
	void testBoard() {
		Assertions.assertNotNull(board,"Das Board wurde nicht gefunden");
	}
	
	@Test
	void testName() {
		Player p = new Player("Player1",new Coordinate(1,1),board );
		Assertions.assertEquals("Player1", p.getName(),"Der Name ist nicht richtig");
	}
	
	@Test
	void testWalls() {
		Player p = new Player("Player1",new Coordinate(1,1),board );
		Assertions.assertEquals(new Walls(true,false,false,false), p.getWalls(), "Die Wände werden nicht übergen");
	}
	
	@Test
	void testPosition() {
		Player p = new Player("Player1",new Coordinate(1,1),board );
		Assertions.assertEquals(6, p.getPosition(), "Die Position wird nicht übergen");
	}
	
	@Test
	void testCoordinates() {
		Player p = new Player("Player1",new Coordinate(1,1),board );
		Assertions.assertEquals(new Coordinate(1,1),p.getCoordinates(), "Die Koardinaten sind falsch");
	}


}
