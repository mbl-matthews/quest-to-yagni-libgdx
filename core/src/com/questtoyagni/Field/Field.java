package com.questtoyagni.Field;

/**
 * Abstract class for field objects used by game logic
 * @author: Levent K
 */
public abstract class Field {
    private int id;
    private String type;
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
   * @return walls
   */
    public Walls getWalls(){
        return this.walls;
    }

    /**
     * @return returns type of field
     */
    public String getType(){
        return this.type;
    }
}
