package com.questtoyagni.event;

import com.questtoyagni.board.Board;
import com.questtoyagni.coordinates.Coordinate;
import com.questtoyagni.coordinates.Directions;
import com.questtoyagni.player.Player;
/**
 * hint-event, prints the direction of the finish-field
 * @author Timo K
 */
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
    	Coordinate coordinatesPlayer=p.getCoordinates();


    	Coordinate coordinatesFinish=b.getFinishfieldCoordinates();


    	Coordinate difference=coordinatesFinish.sub(coordinatesPlayer);
    	String finish = "";
    	if(difference.getX()<0) {
    		finish=Directions.WEST.toString();
    	}
    	else if(difference.getX()>0) {
    		finish=Directions.EAST.toString();
    	}
    	if(difference.getY()<0) {
    		finish+=Directions.NORTH.toString();
    	}
    	else if(difference.getY()>0) {
    		finish+=Directions.SOUTH.toString();
    	}
    	return "The finish is "+ finish + " from your position";
    }
}