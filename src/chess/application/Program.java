package chess.application;

import chess.boardgame.Board;
import chess.boardgame.Position;
import chess.chess.ChessMatch;

public class Program {

    public static void main(String[] args) {

        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());

    }

}
