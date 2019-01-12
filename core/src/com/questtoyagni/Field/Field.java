/**
 * @author: Levent K
 */

package com.questtoyagni.Field;

/**
 * Abstract class for field objects for game logic
 */
public abstract class Field {
    private int id;
    private String type;
    //private boolean WallAbove=false;
    //private boolean WallBottom=false;
    //private boolean WallLeft=false;
    //private boolean WallRight=false;
    private Walls walls;

    /**
     * @param id ID of Field Object, usually set by Board-Class
     * @param walls the Walls north,south,west,east
     * @param type The type of the field
     */
    public Field(int id, Walls walls, String type){
        this.id = id;
        this.walls=walls;
        this.type=type;
    }


    /**
     * @return ID of FieldObject
     */
    int getFieldId(){
        return this.id;
    }

    /**
     * 
     */
    private void setWalls(Walls walls){
    	this.walls=walls;
    }

    /**
     * @return Bool-Array for walls. [0] -> Above Wall, [1] -> Bottom Wall, [2] -> Left Wall, [3] -> Right Wall
     */
    public Walls getWalls(){
        return this.walls;
    }

    /**
     * 
     * @return returns type of field
     */
    public String getType(){
        return this.type;
    }
}
