package Event;

public class Hintevent extends Event{

    /**
     * @param id    ID of Event
     * @param name  Name of Event
     */
    public Hintevent(int id,String name){
        super(id,name);
    }

    /**
     * Triggers the Event Method
     */
    @Override
    public void triggerEvent() {

    }

    /**
     * Creating a hint Event. It will print a hint.
     */
    void hintEvent(){

    }
}