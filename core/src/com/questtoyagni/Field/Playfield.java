package com.questtoyagni.Field;

import com.questtoyagni.Field.Field;
/**
 * A "normal" playing-field without any events
 * @author: Levent K
 */

public class Playfield extends Field{

	public static final String type = "Playfield";
    /**
     * @param id ID of Field Object, usually set by Board-Class
     * @param walls Walls-object
     */
    public Playfield(int id, Walls walls){
        super(id, walls, type);

    }
    
}