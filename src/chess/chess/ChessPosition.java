package chess.chess;

import chess.boardgame.Position;

public record ChessPosition(char column, int row) {

    public ChessPosition {
        if (column < 'a' || row < 1 || column > 'h' || row > 8) {
            throw new IllegalArgumentException("Invalid position");
        }
    }

    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char) ('a' - position.column()), 8 - position.row());
    }

    @Override
    public String toString() {
        return "" + column + row;
    }

}
