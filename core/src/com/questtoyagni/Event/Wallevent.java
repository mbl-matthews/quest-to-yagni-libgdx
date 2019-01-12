/**
 * @author: Lukas H
 */

package com.questtoyagni.Event;

import com.questtoyagni.Board.Board;
import com.questtoyagni.Field.Field;
import com.questtoyagni.Field.Walls;
import com.questtoyagni.Player.Player;
import com.questtoyagni.coordinates.Directions;

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
		Walls walls=field.getWalls();
		if(walls.isNorth()) output+=Directions.NORTH.toString();
		if(walls.isSouth()) output+=Directions.SOUTH.toString();
		if(walls.isWest()) output+=Directions.WEST.toString();
		if(walls.isEast()) output+=Directions.EAST.toString();
		return output;
	}
}
