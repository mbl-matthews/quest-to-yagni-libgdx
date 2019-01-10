/**
 * @author: Lukas H
 */

package com.questtoyagni.Event;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.questtoyagni.Board.Board;
import com.questtoyagni.Player.Player;
import com.questtoyagni.coordinates.Coordinate;
import com.questtoyagni.Field.Eventfield;
import com.questtoyagni.Field.Finishfield;
class JunitEvent {
	
	@Test
	void testHint() {
		Board board = new Board(5,7);
		Player p = new Player("Player1",new Coordinate(0,3),board);
		Eventfield eventfield=(Eventfield) board.getField(p.getPosition());
    	Event event=eventfield.getEvent();
		Assertions.assertEquals("The finish is North from your position", event.triggerEvent(p, board),"Spieler ist an falscher Position");
	}
	
	@Test
	void testFinish() {
		Board board = new Board(5,7);
		Player p = new Player("Player1",new Coordinate(0,1),board);
		Finishfield finish=(Finishfield) board.getField(p.getPosition());
    	Event event=finish.getEvent();
		Assertions.assertEquals("Huuray! You've reached Yagni, the mighty East Westphalian God! Now let his wisdom rain down on you...", event.triggerEvent(p, board),"Spieler ist an falscher Position");
	}
	
	@Test
	void testWall() {
		Board board = new Board(5,7);
		Player p = new Player("Player1",new Coordinate(0,1),board);
		Eventfield eventfield=(Eventfield) board.getField(p.getPosition());
    	Event event=eventfield.getEvent();
		Assertions.assertEquals("walls in following directions: west east", event.triggerEvent(p, board),"Wände werden nicht korrekt gelesen");
	}
	

}
