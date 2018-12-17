/**
 * @author: Timo K
   @author: Lukas H
 */

package Event;

import Board.Board;
import Player.Player;

public class Teleportevent extends Event{

	 /**
     * @param id    ID of Event
     * @param name  Name of Event
     */
	  public Teleportevent(int id,String name){
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
		return teleportEvent(p);
	}
	/**
	 * teleport the player to a set position
	 * @param the player of the game
	 * @return returns teleport-msg as String
	 */
	public String teleportEvent(Player p) {
		p.setPosition(new int [] {0,2});
		return ("You got Teleported");
	}
}
