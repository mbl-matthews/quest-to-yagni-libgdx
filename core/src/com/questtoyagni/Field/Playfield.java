/**
 * @author: Levent K
 */

package com.questtoyagni.Field;

import com.questtoyagni.Field.Field;

public class Playfield extends Field{

	public static final String type = "Playfield";
    /**
     * @param id ID of Field Object, usually set by Board-Class
     * @param wallArray Bool-Array for walls. [0] -> Above Wall, [1] -> Bottom Wall, [2] -> Left Wall, [3] -> Right Wall
     */
    public Playfield(int id, boolean[] wallArray){
        super(id, wallArray, type);

    }
    
}