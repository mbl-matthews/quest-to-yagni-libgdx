package Event;

public abstract class Event{
    private int id;
    private String name;

    /**
     * @param id    ID of Event
     * @param name  Name of Event
     */
    public Event(int id,String name){
        this.id = id;
        this.name = name;
    }

    /**
     * Triggers the Event Method
     */
    public abstract void triggerEvent();
}