package laserchess;

import processing.core.PImage;

public class Deflector extends Piece {
	
	private boolean killSkipRedirect;
	private int immunityTimer;

	public Deflector(int roww, int coll, int dir, String colorr, Board theBoard) {
		super(LaserChess.deflector0, roww, coll, dir, colorr, theBoard);
		this.killSkipRedirect = false;
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
		toReturn = super.getIcon();
		return toReturn;
	}
	
	public String getType() {
		return "Deflector";
	}
	
	public void setKillSkip(boolean k) {
		this.killSkipRedirect = k;
		if (k == true) {
			immunityTimer = 6;
		} else {
			immunityTimer = 0;
		}
	}
	
	public boolean getKillSkip() {
		return this.killSkipRedirect;
	}
	
	public void dieCheck() {
		if (super.getBoard().getLaserPosition()[0] == super.getRow() && super.getBoard().getLaserPosition()[1] == super.getColumn()) {
			if (immunityTimer <= 0) {
				if (!(this.killSkipRedirect)) {
					System.out.println("Killing deflector");
					super.setDead(true);
				}
			} else if (immunityTimer > 0) {
				immunityTimer--;
			}
		} else {
			this.killSkipRedirect = false;
		}
	}
}