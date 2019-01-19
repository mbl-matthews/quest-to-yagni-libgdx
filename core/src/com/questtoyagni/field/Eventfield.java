package com.questtoyagni.field;

import com.questtoyagni.event.Event;
import com.questtoyagni.field.Field;

/**
 * A field which holds an event
 * @author Levent K
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