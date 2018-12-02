/**
 * @author: Lukas H
 */

package Player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Board.Board;

public class JunitTestPlayer {

	Board board = new Board(5,7);
	@Test
	void testRichtung() {
		Player p = new Player("Player1",1,1,board );
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
		Player p = new Player("Player1",1,1,board );
		Assertions.assertEquals("Player1", p.getName(),"Der Name ist nicht richtig");
	}
	
	@Test
	void testWalls() {
		Player p = new Player("Player1",1,1,board );
		Assertions.assertArrayEquals(new boolean[]{true,false,false,false}, p.walls, "Die Wände werden nicht übergen");
	}


}
