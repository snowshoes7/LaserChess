package laserchess;

public class Tile {
	private Piece onPiece = null;
	
	public boolean hasAnyPiece() {
		if (onPiece != null) {
			return true;
		} else {
			return false;
		}
	}
}