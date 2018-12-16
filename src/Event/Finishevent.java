package Event;

import Board.Board;
import Player.Player;

public class Finishevent extends Event{

    /**
     * @param id    ID of Event
     * @param name  Name of Event
     */
    public Finishevent(int id,String name){
        super(id,name);
    }

    /**
     * Triggers the Event Method
     */
    @Override
    public void triggerEvent(Player p,Board b) {
    	finishGame();
    }

    /**
     * Will finish the current Game
     */
    void finishGame(){
    	System.out.println("Huuray! You've reached Yagni, the mighty East Westphalian God! Now let his wisdom rain down on you...");
    }
}