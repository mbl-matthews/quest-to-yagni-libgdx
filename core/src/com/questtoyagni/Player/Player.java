/**
 * @author: Lukas H
 */

package com.questtoyagni.Player;

import com.questtoyagni.Board.Board;
import com.questtoyagni.coordinates.Directions;


public class Player {

	String name;
	int xPos,yPos;
	Board board = null;
	int width=0;
	boolean[] walls=null;
	
	/**
	 * 
	 * @param name Name of the Player
	 * @param xPos xPos of start position
	 * @param yPos yPos of start position
	 * @param board board id 
	 */
	public Player(String name,int xPos,int yPos,Board board) {
		this.xPos=xPos;
		this.yPos=yPos;
		this.name=name;
		walls=board.changePositionAndGetWallsAroundNewPosition(width*yPos+xPos);
		this.board= board;
		this.width=board.getX();
	}
	

	/**
	 * moves if possible in given direction and saves new walls at current position
	 * @param direction moving direction north/south/west/east
	 * @return true returns true if move is possible
	 */
	public boolean move(String direction) {
		
		if(Directions.NORTH.equalsIgnoreCase(direction)&& walls[0]==false) {
			yPos-=1;
			walls=board.changePositionAndGetWallsAroundNewPosition(width*yPos+xPos);
			return true;
		}
		else if(Directions.SOUTH.equalsIgnoreCase(direction)&& walls[1]==false) {
			yPos+=1;
			walls=board.changePositionAndGetWallsAroundNewPosition(width*yPos+xPos);
			return true;
		}	
		else if(Directions.WEST.equalsIgnoreCase(direction)&& walls[2]==false) {
			xPos-=1;
			walls=board.changePositionAndGetWallsAroundNewPosition(width*yPos+xPos);
			return true;
		}	
		else if(Directions.EAST.equalsIgnoreCase(direction)&& walls[3]==false){
			xPos+=1;
			walls=board.changePositionAndGetWallsAroundNewPosition(width*yPos+xPos);
			return true;
		}
		return false;
	}


	/**
	 * @return returns index of the players position
	 */
	public int getPosition(){
		return width*yPos+xPos;
	}
	/**
	 * 
	 * @return returns coordinates of the player as int[]={xPos,yPos}
	 */
	public int[] getCoordinates(){
		return new int[] {xPos,yPos};
	}
	
	/** 
	 * set position of a player
	 */
	public void setPosition(int[] position) {
		xPos=position[0];
		yPos=position[1];
	}
	/**
	 * returns name of the player
	 * @return name
	 */
	public String getName() {
		return name;
	}

}
