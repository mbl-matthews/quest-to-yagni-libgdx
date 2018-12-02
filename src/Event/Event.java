package Event;

public abstract class Event{
    private int id;
    private String name;

    public Event(int id,String name){
        this.id = id;
        this.name = name;
    }

    public abstract void triggerEvent();
}