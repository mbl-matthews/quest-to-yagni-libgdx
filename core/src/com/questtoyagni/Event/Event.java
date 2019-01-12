
package com.questtoyagni.Event;

import com.questtoyagni.Board.Board;
import com.questtoyagni.Player.Player;
/**
 *  abstract event class, triggers event method
 *  @author: Lukas H.
 */
public abstract class Event{
    private int id;
    private String name;

    /**
     * @param id    ID of Event
     * @param name  Name of Event
     */
    public Event(int id,String name){
        this.id = id;
        this.name = name;
    }

    /**
     * Triggers the Event Method
     * @param p Player
     * @param b Board
     * @return returns event-msg as String
     */
    public abstract String triggerEvent(Player p,Board b);
}