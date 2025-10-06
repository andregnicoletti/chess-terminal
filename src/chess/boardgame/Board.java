package chess.boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Rows and columns must be greater than 1");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        this.validadePositions(row, column);
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        return this.piece(position.row(), position.column());
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("Piece already exists in this position " + position);
        }
        pieces[position.row()][position.column()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.row(), position.column());
    }

    public boolean thereIsAPiece(Position position) {
        this.validadePositions(position);
        return piece(position) != null;
    }

    public void validadePositions(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position does not exist in this board");
        }
    }

    public void validadePositions(Position position) {
        this.validadePositions(position.row(), position.column());
    }

}
