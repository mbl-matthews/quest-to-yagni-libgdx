package Board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Player.Player;

public class JUnitTestBoard {
	Board board = new Board(5,7);
	@Test
	void testBoard() {
		Assertions.assertEquals(true, board.changePosition(5).length == 4,"Vier Wände sind vorhanden");
		Assertions.assertArrayEquals(new boolean[] {true, false, true, true}, board.getField(5).getWalls());
		Assertions.assertArrayEquals(new boolean[] {true, false, false, true}, board.changePosition(4));
		Assertions.assertEquals(true,board.getX()==5,"Falscher X-Wert.");
		Assertions.assertEquals(true,board.getY()==7,"Falscher Y-Wert.");
	}
	
}
