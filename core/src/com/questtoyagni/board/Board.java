
package com.questtoyagni.board;

import java.util.ArrayList;

import com.questtoyagni.coordinates.Coordinate;
import com.questtoyagni.field.*;
import com.questtoyagni.reader.BoardReader;

/**
 *	represents the board using width and height to determinate the size
 *	the board itself is organized in Field-objects
 *	Width/Height can't be bigger than 15.
 *  @author: Mathis B
 */
public class Board {
	private ArrayList<Field> fields = new ArrayList<Field>();
	private int width;
	private int height;
	
	/**
	 * Constructor for Board with the desired Dimensions
	 * @param x Value of the X Dimension of the Board
	 * @param y Value of the Y Dimension of the Board
	 */
	public Board(int x, int y) {
		if(x>15){
			this.width = 15;
		} else {
			this.width = x;
		}
		if (y > 15) {
			this.height = 15;
		} else {
			this.height = y;
		}

		try {
			this.fields = BoardReader.getDefaultBoard();
		} catch(Exception e) {
			System.out.print("Board-Datei konnte nicht gefunden werden!");
		}
	}

	/**
	 * Returns the positon of the Startfield
	 * @return position of Startfield
	 */
	public int getStartfieldPosition() {
		for(int i = 0; i<fields.size();i++) {
			if(fields.get(i).getType().equals(Startfield.type)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Gets the coordinates of the startfield
	 * @return startfield coordinates
	 */
	public Coordinate getStartfieldCoordinates() {
	    int position = this.getStartfieldPosition();
	    return new Coordinate(position % this.width,position / this.width);
    }
	
	/**
	 * @return the position of Finishfield
	 */
	public int getFinishfieldPosition() {
		for(int i = 0; i<fields.size();i++) {
			if(fields.get(i).getType().equals(Finishfield.type)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * @return the coordinates of Finishfield
	 */
	public Coordinate getFinishfieldCoordinates() {
		int position = this.getFinishfieldPosition();
	    return new Coordinate (position % this.width,position / this.width);
		
	}
	
	/**
	 * @param field  field
	 * @return index of the current field
	 */
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
	public Walls changePositionAndGetWallsAroundNewPosition(int pos) {
		return fields.get(pos).getWalls();
	}
	
	/**
	 * Returns the width Dimension of the board
	 * @return width dimension of the board
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Returns the height Dimension of the board
	 * @return height dimension of the board
	 */
	public int getHeight() {
		return height;
	}
}