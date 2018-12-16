package com.questtoyagni;

import com.questtoyagni.TUI.InputController;

public class Main {

    public static void main(String[] args){
        InputController ic = new InputController(5,7);
        int condition = 0;
        while(condition == 0) {
            condition = ic.eingabe();
        }
    }
}
