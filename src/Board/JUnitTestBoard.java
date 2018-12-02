package Board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Player.Player;

public class JUnitTestBoard {
	Board board = new Board(5,7);
	@Test
	void testBoard() {
		Assertions.assertEquals(true, board.changePosition(5).length == 4,"Vier Wände sind vorhanden");
		Assertions.assertEquals(false, board.getField(5),"Die Richtung ist blockiert");
		Assertions.assertArrayEquals(new boolean[] {true, true, true, false}, board.getField(5).getWalls());
	}
}
