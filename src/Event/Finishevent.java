package Event;

public class Finishevent extends Event{

    /**
     * @param id    ID of Event
     * @param name  Name of Event
     */
    public Finishevent(int id,String name){
        super(id,name);
    }

    /**
     * Triggers the Event Method
     */
    @Override
    public void triggerEvent() {

    }

    /**
     * Will finish the current Game
     */
    void finishGame(){

    }
}