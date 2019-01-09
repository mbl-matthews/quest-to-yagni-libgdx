/**
 * @author: Lukas H
 */
package com.questtoyagni.coordinates;
/**
 * directions of the game
 */
public enum Directions {
	
	NORTH("North"),SOUTH("South"),WEST("West"),EAST("East");  
	
	private final String direction;
	
	/**
	 * @param direction
	 */
	private Directions(String direction){
		this.direction=direction;
	}

	/**
	 * @return returns direction as String
	 */
	@Override
	public String toString() {
		return this.direction;
	}
	
	/** 
	 * @param s string to compare
	 * @return returns true if s equals direction
	 */
	public boolean equalsIgnoreCase(final String s) {
		return direction.equalsIgnoreCase(s);
		
	}
}
