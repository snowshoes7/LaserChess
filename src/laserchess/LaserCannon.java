package laserchess;

import processing.core.PImage;

public class LaserCannon extends Piece {

	public LaserCannon(int roww, int coll, int dir, String colorr, Board theBoard) {
		super(LaserChess.laserCannon0, roww, coll, dir, colorr, theBoard);
	}
	
	public PImage getIcon() {
		PImage toReturn = super.getIcon();
		if (super.getDirection() == 0) {
			super.setIcon(LaserChess.laserCannon0);
		} else if (super.getDirection() == 1) {
			//Default
			super.setIcon(LaserChess.laserCannon1);
		} else if (super.getDirection() == 2) {
			super.setIcon(LaserChess.laserCannon2);
		} else if (super.getDirection() == 3) {
			super.setIcon(LaserChess.laserCannon3);
		}
		return toReturn;
	}
	
	public void dieCheck() {
		//Can't die so don't do anything
		System.out.println("This piece cannot die since it is a LaserCannon");
	}
	
	public void fire() {
		int[] rc = {super.getRow(), super.getColumn()};
		super.getBoard().setLaserPosition(rc);
		super.getBoard().getLaserObject().setActive(true);
	}
}