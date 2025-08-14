package tictactoe;

public class Game {

    tictactoe.board.Board board;
    tictactoe.player.Player player1;
    tictactoe.player.Player player2;
    tictactoe.turns.Turn turn;
    tictactoe.utilities.ConsoleUtils console = tictactoe.utilities.ConsoleUtils.getInstance();

    public Game() {
        this.board = new tictactoe.board.Board();
        this.player1 = new tictactoe.player.Player(tictactoe.board.Mark.X);
        this.player2 = new tictactoe.player.Player(tictactoe.board.Mark.O);
        this.turn = new tictactoe.turns.Turn(player1, player2, board);
    }

    public void play() {
        turn.play();
        if (turn.isATie()){
            console.printSuccess("It's a tie!");
            return;
        }
        
        tictactoe.player.Player winner = turn.getWinner();
        console.printSuccess("Player " + winner.getMark() + " wins!");
        console.printSuccess("Player " + winner.getName() + " wins!");
        console.printSuccess("Game over!");
        
    }

}