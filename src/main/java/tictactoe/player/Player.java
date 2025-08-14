package tictactoe.player;

import tictactoe.board.Coordinate;
import tictactoe.board.Mark;

public class Player {
    private Mark mark;
    private String name;
    tictactoe.utilities.ConsoleUtils console = tictactoe.utilities.ConsoleUtils.getInstance();

    public Player(Mark mark) {
        this.mark = mark;
        this.name = console.readString("Enter player " + mark + " name: ");
    }

    public Mark getMark() {
        return this.mark;
    }

    public String getName() {
        return this.name;
    }

    public Coordinate getMove() {
        console.printText("\nPlayer " + this.name + " (" + this.mark + ") turn");
        // player try to accomplished his goals (win)
        int row = console.readIntInRange("Enter row: ", 0, 2);
        int col = console.readIntInRange("Enter column: ", 0, 2);
        return new Coordinate(row, col);
    }

}
