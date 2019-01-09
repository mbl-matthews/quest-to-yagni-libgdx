/**
 * @author: Lukas H
 */
package com.questtoyagni.coordinates;

public enum Directions {
	
	NORTH("North"),SOUTH("South"),WEST("West"),EAST("East");  
	
	private final String direction;
	
	private Directions(String direction){
		this.direction=direction;
	}
	
	Directions(){
		direction=null;
	}
	
	@Override
	public String toString() {
		return this.direction;
	}
	
	public boolean equalsIgnoreCase(final String s) {
		return direction.equalsIgnoreCase(s);
		
	}
}
