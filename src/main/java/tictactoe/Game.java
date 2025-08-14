package tictactoe;

public class Game {

    tictactoe.board.Board board;
    tictactoe.player.Player player1;
    tictactoe.player.Player player2;
    tictactoe.turns.Turn turn;
    tictactoe.utilities.ConsoleUtils console = tictactoe.utilities.ConsoleUtils.getInstance();

    public Game() {
        this.board = new tictactoe.board.Board();
        this.player1 = new tictactoe.player.Player(tictactoe.player.Mark.X);
        this.player2 = new tictactoe.player.Player(tictactoe.player.Mark.O);
        this.turn = new tictactoe.turns.Turn(player1, player2, board);
    }

    public void play() {
        while (!board.isGameOver()) {
            turn.takeTurn();
        }
        tictactoe.player.Player winner = turn.getWinner();
        console.clearConsole("Player " + winner.getMark() + " wins!");
        console.clearConsole("Player " + winner.getName() + " wins!");
        console.printSuccess("Game over!");
    }
    
}