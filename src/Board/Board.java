/**
 * @author: Mathis B
 */

package Board;

import java.util.ArrayList;
import Event.*;
import Field.*;
//import GUI.*;
import Player.*;
import TUI.*;
import reader.boardReader;

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