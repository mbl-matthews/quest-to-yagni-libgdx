/**
 * @author: Lukas H,TimoK
 */

package com.questtoyagni.Player;

import com.questtoyagni.Board.Board;
import com.questtoyagni.coordinates.Coordinate;
import com.questtoyagni.coordinates.Directions;


public class Player {

	private String name;
	private Coordinate pos;
	//int xPos,yPos;
	private Board board = null;
	private boolean[] walls=null;
	
	/**
	 * 
	 * @param name Name of the Player
	 * @param xPos xPos of start position
	 * @param yPos yPos of start position
	 * @param board board id 
	 */
	public Player(String name,Coordinate pos,Board board) {
		this.pos = pos;
		this.name=name;
		this.board=board;
		walls=board.changePositionAndGetWallsAroundNewPosition(getPosition());
	}
	

	/**
	 * moves if possible in given direction and saves new walls at current position
	 * @param direction moving direction north/south/west/east
	 * @return true returns true if move is possible
	 */
	public boolean move(String direction) {
		
		if(Directions.NORTH.equalsIgnoreCase(direction)&& walls[0]==false) {
			pos.moveY(-1);
			walls=board.changePositionAndGetWallsAroundNewPosition(getPosition());
			return true;
		}
		else if(Directions.SOUTH.equalsIgnoreCase(direction)&& walls[1]==false) {
			pos.moveY(1);
			walls=board.changePositionAndGetWallsAroundNewPosition(getPosition());
			return true;
		}	
		else if(Directions.WEST.equalsIgnoreCase(direction)&& walls[2]==false) {
			pos.moveX(-1);
			walls=board.changePositionAndGetWallsAroundNewPosition(getPosition());
			return true;
		}	
		else if(Directions.EAST.equalsIgnoreCase(direction)&& walls[3]==false){
			pos.moveX(1);
			walls=board.changePositionAndGetWallsAroundNewPosition(getPosition());
			return true;
		}
		return false;
	}


	/**
	 * @return returns index of the players position
	 */
	public int getPosition(){
		return board.getWidth()*pos.getY()+pos.getX();
	}
	/**
	 * 
	 * @return returns coordinates of the player 
	 */
	public Coordinate getCoordinates(){
		return pos;
	}
	
	/** 
	 * set position of a player
	 */
	public void setPosition(Coordinate position) {
		this.pos=position;
	}
	/**
	 * returns name of the player
	 * @return name
	 */
	public String getName() {
		return name;
	}

}
