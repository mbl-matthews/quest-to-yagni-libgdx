/**
 * @author: Timo K
 */

package Event;

import Player.Player;

public class Teleportevent extends Event{

	  public Teleportevent(int id,String name){
	        super(id,name);
	    }
	  
	@Override
	public void triggerEvent() {
		// TODO Auto-generated method stub
		
	}
	   /**
     * Creating a teleport Event. It will teleport the Player.
     */
	public void teleportEvent(Player p) {
		p.setPosition(new int [] {0,2});
		System.out.println("You got Teleported");
	}
}
