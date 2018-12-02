package Field;

/**
 * Abstract class for field objects for game logic
 */
public abstract class Field {
    private int id;
    private String type;
    private boolean WallAbove=false;
    private boolean WallBottom=false;
    private boolean WallLeft=false;
    private boolean WallRight=false;


    /**
     * @param id ID of Field Object, usually set by Board-Class
     * @param wallArray Bool-Array for Walls. [0] -> Above Wall, [1] -> Bottom Wall, [2] -> Left Wall, [3] -> Right Wall
     */
    Field(int id, boolean[] wallArray, String type){
        this.id = id;
        this.setWalls(wallArray);
        this.type=type;
    }


    /**
     * @return ID of FieldObject
     */
    int getFieldId(){
        return this.id;
    }

    /**
     * Method parses a Bool-Array for Walls and set the values to the objects attributes.
     * @param wallArray Bool-Array for Walls. [0] -> Above Wall, [1] -> Bottom Wall, [2] -> Left Wall, [3] -> Right Wall
     */
    private void setWalls(boolean[] wallArray){
        if(wallArray.length == 4){
            this.WallAbove=wallArray[0];
            this.WallBottom=wallArray[1];
            this.WallLeft=wallArray[2];
            this.WallRight=wallArray[3];
        }
    }

    /**
     * @return Bool-Array for Walls. [0] -> Above Wall, [1] -> Bottom Wall, [2] -> Left Wall, [3] -> Right Wall
     */
    public boolean[] getWalls(){
        return new boolean[]{this.WallAbove,this.WallBottom,this.WallLeft,this.WallRight};
    }

    String getType(){
        return this.type;
    }
}
