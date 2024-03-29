package laserchess;

import processing.core.PImage;

public class Switch extends Piece {

	public Switch(int roww, int coll, int dir, String colorr, Board theBoard) {
		super(LaserChess.switch0, roww, coll, dir, colorr, theBoard);
	}
	
	public PImage getIcon() {
		PImage toReturn = super.getIcon();
		if (super.getDirection() == 0) {
			super.setIcon(LaserChess.switch0);
		} else if (super.getDirection() == 1) {
			//Default
			super.setIcon(LaserChess.switch1);
		} else if (super.getDirection() == 2) {
			super.setIcon(LaserChess.switch2);
		} else if (super.getDirection() == 3) {
			super.setIcon(LaserChess.switch3);
		}
		toReturn = super.getIcon();
		return toReturn;
	}
	
	public String getType() {
		return "Switch";
	}
	
	public void dieCheck() {
		//Can't die so don't do anything
		/*if (this.getBoard().getLaserObject().isActive()) {
			System.out.println("This piece cannot die since it is a LaserCannon");
		}*/
	}
}