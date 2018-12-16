package com.questtoyagni.Field;

import com.questtoyagni.Board.Board;
import com.questtoyagni.Event.Event;
import com.questtoyagni.Event.Hintevent;
import com.questtoyagni.Field.Field;
import com.questtoyagni.Player.Player;

public class Eventfield extends Field{

    Event event;

    /**
     * @param id ID of Field Object, usually set by Board-Class
     * @param wallArray Bool-Array for walls. [0] -> Above Wall, [1] -> Bottom Wall, [2] -> Left Wall, [3] -> Right Wall
     */
    public Eventfield(int id, boolean[] wallArray, Event eventobject){
        super(id, wallArray, "Eventfield");
        this.event = eventobject;
    }
    public Event getEvent() {
    	return this.event;
    }
}