/**
 * @author Mathis B
 */
package com.questtoyagni;

import com.questtoyagni.TUI.InputController;

/**
 * textbasiertes main ruft dauerhaft die Spieleingabe auf und beendet das Spiel nach dem Erreichen des Finishfiels
 */
public class Main {

    public static void main(String[] args){
        InputController ic = new InputController(5,7);
        int condition = 0;
        while(condition == 0) {
            condition = ic.eingabe();
        }
    }
}
