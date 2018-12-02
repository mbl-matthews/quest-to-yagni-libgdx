package Field;
import Field.Field;

public class Eventfield extends Field{

    /**
     * @param id ID of Field Object, usually set by Board-Class
     * @param wallArray Bool-Array for Walls. [0] -> Above Wall, [1] -> Bottom Wall, [2] -> Left Wall, [3] -> Right Wall
     */
    public Eventfield(int id, boolean[] wallArray){
        super(id, wallArray, "Eventfield");
    }
    //Event fieldevent;  //Event will be implemented soon.
}