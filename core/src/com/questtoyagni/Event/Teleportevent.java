/**
 * @author: Timo K
   @author: Lukas H
 */

package com.questtoyagni.Event;

import java.util.Random;

import com.questtoyagni.Board.Board;
import com.questtoyagni.Player.Player;

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
		return teleportEvent(p,b);
	}
	/**
	 * teleport the player to a random position
	 * @param p the player of the game
	 * @param p the board of the game
	 * @return returns teleport-msg as String
	 */
	public String teleportEvent(Player p,Board b) {
		int x=new Random().nextInt(b.getX());
		int y=new Random().nextInt(b.getY());
		
		
    	// checks that the player is not teleportet to the Finishfield		
		int []cordinatesFinish=b.getFinishfieldCoordinates();
    	int xBoard=cordinatesFinish[0];
    	int yBoard=cordinatesFinish[1];
    	
		while(x+y==xBoard+yBoard) {
			x=new Random().nextInt(b.getX());
			y=new Random().nextInt(b.getY());
		}
		
		
		p.setPosition(new int [] {x,y});
		return ("You got Teleported");
	}
}
