package Event;

public class Trapevent extends Event{

    /**
     * @param id    ID of Event
     * @param name  Name of Event
     */
    public Trapevent(int id,String name){
        super(id,name);
    }

    /**
     * Triggers the Event Method
     */
    @Override
    public void triggerEvent() {

    }

    /**
     * Functionality of the Trap Event if a player triggers a Event
     */
    void trapEvent(){

    }
}