
package com.questtoyagni.field;

import com.questtoyagni.event.Event;
import com.questtoyagni.event.Finishevent;
import com.questtoyagni.field.Field;
/**
 * A field which holds the finish-event
 * @author Levent K
 */

public class Finishfield extends Field{

	public static final String type = "Finishfield";
    private Finishevent event;
    /**
     * @param id ID of Field Object, usually set by Board-Class
     * @param walls Walls-object
     * @param Finishevent 
     */
    public Finishfield(int id, Walls walls, Finishevent eventobject){
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