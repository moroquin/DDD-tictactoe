package tictactoe.board;

public enum Mark {
    X("X"), O("O"), EMPTY("_");

    private final String value;

    Mark(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
