package tictactoe.board;

import java.util.Arrays;

import tictactoe.player.Player;

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
    public boolean hasWinner() {
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

    /**
     * Obtiene la marca ganadora del juego
     * 
     * @return la marca ganadora (X u O), o null si no hay ganador
     */
    public Mark getWinner() {
        // Verificar filas
        Mark winner = getWinnerFromRows();
        if (winner != null)
            return winner;

        // Verificar columnas
        winner = getWinnerFromColumns();
        if (winner != null)
            return winner;

        // Verificar diagonales
        winner = getWinnerFromDiagonals();
        if (winner != null)
            return winner;

        // No hay ganador
        return null;
    }

    /**
     * Busca la marca ganadora en las filas
     * 
     * @return la marca ganadora o null si no hay ganador en filas
     */
    private Mark getWinnerFromRows() {
        for (int i = 0; i < 3; i++) {
            if (squares[i][0] != Mark.EMPTY &&
                    squares[i][0] == squares[i][1] &&
                    squares[i][1] == squares[i][2]) {
                return squares[i][0];
            }
        }
        return null;
    }

    /**
     * Busca la marca ganadora en las columnas
     * 
     * @return la marca ganadora o null si no hay ganador en columnas
     */
    private Mark getWinnerFromColumns() {
        for (int j = 0; j < 3; j++) {
            if (squares[0][j] != Mark.EMPTY &&
                    squares[0][j] == squares[1][j] &&
                    squares[1][j] == squares[2][j]) {
                return squares[0][j];
            }
        }
        return null;
    }

    /**
     * Busca la marca ganadora en las diagonales
     * 
     * @return la marca ganadora o null si no hay ganador en diagonales
     */
    private Mark getWinnerFromDiagonals() {
        // Diagonal principal (0,0) -> (1,1) -> (2,2)
        if (squares[0][0] != Mark.EMPTY &&
                squares[0][0] == squares[1][1] &&
                squares[1][1] == squares[2][2]) {
            return squares[0][0];
        }

        // Diagonal secundaria (0,2) -> (1,1) -> (2,0)
        if (squares[0][2] != Mark.EMPTY &&
                squares[0][2] == squares[1][1] &&
                squares[1][1] == squares[2][0]) {
            return squares[0][2];
        }

        return null;
    }

    public void setMark(Coordinate coordinate, Mark mark) throws IllegalArgumentException {
        if (coordinate.getRow() < 0 || coordinate.getRow() > 2 || coordinate.getCol() < 0 || coordinate.getCol() > 2) {
            throw new IllegalArgumentException("Invalid row or column");
        }
        if (squares[coordinate.getRow()][coordinate.getCol()] != Mark.EMPTY) {
            throw new IllegalArgumentException("Square already taken");
        }

        this.squares[coordinate.getRow()][coordinate.getCol()] = mark;
    }

}
