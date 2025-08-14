package tictactoe.board;

import java.util.Arrays;

public class Board {

    private Mark[][] squares;

    public Board() {
        this.squares = new Mark[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.squares[i][j] = Mark.EMPTY;
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(squares[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setMark(int row, int col, Mark mark) throws IllegalArgumentException {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            throw new IllegalArgumentException("Invalid row or column");
        }
        if (squares[row][col] != Mark.EMPTY) {
            throw new IllegalArgumentException("Square already taken");
        }

        this.squares[row][col] = mark;
    }

    public Mark[][] getBoard() {
        return Arrays.copyOf(this.squares, this.squares.length);
        // return squares ??
    }

    public boolean isGameOver() {
        return hasWinner() || isBoardFull();
    }

    /**
     * Verifica si hay un ganador en el tablero
     * 
     * @return true si hay tres marcas iguales en fila, columna o diagonal
     */
    private boolean hasWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    /**
     * Verifica si hay tres marcas iguales en alguna fila
     */
    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (squares[i][0] != Mark.EMPTY &&
                    squares[i][0] == squares[i][1] &&
                    squares[i][1] == squares[i][2]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si hay tres marcas iguales en alguna columna
     */
    private boolean checkColumns() {
        for (int j = 0; j < 3; j++) {
            if (squares[0][j] != Mark.EMPTY &&
                    squares[0][j] == squares[1][j] &&
                    squares[1][j] == squares[2][j]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si hay tres marcas iguales en alguna diagonal
     */
    private boolean checkDiagonals() {
        // Diagonal principal (0,0) -> (1,1) -> (2,2)
        boolean mainDiagonal = squares[0][0] != Mark.EMPTY &&
                squares[0][0] == squares[1][1] &&
                squares[1][1] == squares[2][2];

        // Diagonal secundaria (0,2) -> (1,1) -> (2,0)
        boolean antiDiagonal = squares[0][2] != Mark.EMPTY &&
                squares[0][2] == squares[1][1] &&
                squares[1][1] == squares[2][0];

        return mainDiagonal || antiDiagonal;
    }

    /**
     * Verifica si el tablero está completamente lleno
     * 
     * @return true si no hay espacios vacíos
     */
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (squares[i][j] == Mark.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

}
