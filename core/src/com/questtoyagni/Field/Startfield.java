package com.questtoyagni.Field;

import com.questtoyagni.Field.Field;
/**
 * A field which is the starting position for the player
 * @author: Levent K
 */

public class Startfield extends Field{

	public static final String type = "Startfield";
    /**
     * @param id ID of Field Object, usually set by Board-Class
     * @param walls Walls-object
     */
    public Startfield(int id, Walls walls){
        super(id, walls, type);

    }
    
}