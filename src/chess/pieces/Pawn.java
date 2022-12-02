package chess.pieces;

import boardLayer.Board;
import boardLayer.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		Position p2 = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p2.setValues(position.getRow() - 2, position.getColumn());
			if (getBoard().positionExist(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExist(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p2.getRow()][p2.getColumn()] = true;
			}

			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			// en passant

			if (position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExist(left) && isThereOpponentPiece(left)
						&& getBoard().piece(left) == chessMatch.getEnPassanVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExist(right) && isThereOpponentPiece(right)
						&& getBoard().piece(right) == chessMatch.getEnPassanVulnerable()) {
					mat[right.getRow() - 1][right.getColumn()] = true;
				}
			}

		} else {
			p.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p2.setValues(position.getRow() + 2, position.getColumn());
			if (getBoard().positionExist(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExist(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p2.getRow()][p2.getColumn()] = true;
			}

			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			// en passant
			if (position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExist(left) && isThereOpponentPiece(left)
						&& getBoard().piece(left) == chessMatch.getEnPassanVulnerable()) {
					mat[left.getRow() + 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExist(right) && isThereOpponentPiece(right)
						&& getBoard().piece(right) == chessMatch.getEnPassanVulnerable()) {
					mat[right.getRow() + 1][right.getColumn()] = true;
				}
			}

		}

		return mat;
	}

}
