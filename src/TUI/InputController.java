/**
 * @author: Timo K
   @author: Lukas H
 */

package TUI;

import java.io.*;
import reader.*;
import Player.*;
import Board.*;
import Event.Event;
import Event.Hintevent;
import Event.Teleportevent;
import Field.Eventfield;
import Field.Field;
import Field.Finishfield;

public class InputController {
    private Board board;
    private Player p;

    public InputController(int x, int y) {
        board = new Board(x,y);
        int[] start = board.getStartfieldCoordinates();
        p = new Player("Player", start[0], start[1], board);
    }
    /**
     * get an input and moves the Player in that direction,also checks if there is a event on the field
     * @return if the game is finished or not
     */
    public int eingabe() {
        String eingabe = null;
        int[] cordinates = p.getCoordinates();
        //DEBUG
        System.out.println("DEBUG: Player Pos (x: "+cordinates[0]+",y: "+cordinates[1]+")");
        System.out.print("Where do you want to go?(North,South,West,East):");
        //InputStreamReader isr = new InputStreamReader(System.in);
        //BufferedReader br = new BufferedReader(isr);
        try {
            eingabe = InputReader.readString();
        } catch (Exception e) {
            e.printStackTrace();
        } /*finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        if (eingabe.equalsIgnoreCase("North") || eingabe.equalsIgnoreCase("South") || eingabe.equalsIgnoreCase("West") || eingabe.equalsIgnoreCase("East")) {
            boolean ausgabe = p.move(eingabe);
            if (!ausgabe) {
               System.out.println("Can't move " + eingabe);
            }
            if(board.getField(p.getPosition()).getType().equals("Finishfield")) {
            	Finishfield finish=(Finishfield) board.getField(p.getPosition());
            	Event event=finish.getEvent();
            	String msg=event.triggerEvent(p, board);
            	System.out.println(msg);
                return 1;
            }
            if(board.getField(p.getPosition()).getType().equals("Eventfield")) {
            	Eventfield eventfield=(Eventfield) board.getField(p.getPosition());
            	Event event=eventfield.getEvent();
            	String msg=event.triggerEvent(p, board);
            	System.out.println(msg);
            	/*if(event instanceof Hintevent) {
            		((Hintevent) event).hintEvent(p, board);
            	}
            	if(event instanceof Teleportevent) {
            		((Teleportevent) event).teleportEvent(p);
            	}*/
            }
        } else {
            System.out.println("Wrong input");
        }
        return 0;
    }
}
