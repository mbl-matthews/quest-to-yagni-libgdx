package Field;
        import Field.Field;

public class Startfield extends Field{

    /**
     * @param id ID of Field Object, usually set by Board-Class
     * @param wallArray Bool-Array for walls. [0] -> Above Wall, [1] -> Bottom Wall, [2] -> Left Wall, [3] -> Right Wall
     */
    public Startfield(int id, boolean[] wallArray){
        super(id, wallArray, "Startfield");

    }
}