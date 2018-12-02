package reader;

import java.io.*;
import java.util.ArrayList;

import Board.Board;
import Field.Field;

public class boardReader {
	
	public static ArrayList<Field> getDefaultBoard() throws Exception {
		ArrayList<Field> fields = new ArrayList<Field>();
		
		String[] allFields = readFile();
		for(int i = 0;i<allFields.length;i++) {
			String[] token = allFields[i].split(",");
			if(token[4].equals("start")) {
				fields.add(new Startfield(new boolean[] {Boolean.parseBoolean(token[0]), Boolean.parseBoolean(token[1]),Boolean.parseBoolean(token[2]),Boolean.parseBoolean(token[3])}));
			} else if (token[4].equals("finish")) {
				fields.add(new Finishfield(new boolean[] {Boolean.parseBoolean(token[0]), Boolean.parseBoolean(token[1]),Boolean.parseBoolean(token[2]),Boolean.parseBoolean(token[3])}));
			} else {
				fields.add(new Playfield(new boolean[] {Boolean.parseBoolean(token[0]), Boolean.parseBoolean(token[1]),Boolean.parseBoolean(token[2]),Boolean.parseBoolean(token[3])}));
			}
		}
		
		return fields;
	}
	
	private static String[] readFile() throws Exception {
		BufferedReader file = new BufferedReader(new FileReader(new File("defaultBoard.txt")));
		String[] allFields = new String[35];
		
		int i = 0;
		while(file.ready()) {
			allFields[0] = file.readLine();
			i++;
		}
		
		return allFields;
	}
}
