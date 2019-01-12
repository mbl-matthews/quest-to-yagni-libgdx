
package com.questtoyagni.Board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.questtoyagni.Player.Player;
/**
 * @author: Mathis B
 */

public class JUnitTestBoard {
	Board board = new Board(5,7);
	@Test
	void testBoard() {
		Assertions.assertTrue(board.getField(5).getWalls().isNorth());
		Assertions.assertTrue(board.changePositionAndGetWallsAroundNewPosition(4).isNorth());
		Assertions.assertTrue(board.getWidth()==5,"Falscher X-Wert.");
		Assertions.assertTrue(board.getHeight()==7,"Falscher Y-Wert.");
	}
	
}
