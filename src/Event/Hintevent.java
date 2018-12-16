/**
 * @author: Timo K
 */

package Event;

import Board.Board;
import Player.Player;

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
     */
    @Override
    public void triggerEvent(Player p,Board b) {
    	hintEvent(p, b);
    }

    /**
     * prints a hint on witch position the finish is
     * @param p the player of the game
     * @param b the board on witch he plays
     */
    public void hintEvent(Player p,Board b){
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
    		finish=" West";
    	}
    	else if(x>0) {
    		finish=" East";
    	}
    	if(y<0) {
    		finish+=" North";
    	}
    	else if(y>0) {
    		finish+=" South";
    	}
    	System.out.println("The finish is"+ finish + " from your position");
    }
}