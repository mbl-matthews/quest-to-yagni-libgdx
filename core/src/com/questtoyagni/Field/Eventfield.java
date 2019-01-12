/**
 * @author: Levent K
 */

package com.questtoyagni.Field;

import com.questtoyagni.Board.Board;
import com.questtoyagni.Event.Event;
import com.questtoyagni.Event.Hintevent;
import com.questtoyagni.Field.Field;
import com.questtoyagni.Player.Player;

public class Eventfield extends Field{

	public static final String type = "Eventfield";
    Event event;

    /**
     * @param id ID of Field Object, usually set by Board-Class
     * @param walls the Walls north,south,west,east
     * @param Event
     */
    public Eventfield(int id, Walls walls, Event eventobject){
        super(id, walls, type);
        this.event = eventobject;
    }
    
    /**
     * 
     * @return returns event
     */
    public Event getEvent() {
    	return this.event;
    }
    
}