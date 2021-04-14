package laserchess;

import processing.core.PImage;

public class King extends Piece {
	
	public King(int roww, int coll, int dir, String colorr, Board theBoard) {
		super(LaserChess.king0, roww, coll, dir, colorr, theBoard);
	}
	
	public PImage getIcon() {
		PImage toReturn = super.getIcon();
		if (super.getDirection() == 0) {
			super.setIcon(LaserChess.king0);
		} else if (super.getDirection() == 1) {
			//Default
			super.setIcon(LaserChess.king1);
		} else if (super.getDirection() == 2) {
			super.setIcon(LaserChess.king2);
		} else if (super.getDirection() == 3) {
			super.setIcon(LaserChess.king3);
		}
		toReturn = super.getIcon();
		return toReturn;
	}
	
	public void dieCheck() {
		if (super.getBoard().getLaserPosition()[0] == super.getRow() && super.getBoard().getLaserPosition()[1] == super.getColumn()) {
			super.setDead(true);
			super.getBoard().kingDeath();
		}
	}
}