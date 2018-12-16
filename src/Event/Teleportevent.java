/**
 * @author: Timo K
 */

package Event;

import Board.Board;
import Player.Player;

public class Teleportevent extends Event{

	  public Teleportevent(int id,String name){
	        super(id,name);
	    }
	  
	@Override
	public void triggerEvent(Player p,Board b) {
		// TODO Auto-generated method stub
		teleportEvent(p);
	}
	/**
	 * teleport the player to a set position
	 * @param the player of the game
	 */
	public void teleportEvent(Player p) {
		p.setPosition(new int [] {0,2});
		System.out.println("You got Teleported");
	}
}
