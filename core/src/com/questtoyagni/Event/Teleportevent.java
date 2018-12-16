/**
 * @author: Timo K
 */

package com.questtoyagni.Event;

import com.questtoyagni.Board.Board;
import com.questtoyagni.Player.Player;

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
