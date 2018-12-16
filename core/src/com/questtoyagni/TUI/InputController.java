/**
 * @author: Timo K
 */

package com.questtoyagni.TUI;

import java.io.*;
import com.questtoyagni.reader.*;
import com.questtoyagni.Player.*;
import com.questtoyagni.Board.*;
import com.questtoyagni.Event.Event;
import com.questtoyagni.Event.Hintevent;
import com.questtoyagni.Event.Teleportevent;
import com.questtoyagni.Field.Eventfield;
import com.questtoyagni.Field.Field;
import com.questtoyagni.Field.Finishfield;

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
        System.out.println("Where do you want to go?(North,South,West,East):");
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
            	event.triggerEvent(p, board);
            	//System.out.println("Huuray! You've reached Yagni, the mighty East Westphalian God! Now let his wisdom rain down on you...");
                return 1;
            }
            if(board.getField(p.getPosition()).getType().equals("Eventfield")) {
            	Eventfield eventfield=(Eventfield) board.getField(p.getPosition());
            	Event event=eventfield.getEvent();
            	event.triggerEvent(p, board);
            	/*if(event instanceof Hintevent) {
            		((Hintevent) event).hintEvent(p, board);
            	}
            	if(event instanceof Teleportevent) {
            		((Teleportevent) eve*nt).teleportEvent(p);
            	}*/
            }
        } else {
            System.out.println("Wrong input");
        }
        return 0;
    }
}
