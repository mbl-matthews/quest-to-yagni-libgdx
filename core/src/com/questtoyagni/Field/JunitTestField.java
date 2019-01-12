
package com.questtoyagni.Field;

import com.questtoyagni.Event.Event;
import com.questtoyagni.Event.Finishevent;
import com.questtoyagni.Event.Trapevent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 * @author: Levent K
 */

class JunitTestField {

    @Test
    void testingFinishfield() {
        Walls walls = new Walls (true,false,false,true);
        Finishevent fieldevent = new Finishevent(1,"Test");
        Field myfield = new Finishfield(255,walls, fieldevent);

        Assertions.assertEquals(255, myfield.getFieldId(),"Objekt hat eine falsche ID");
        Assertions.assertEquals(walls, myfield.getWalls(),"Die Wände die gesetzt wurden, stimmen nicht mit den Wänden des Feldes überein.");
        Assertions.assertEquals("Finishfield", myfield.getType(),"Feld hat ein falsches Feld-Typ");
    }

    @Test
    void testingEventfield() {
        Walls walls = new Walls(true,false,false,true);
        Event fieldevent = new Trapevent(1,"Test");
        Field myfield = new Eventfield(255,walls,fieldevent);

        Assertions.assertEquals(255, myfield.getFieldId(),"Objekt hat eine falsche ID");
        Assertions.assertEquals(walls, myfield.getWalls(),"Die Wände die gesetzt wurden, stimmen nicht mit den Wänden des Feldes überein.");
        Assertions.assertEquals("Eventfield", myfield.getType(),"Feld hat ein falsches Feld-Typ");
    }

    @Test
    void testingStartfield() {
        Walls walls = new Walls(true,false,false,true);
        Field myfield = new Startfield(255,walls);

        Assertions.assertEquals(255, myfield.getFieldId(),"Objekt hat eine falsche ID");
        Assertions.assertEquals(walls, myfield.getWalls(),"Die Wände die gesetzt wurden, stimmen nicht mit den Wänden des Feldes überein.");
        Assertions.assertEquals("Startfield", myfield.getType(),"Feld hat ein falsches Feld-Typ");
    }

    @Test
    void testingPlayfield() {
        Walls walls = new Walls(true,false,false,true);
        Field myfield = new Playfield(255,walls);

        Assertions.assertEquals(255, myfield.getFieldId(),"Objekt hat eine falsche ID");
        Assertions.assertEquals(walls, myfield.getWalls(),"Die Wände die gesetzt wurden, stimmen nicht mit den Wänden des Feldes überein.");
        Assertions.assertEquals("Playfield", myfield.getType(),"Feld hat ein falsches Feld-Typ");
    }
}