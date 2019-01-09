/**
 * @author: Lukas H
 */

package com.questtoyagni.Event;

import com.questtoyagni.Board.Board;
import com.questtoyagni.Field.Field;
import com.questtoyagni.Player.Player;

public class Wallevent extends Event{
	 /**
     * @param id    ID of Event
     * @param name  Name of Event
     */
	  public Wallevent(int id,String name){
	        super(id,name);
	    }
	  
	  /**
	     * Triggers the Event Method
	     * @param p Player
	     * @param b Board
	     * @return returns event-msg as String
	     */
	@Override
	public String triggerEvent(Player p,Board b) {
		return wallEvent(p,b);
	}
	/**
	 * tells walls at players position
	 * @param b board
	 * @param p the player of the game
	 * @return returns wall-msg as String
	 */
	public String wallEvent(Player p, Board b) {
		String output = "walls in following directions: ";
		Field field=b.getField(p.getPosition());
		boolean[] walls=field.getWalls();
		if(walls[0]) output+=Directions.NORTH.toString();
		if(walls[1]) output+=Directions.SOUTH.toString();
		if(walls[2]) output+=Directions.WEST.toString();
		if(walls[3]) output+=Directions.EAST.toString();
		return output;
	}
}
