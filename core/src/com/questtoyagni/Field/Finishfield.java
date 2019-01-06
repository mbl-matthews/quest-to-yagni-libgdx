/**
 * @author: Levent K
 */

package com.questtoyagni.Field;

import com.questtoyagni.Event.Event;
import com.questtoyagni.Event.Finishevent;
import com.questtoyagni.Field.Field;

public class Finishfield extends Field{

	public static final String type = "Finishfield";
     Finishevent event;
    /**
     * @param id ID of Field Object, usually set by Board-Class
     * @param wallArray Bool-Array for walls. [0] -> Above Wall, [1] -> Bottom Wall, [2] -> Left Wall, [3] -> Right Wall
     */
    public Finishfield(int id, boolean[] wallArray, Finishevent eventobject){
        super(id, wallArray, type);
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