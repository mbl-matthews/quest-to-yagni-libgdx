package Player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Board.Board;

public class JunitTestPlayer {

	Board board = new Board();
	@Test
	void testMove() {
		Player p = new Player("Player1",1,1,board );
		Assertions.assertEquals(true, p.move("north"),"Die Richtung ist blockiert");
		Assertions.assertEquals(false, p.move("west"),"Die Richtung ist blockiert");
	}

}
