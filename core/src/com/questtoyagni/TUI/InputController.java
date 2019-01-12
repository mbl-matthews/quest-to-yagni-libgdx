package com.questtoyagni.TUI;

import com.questtoyagni.reader.*;
import com.questtoyagni.Player.*;
import com.questtoyagni.Board.*;
import com.questtoyagni.Event.Event;
import com.questtoyagni.Field.Eventfield;
import com.questtoyagni.coordinates.Coordinate;
import com.questtoyagni.coordinates.Directions;
import com.questtoyagni.Field.Finishfield;

/**
 * text-based interface of the game
 * @author: Timo K, Lukas H
 */
public class InputController {
    private Board board;
    private Player p;

    /**
     * @param x width
     * @param y height
     */
    public InputController(int x, int y) {
        board = new Board(x,y);
        Coordinate start = board.getStartfieldCoordinates();
        p = new Player("Player", start, board);
    }
    /**
     * get an input and moves the Player in that direction, also checks if there is a event on the field
     * @return if game finished or not
     */
    public int eingabe() {
        String eingabe = null;
        //DEBUG
        System.out.println("DEBUG: Player Pos (x: "+p.getCoordinates().getX()+",y: "+p.getCoordinates().getY()+")");
        System.out.println("Where do you want to go?(North,South,West,East):");
        try {
            eingabe = InputReader.readString();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        if (Directions.NORTH.equalsIgnoreCase(eingabe) || Directions.SOUTH.equalsIgnoreCase(eingabe) || Directions.WEST.equalsIgnoreCase(eingabe) || Directions.EAST.equalsIgnoreCase(eingabe)) {
            boolean ausgabe = p.move(eingabe);
            if (!ausgabe) {
                System.out.println("Can't move " + eingabe);
           }
            if(board.getField(p.getPosition()).getType().equals(Finishfield.type)) {
            	Finishfield finish=(Finishfield) board.getField(p.getPosition());
            	Event event=finish.getEvent();
            	String msg=event.triggerEvent(p, board);
            	System.out.println(msg);
            	return 1;
            }
            if(board.getField(p.getPosition()).getType().equals(Eventfield.type)) {
            	Eventfield eventfield=(Eventfield) board.getField(p.getPosition());
            	Event event=eventfield.getEvent();
            	String msg=event.triggerEvent(p, board);
            	System.out.println(msg);
            }
        } else {
            System.out.println("Wrong input");
        }
        return 0;
    }
}
