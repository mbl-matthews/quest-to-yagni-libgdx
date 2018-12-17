/**
 * @author: Mathis B
 */

package com.questtoyagni.reader;

import java.io.*;
import java.util.ArrayList;

import com.questtoyagni.Board.Board;
import com.questtoyagni.Event.Finishevent;
import com.questtoyagni.Event.Hintevent;
import com.questtoyagni.Event.Teleportevent;
import com.questtoyagni.Event.Wallevent;
import com.questtoyagni.Field.Eventfield;
import com.questtoyagni.Field.Field;
import com.questtoyagni.Field.Finishfield;
import com.questtoyagni.Field.Playfield;
import com.questtoyagni.Field.Startfield;


public class boardReader {
	
	/**
	 * Returns the Default Board which is a board with the Dimensions X=5 and Y=7
	 * @return ArrayList with the fields of the default Board
	 * @throws Exception Since this class is only for non-critical testing purpouses there is no Exception handling done
	 */
	public static ArrayList<Field> getDefaultBoard() throws Exception {
		ArrayList<Field> fields = new ArrayList<Field>();
		Finishevent finisheventobject = new Finishevent(1, "Finish");
		
		
		
		String[] allFields = readFile();
		for(int i = 0;i<allFields.length;i++) {
			String[] token = allFields[i].split(",");
			if(token[4].equals("start")) {
				fields.add(new Startfield(i,new boolean[] {Boolean.parseBoolean(token[0]), Boolean.parseBoolean(token[1]),Boolean.parseBoolean(token[2]),Boolean.parseBoolean(token[3])}));
			} else if (token[4].equals("finish")) {
				fields.add(new Finishfield(i,new boolean[] {Boolean.parseBoolean(token[0]), Boolean.parseBoolean(token[1]),Boolean.parseBoolean(token[2]),Boolean.parseBoolean(token[3])}, finisheventobject));
			} else if (token[4].equals("hint")) {
				Hintevent hinteventobject = new Hintevent(i, "hint");
				fields.add(new Eventfield(i,new boolean[] {Boolean.parseBoolean(token[0]), Boolean.parseBoolean(token[1]),Boolean.parseBoolean(token[2]),Boolean.parseBoolean(token[3])},hinteventobject));
			}else if (token[4].equals("teleport")) {
				Teleportevent teleporteventobject=new Teleportevent(i,"teleport");
				fields.add(new Eventfield(i,new boolean[] {Boolean.parseBoolean(token[0]), Boolean.parseBoolean(token[1]),Boolean.parseBoolean(token[2]),Boolean.parseBoolean(token[3])},teleporteventobject));
			}else if (token[4].equals("wall")) {
				Wallevent walleventobject=new Wallevent(i,"wall");
				fields.add(new Eventfield(i,new boolean[] {Boolean.parseBoolean(token[0]), Boolean.parseBoolean(token[1]),Boolean.parseBoolean(token[2]),Boolean.parseBoolean(token[3])},walleventobject));
			}else {
				fields.add(new Playfield(i,new boolean[] {Boolean.parseBoolean(token[0]), Boolean.parseBoolean(token[1]),Boolean.parseBoolean(token[2]),Boolean.parseBoolean(token[3])}));
			}
		}
		
		return fields;
	}
	
	/**
	 * Reads the file with the values for the default board and returns it as a String Array
	 * @return 
	 * @throws Exception Since this class is only for non-critical testing purpouses there is no Exception handling done
	 */
	static String[] readFile() throws Exception {
		BufferedReader file = new BufferedReader(new FileReader(new File("C:/Users/TimoK/git/quest-to-yagni/src/reader/defaultBoard.txt")));
		String[] allFields = new String[35];
		
		int i = 0;
		while(file.ready()) {
			allFields[i] = file.readLine();
			i++;
		}
		return allFields;
	}
}