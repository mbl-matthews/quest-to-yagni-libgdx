/**
 * @author: Levent K
 */

package com.questtoyagni.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * liest Eingaben im Controller
 */
public class InputReader {
    public static String readString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String in = br.readLine();
       //br.close();
       return in;
    }
}
