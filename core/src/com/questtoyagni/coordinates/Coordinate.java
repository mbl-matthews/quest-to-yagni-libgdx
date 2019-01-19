package com.questtoyagni.coordinates;
/**
 * Represents the position in a 2 dimensional world
 * @author Timo K
 */
public class Coordinate {
	private int x;
	private int y;
	/**
	 * 
	 * @param x =x position in the world
	 * @param y =y position in the world
	 */
	public Coordinate(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	/**
	 * Move the coordinate for a given amount in the x direction 
	 * @param amount
	 */
	public void moveX(int amount) {
		this.x+=amount;
	}
	
	/**
	 * Move the coordinate for a given amount in the y direction
	 * @param amount
	 */
	public void moveY(int amount) {
		this.y+=amount;
	}
	
	/**
	 * Subtraction from 2 Coordinates
	 * @param cord 
	 * @return the Result of the subtraction
	 */
	public Coordinate sub(Coordinate cord) {		
		return new Coordinate(this.x-cord.getX(),this.y-cord.getY());
	}

	/**
	 * Checks if 2 Coordinates are equal
	 * @param Object
	 * @return 1 if equal 0 if not
	 */
	@Override
	public boolean equals(Object o) {
		Coordinate cord=(Coordinate)o;
		return this.x == cord.x && this.y == cord.y;
	}
}
