/**
 * @author: Lukas H
 */

package Event;

import Board.Board;
import Field.Field;
import Player.Player;

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
	*/  
	@Override
	public String triggerEvent(Player p,Board b) {
		return wallEvent(p,b);
	}
	/**
	 * tells walls at players position
	 * @param b board
	 * @param p the player of the game
	 */
	public String wallEvent(Player p, Board b) {
		String output = "walls in following directions:";
		Field field=b.getField(p.getPosition());
		boolean[] walls=field.getWalls();
		if(walls[0]) output+=" north";
		if(walls[1]) output+=" south";
		if(walls[2]) output+=" west";
		if(walls[3]) output+=" east";
		return output;
	}
}
