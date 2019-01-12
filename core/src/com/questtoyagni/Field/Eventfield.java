package com.questtoyagni.Field;

import com.questtoyagni.Event.Event;
import com.questtoyagni.Field.Field;

/**
 * A field which holds an event
 * @author: Levent K
 */

public class Eventfield extends Field{

	public static final String type = "Eventfield";
    Event event;

    /**
     * @param id ID of Field Object, usually set by Board-Class
     * @param walls walls-objected
     * @param Event
     */
    public Eventfield(int id, Walls walls, Event eventobject){
        super(id, walls, type);
        this.event = eventobject;
    }
    
    /**
     * @return returns event
     */
    public Event getEvent() {
    	return this.event;
    }
    
}