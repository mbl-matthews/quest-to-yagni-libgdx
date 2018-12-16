/**
 * @author: Mathis B
 */

package com.questtoyagni.Board;

import java.util.ArrayList;
import com.questtoyagni.Event.*;
import com.questtoyagni.Field.*;
//import GUI.*;
import com.questtoyagni.Player.*;
import com.questtoyagni.TUI.*;
import com.questtoyagni.reader.boardReader;

public class Board {
	
	private ArrayList<Field> fields = new ArrayList<Field>();
	private int x;
	private int y;
	
	/**
	 * Constructor for Board with the desired Dimensions
	 * @param x Value of the X Dimension of the Board
	 * @param y Value of the Y Dimension of the Board
	 */
	public Board(int x, int y) {
		this.x = x;
		this.y = y;
		try {
			this.fields = boardReader.getDefaultBoard();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int getStartfieldPosition() {
		for(int i = 0; i<fields.size();i++) {
			if(fields.get(i).getType().equals("Startfield")) {
				return i;
			}
		}
		return 0-1;
	}

	public int[] getStartfieldCoordinates() {
	    int position = this.getStartfieldPosition();
	    int x = position % 5;
	    int y = position / 5;

	    return new int[] {x,y};
    }
	
	/**
	 * @return the position of Finishfield
	 */
	public int getFinishfieldPosition() {
		for(int i = 0; i<fields.size();i++) {
			if(fields.get(i).getType().equals("Finishfield")) {
				return i;
			}
		}
		return 0-1;
	}
	
	/**
	 * @return the coordinates of Finishfield
	 */
	public int[] getFinishfieldCoordinates() {
		int position = this.getFinishfieldPosition();
	    int x = position % 5;
	    int y = position / 5;
	    return new int[] {x,y};
		
	}
	
	public int getPosFromField(Field field)
    {
        for(int i=0; i<fields.size(); i++){
            if(this.fields.get(i).equals(field)){
                return i;
            }
        }
        return -1; //If field not found
    }
	/**
	 * Returns the field for the given position
	 * @param pos Position of the field
	 * @return Field for the given position
	 */
	public Field getField(int pos) {
		return fields.get(pos);
	}
	
	/**
	 * Changes the position of the player by telling the new field that player just landed on it
	 * @param pos Position of the new field
	 * @return Array with the walls of the new field
	 */
	public boolean[] changePosition(int pos) {
		return fields.get(pos).getWalls();
	}
	
	/**
	 * Returns the x Dimension of the board
	 * @return x dimension of the board
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Returns the y Dimension of the board
	 * @return y dimension of the board
	 */
	public int getY() {
		return y;
	}
}