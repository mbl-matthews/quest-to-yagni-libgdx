package com.questtoyagni.Field;

/**
 * 4 walls North,south,west,east
 * @author TimoK
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
	public boolean isNorth() {
		return north;
	}
	public boolean isSouth() {
		return south;
	}
	public boolean isWest() {
		return west;
	}
	public boolean isEast() {
		return east;
	}

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
