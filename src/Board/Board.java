package Board;

import java.util.ArrayList;
import Event.*;
import Field.*;
import GUI.*;
import Player.*;
import TUI.*;
import reader.boardReader;

public class Board {

    private static ArrayList<Field> fields = new ArrayList<Field>();
    private static int x;
    private static int y;

    public Board(int x, int y) throws Exception {
        this.x = x;
        this.y = y;
        this.fields = boardReader.getDefaultBoard();
    }

    public Field getField(int pos) {
        return fields.get(pos);
    }

    public static boolean[] changePosition(int pos) {
        return fields.get(pos).getWalls();
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }
}