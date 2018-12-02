package TUI;

import java.io.*;
import Player.*;

public class InputController{
	Player p = new Player(1,1);
	public void Eingabe(){
	String eingabe=null;
	System.out.println("Where do you want to go?(North,South,West,East):");
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	try {
	eingabe= br.readLine();
	br.close();
	}
	catch(Exception e) {}
	if(eingabe.equalsIgnoreCase("North") || eingabe.equalsIgnoreCase("South") || eingabe.equalsIgnoreCase("West") || eingabe.equalsIgnoreCase("East")) {
		boolean ausgabe=p.move(eingabe);	
		if(!ausgabe) {System.out.println("Can't move "+eingabe);}
	}
	else {
		System.out.println("Wrong input");
	}
	}
}