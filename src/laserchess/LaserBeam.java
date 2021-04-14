package laserchess;

import processing.core.PImage;

public class LaserBeam {
	private int row;
	private int column;
	private int direction;
	private Board board;
	/*
	 * 0 = Right
	 * 1 = Up
	 * 2 = Left
	 * 3 = Down
	 */
	private boolean doesNextTileContainPiece;
	private boolean nextMoveLegal = false;
	private boolean isActive;
	
	private int moveCountDelay = 0;
	
	public LaserBeam(int roww, int col, int dir, Board theBoard) {
		this.row = roww;
		this.column = col;
		this.direction = dir;
		this.isActive = false;
		this.board = theBoard;
	}
	
	public void checkNextTile() {
		if (direction == 0) {
			if (this.getColumn() == this.board.getBoard()[0].length) {
				this.nextMoveLegal = false;
			} else {
				this.nextMoveLegal = true;
			}
		} else if (direction == 1) {
			if (this.getRow() == 0) {
				this.nextMoveLegal = false;
			} else {
				this.nextMoveLegal = true;
			}
		} else if (direction == 2) {
			if (this.getColumn() == 0) {
				this.nextMoveLegal = false;
			} else {
				this.nextMoveLegal = true;
			}
		} else if (direction == 3) {
			if (this.getRow() == this.board.getBoard().length - 1) {
				this.nextMoveLegal = false;
			} else {
				this.nextMoveLegal = true;
			}
		}
	}
	
	public int getRow() {
		return this.row;
	}
	
	public void moveLaser() {
		if (moveCountDelay > 5) {
			this.checkNextTile();
			if (nextMoveLegal) {
				if (this.getDirection() == 0) {
					this.setColumn(this.getColumn() + 1);
				} else if (this.getDirection() == 1) {
					this.setRow(this.getRow() - 1);
				} else if (this.getDirection() == 2) {
					this.setColumn(this.getColumn() - 1);
				} else if (this.getDirection() == 3) {
					this.setRow(this.getRow() + 1);
				}
			} else {
				this.setActive(false);
			}
			moveCountDelay = 0;
		} else {
			moveCountDelay++;
		}
	}
	
	public boolean isActive() {
		return this.isActive;
	}
	
	public void setActive(boolean b) {
		this.isActive = b;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	public void setDirection(int d) {
		this.direction = d;
	}
	
	public PImage getIcon() {
		PImage toReturn = LaserChess.laser0;
		if (this.isActive()) {
			if (getDirection() == 0) {
				toReturn = LaserChess.laser0;
			} else if (getDirection() == 1) {
				//Default
				toReturn = LaserChess.laser1;
			} else if (getDirection() == 2) {
				toReturn = LaserChess.laser2;
			} else if (getDirection() == 3) {
				toReturn = LaserChess.laser3;
			}
		} else {
			toReturn = LaserChess.blankImage;
		}
		return toReturn;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public void setRow(int roww) {
		this.row = roww;
	}
	
	public void setColumn(int col) {
		this.column = col;
	}
}