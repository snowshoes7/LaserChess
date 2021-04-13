package laserchess;

public class Tile {
	private Piece onPiece = null;
	
	public Tile() {
		onPiece = null;
	}
	
	public Tile(Piece piece) {
		this.onPiece = piece;
	}
	
	public boolean hasAnyPiece() {
		if (onPiece != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Piece getPiece() {
		return onPiece;
	}
}