
package com.questtoyagni.player;

import com.questtoyagni.board.Board;
import com.questtoyagni.coordinates.Coordinate;
import com.questtoyagni.coordinates.Directions;
import com.questtoyagni.field.Walls;

/**
 * Represents the player of the game and lets him move
 * holds his name,his position,the board of the actual game and the walls at his position
 * @author: Lukas H,Timo K
 */
public class Player {

	private String name;
	private Coordinate pos;
	private Board board = null;
	private Walls walls;
	
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
		
		if(Directions.NORTH.equalsIgnoreCase(direction)&& walls.isNorth()==false) {
			pos.moveY(-1);
			walls=board.changePositionAndGetWallsAroundNewPosition(getPosition());
			return true;
		}
		else if(Directions.SOUTH.equalsIgnoreCase(direction)&& walls.isSouth()==false) {
			pos.moveY(1);
			walls=board.changePositionAndGetWallsAroundNewPosition(getPosition());
			return true;
		}	
		else if(Directions.WEST.equalsIgnoreCase(direction)&& walls.isWest()==false) {
			pos.moveX(-1);
			walls=board.changePositionAndGetWallsAroundNewPosition(getPosition());
			return true;
		}	
		else if(Directions.EAST.equalsIgnoreCase(direction)&& walls.isEast()==false){
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
	
	/**
	 * @return current walls
	 */
	public Walls getWalls() {
		return walls;
	}

}
