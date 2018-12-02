package Player;
import Board.Board;

class Player {
	
	String name;
	int xPos,yPos;
	final int breite=Board.getX();
	
	/**
	 * sets starting position on the board
	 * @param xPos
	 * @param yPos
	 */
	public Player(int xPos,int yPos) {
		this.xPos=xPos;
		this.yPos=yPos;
	}
	
	/**
	 * moves x,y in given direction and returns the walls
	 * @param direction
	 * @return walls as boolean Array
	 */
	public boolean[] move(String direction) {
		boolean[] walls=null;
		if(direction.toLowerCase().equals("north")) {
			yPos+=1;
			walls=Board.changePosition(breite*xPos+yPos);
			return walls;
		}
		else if(direction.toLowerCase().equals("south")) {
			yPos-=1;
			walls=Board.changePosition(breite*xPos+yPos);
			return walls;
		}	
		else if(direction.toLowerCase().equals("west")) {
			xPos+=1;
			walls=Board.changePosition(breite*xPos+yPos);
			return walls;
		}	
		else {
			xPos+=1;
			walls=Board.changePosition(breite*xPos+yPos);
			return walls;
		}
	}

}

