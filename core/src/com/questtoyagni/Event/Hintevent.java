/**
 * @author: Timo K
 */

package com.questtoyagni.Event;

import com.questtoyagni.Board.Board;
import com.questtoyagni.Player.Player;
import com.questtoyagni.coordinates.Directions;

public class Hintevent extends Event{

    /**
     * @param id    ID of Event
     * @param name  Name of Event
     */
    public Hintevent(int id,String name){
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
    	return hintEvent(p, b);
    }

    /**
     * prints a hint on witch position the finish is
     * @param p the player of the game
     * @param b the board on witch he plays
     * @return returns hint-msg as String
     */
    public String hintEvent(Player p,Board b){
    	int []cordinatesPlayer=p.getCoordinates();
    	int xPlayer=cordinatesPlayer[0];
    	int yPlayer=cordinatesPlayer[1];

    	int []cordinatesFinish=b.getFinishfieldCoordinates();
    	int xBoard=cordinatesFinish[0];
    	int yBoard=cordinatesFinish[1];

    	int x=xBoard-xPlayer;
    	int y=yBoard-yPlayer;
    	String finish = "";
    	if(x<0) {
    		finish=Directions.WEST.toString();
    	}
    	else if(x>0) {
    		finish=Directions.EAST.toString();
    	}
    	if(y<0) {
    		finish+=Directions.NORTH.toString();
    	}
    	else if(y>0) {
    		finish+=Directions.SOUTH.toString();
    	}
    	return "The finish is "+ finish + " from your position";
    }
}