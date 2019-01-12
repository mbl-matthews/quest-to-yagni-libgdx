
package com.questtoyagni.event;

import com.questtoyagni.board.Board;
import com.questtoyagni.player.Player;
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