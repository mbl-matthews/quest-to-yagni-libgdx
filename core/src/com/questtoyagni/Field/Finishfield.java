/**
 * @author: Levent K
 */

package com.questtoyagni.Field;

import com.questtoyagni.Event.Event;
import com.questtoyagni.Event.Finishevent;
import com.questtoyagni.Field.Field;

public class Finishfield extends Field{

	public static final String type = "Finishfield";
    private Finishevent event;
    /**
     * @param id ID of Field Object, usually set by Board-Class
     * @param walls the Walls north,south,west,east
     * @param Finishevent 
     */
    public Finishfield(int id, Walls walls, Finishevent eventobject){
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