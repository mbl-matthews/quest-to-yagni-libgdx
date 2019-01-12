package com.questtoyagni.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * reads input
 * @author: Levent K
 */

public class InputReader {
	/**
	 * @return returns input
	 * @throws IOException
	 */
    public static String readString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String in = br.readLine();
       br.close();
       return in;
    }
}
