package com.questtoyagni.event;

import java.util.Random;

import com.questtoyagni.board.Board;
import com.questtoyagni.coordinates.Coordinate;
import com.questtoyagni.player.Player;
/**
 * teleport-event, teleport the player to a random position on the board
 * @author: Timo K
 * @author: Lukas H
 */

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
		int x=new Random().nextInt(b.getWidth());
		int y=new Random().nextInt(b.getHeight());
		Coordinate randomPositon=new Coordinate(x,y);
    	// checks that the player is not teleportet to the Finishfield		
		Coordinate coordinatesFinish=b.getFinishfieldCoordinates();
    	
		while(randomPositon.equals(coordinatesFinish)) {
			x=new Random().nextInt(b.getWidth());
			y=new Random().nextInt(b.getHeight());
			randomPositon=new Coordinate(x,y);
		}
		
		
		p.setPosition(new Coordinate(x,y));
		return ("You got Teleported");
	}
}
