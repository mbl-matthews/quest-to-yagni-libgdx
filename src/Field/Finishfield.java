package Field;
import Event.Event;
import Event.Finishevent;
import Field.Field;

public class Finishfield extends Field{

    Finishevent event;
    /**
     * @param id ID of Field Object, usually set by Board-Class
     * @param wallArray Bool-Array for walls. [0] -> Above Wall, [1] -> Bottom Wall, [2] -> Left Wall, [3] -> Right Wall
     */
    public Finishfield(int id, boolean[] wallArray, Finishevent eventobject){
        super(id, wallArray, "Finishfield");
        this.event = eventobject;

    }
    public Event getEvent() {
    	return this.event;
    }
}