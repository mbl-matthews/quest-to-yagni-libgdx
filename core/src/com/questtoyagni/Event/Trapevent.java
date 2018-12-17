package com.questtoyagni.Event;

import com.questtoyagni.Board.Board;
import com.questtoyagni.Player.Player;

public class Trapevent extends Event{

    /**
     * @param id    ID of Event
     * @param name  Name of Event
     */
    public Trapevent(int id,String name){
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
    	return null;
    }

    /**
     * Functionality of the Trap Event if a player triggers a Event
     * @return returns trap-msg as String
     */
    String trapEvent(){
    	return null;
    }
}