/**
 * @author: Levent K
 */

package com.questtoyagni.Field;

import com.questtoyagni.Field.Field;

public class Startfield extends Field{

	public static final String type = "Startfield";
    /**
     * @param id ID of Field Object, usually set by Board-Class
     * @param walls the Walls north,south,west,east
     */
    public Startfield(int id, Walls walls){
        super(id, walls, type);

    }
    
}