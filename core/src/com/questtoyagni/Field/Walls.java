package com.questtoyagni.Field;

/**
 *  represents the walls around a field-object as 4 walls(n,s,w,e)
 * @author Timo K
 */
public class Walls {
	private boolean north;
	private boolean south;
	private boolean west;
	private boolean east;
	/**
	 * 
	 * @param north
	 * @param south
	 * @param west
	 * @param east
	 */
	public Walls(boolean north,boolean south,boolean west,boolean east) {
		this.north=north;
		this.south=south;
		this.west=west;
		this.east=east;
	}
	/**
	 * @return true if wall in this direction
	 */
	public boolean isNorth() {
		return north;
	}
	/**
	 * @return true if wall in this direction
	 */
	public boolean isSouth() {
		return south;
	}
	/**
	 * @return true if wall in this direction
	 */
	public boolean isWest() {
		return west;
	}
	/**
	 * @return true if wall in this direction
	 */
	public boolean isEast() {
		return east;
	}

	/**
	 * @param obj Walls-object
	 * @return true if walls are equal
	 */
	public boolean equals(Walls obj) {
		if (obj == null)
			return false;
		if (east != obj.east)
			return false;
		if (north != obj.north)
			return false;
		if (south != obj.south)
			return false;
		if (west != obj.west)
			return false;
		return true;
	}

}
