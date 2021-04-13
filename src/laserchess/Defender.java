package laserchess;

import processing.core.PImage;

public class Defender extends Piece {

	public Defender(int roww, int coll, int dir, String colorr, Board theBoard) {
		super(LaserChess.defender0, roww, coll, dir, colorr, theBoard);
	}
	
	public PImage getIcon() {
		PImage toReturn = super.getIcon();
		if (super.getDirection() == 0) {
			super.setIcon(LaserChess.defender0);
		} else if (super.getDirection() == 1) {
			//Default
			super.setIcon(LaserChess.defender1);
		} else if (super.getDirection() == 2) {
			super.setIcon(LaserChess.defender2);
		} else if (super.getDirection() == 3) {
			super.setIcon(LaserChess.defender3);
		}
		return toReturn;
	}
	
	public void dieCheck() {
		
	}
}