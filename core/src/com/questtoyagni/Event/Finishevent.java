/**
 * @author: Lukas H.
 */

package com.questtoyagni.Event;

import com.questtoyagni.Board.Board;
import com.questtoyagni.Player.Player;

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
     * @param p Player
     * @param b Board
     * @return returns event-msg as String
     */
    @Override
    public String triggerEvent(Player p,Board b) {
    	finishGame();
    }

    /**
     *  Will finish the current Game
     * @return returns finish-msg as String
     */
    String finishGame(){
    	return "Huuray! You've reached Yagni, the mighty East Westphalian God! Now let his wisdom rain down on you...";
    }
}