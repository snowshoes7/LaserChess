package laserchess;

import processing.core.PImage;

public class Deflector extends Piece {

	public Deflector(int roww, int coll, int dir, String colorr, Board theBoard) {
		super(LaserChess.deflector0, roww, coll, dir, colorr, theBoard);
	}
	
	public PImage getIcon() {
		PImage toReturn = super.getIcon();
		if (super.getDirection() == 0) {
			super.setIcon(LaserChess.deflector0);
		} else if (super.getDirection() == 1) {
			//Default
			super.setIcon(LaserChess.deflector1);
		} else if (super.getDirection() == 2) {
			super.setIcon(LaserChess.deflector2);
		} else if (super.getDirection() == 3) {
			super.setIcon(LaserChess.deflector3);
		}
		return toReturn;
	}
}