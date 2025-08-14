package tictactoe.turns;

import java.util.Random;
import tictactoe.board.Board;
import tictactoe.board.Mark;
import tictactoe.player.Player;

public class Turn {
    private Player player1;
    private Player player2;
    private Board board;
    private Player currentPlayer;
    tictactoe.utilities.ConsoleUtils console = tictactoe.utilities.ConsoleUtils.getInstance();

    public Turn(Player player1, Player player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.currentPlayer = getFirstPlayer(); // Selecciona aleatoriamente el primer jugador
    }

    private void takeTurn() {
        boolean error = true;
        while (error) {
            console.printText("\n\nPlayer " + currentPlayer.getMark() + " turn");
            board.printBoard();
            int row = console.readIntInRange("Enter row: ", 0, 2);
            int col = console.readIntInRange("Enter column: ", 0, 2);
            tictactoe.board.Coordinate coordinate = new tictactoe.board.Coordinate(row, col);
            try {
                // board.setMark(row, col, currentPlayer.getMark());
                board.setMark(coordinate, currentPlayer.getMark());
                error = false;
            } catch (IllegalArgumentException e) {
                console.printError(e.getMessage());
                takeTurn();
                error = true;
            }
        }
    }

    public Player getWinner() {
        if (board.hasWinner()) {
            Mark winningMark = board.getWinner();
            if (winningMark == player1.getMark()) {
                return player1;
            } else if (winningMark == player2.getMark()) {
                return player2;
            }
        }
        return null;
    }

    public void play() {
        currentPlayer = getFirstPlayer();
        while (!board.isGameOver()) {
            takeTurn();
            switchPlayer();
        }
    }

    public boolean isATie() {
        if (board.isGameOver() && !board.hasWinner()) {
            return true;
        }
        return false;
    }

    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private Player getFirstPlayer() {
        Random random = new Random();
        int randomChoice = random.nextInt(2);

        if (randomChoice == 0) {
            System.out.println("¡" + player1.getName() + " comienza el juego!");
            return player1;
        } else {
            System.out.println("¡" + player2.getName() + " comienza el juego!");
            return player2;
        }
    }

}
