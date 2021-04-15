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
		if ((this.getBoard().getTile(this.getRow(), this.getColumn()) == null) || (!(this.getBoard().getTile(this.getRow(), this.getColumn()).hasAnyPiece()))) {
			if (direction == 0) {
				if (this.getColumn() == this.board.getBoard()[0].length - 1) {
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
		} else {
			this.nextMoveLegal = true;
		}
	}
	
	public void checkThisTile() {
		if (this.getRow() >= 0 && this.getColumn() >= 0 && this.getRow() < 8 && this.getColumn() < 10) {
			if (this.getBoard().getTile(getRow(), getColumn()) != null && this.getBoard().getTile(getRow(), getColumn()).hasAnyPiece()) {
				Piece thePieceIAmOn = this.getBoard().getTile(this.getBoard().getLaserPosition()[0], this.getBoard().getLaserPosition()[1]).getPiece();
				if (!(thePieceIAmOn.isDead())) {
					if (thePieceIAmOn.getType().equals("Deflector")) {
						if (thePieceIAmOn.getDirection() == 1) {
							if (this.getDirection() == 2) {
								((Deflector)(thePieceIAmOn)).setKillSkip(true);
								this.setDirection(1);
							} else if (this.getDirection() == 3) {
								((Deflector)(thePieceIAmOn)).setKillSkip(true);
								this.setDirection(0);
							} else {
								((Deflector)(thePieceIAmOn)).setKillSkip(false);
								//thePieceIAmOn.dieCheck();
								//Kill the piece (done in the deflector class)
							}
						} else if (thePieceIAmOn.getDirection() == 0) {
							if (this.getDirection() == 2) {
								((Deflector)(thePieceIAmOn)).setKillSkip(true);
								this.setDirection(3);
								System.out.println("Redirect");
							} else if (this.getDirection() == 1) {
								((Deflector)(thePieceIAmOn)).setKillSkip(true);
								this.setDirection(0);
							} else {
								((Deflector)(thePieceIAmOn)).setKillSkip(false);
								//thePieceIAmOn.dieCheck();
								//Kill the piece (done in the deflector class)
							}
						} else if (thePieceIAmOn.getDirection() == 2) {
							if (this.getDirection() == 3) {
								((Deflector)(thePieceIAmOn)).setKillSkip(true);
								this.setDirection(2);
							} else if (this.getDirection() == 0) {
								((Deflector)(thePieceIAmOn)).setKillSkip(true);
								//System.out.println("Skipping kill");
								this.setDirection(1);
							} else {
								((Deflector)(thePieceIAmOn)).setKillSkip(false);
								//thePieceIAmOn.dieCheck();
								//Kill the piece (done in the deflector class)
							}
						} else if (thePieceIAmOn.getDirection() == 3) {
							if (this.getDirection() == 1) {
								((Deflector)(thePieceIAmOn)).setKillSkip(true);
								this.setDirection(2);
							} else if (this.getDirection() == 0) {
								((Deflector)(thePieceIAmOn)).setKillSkip(true);
								this.setDirection(3);
							} else {
								((Deflector)(thePieceIAmOn)).setKillSkip(false);
								//thePieceIAmOn.dieCheck();
								//Kill the piece (done in the deflector class)
							}
						}
					} else if (thePieceIAmOn.getType().equals("Switch")) {
						if (thePieceIAmOn.getDirection() == 0 || thePieceIAmOn.getDirection() == 2) {
							if (this.getDirection() == 1) {
								this.setDirection(0);
							} else if (this.getDirection() == 0) {
								this.setDirection(3);
							} else if (this.getDirection() == 3) {
								this.setDirection(2);
							} else if (this.getDirection() == 2) {
								this.setDirection(1);
							}
						} else if (thePieceIAmOn.getDirection() == 1 || thePieceIAmOn.getDirection() == 3) {
							if (this.getDirection() == 1) {
								this.setDirection(2);
							} else if (this.getDirection() == 0) {
								this.setDirection(1);
							} else if (this.getDirection() == 3) {
								this.setDirection(0);
							} else if (this.getDirection() == 2) {
								this.setDirection(3);
							}
						}
					}
				} else {
					System.out.println("Dead piece");
				}
			}
		} else {
			System.out.println("OOB ERROR CAUGHT");
			this.setActive(false);
		}
	}
	
	public void checkThisTileBenign() {
		if (this.getRow() >= 0 && this.getColumn() >= 0 && this.getRow() < 8 && this.getColumn() < 10) {
			if (this.getBoard().getTile(getRow(), getColumn()) != null && this.getBoard().getTile(getRow(), getColumn()).hasAnyPiece()) {
				Piece thePieceIAmOn = this.getBoard().getTile(this.getBoard().getLaserPosition()[0], this.getBoard().getLaserPosition()[1]).getPiece();
				if (!(thePieceIAmOn.isDead())) {
					if (thePieceIAmOn.getType().equals("Deflector")) {
						if (thePieceIAmOn.getDirection() == 1) {
							if (this.getDirection() == 2) {
								((Deflector)(thePieceIAmOn)).setKillSkip(true);
							} else if (this.getDirection() == 3) {
								((Deflector)(thePieceIAmOn)).setKillSkip(true);
							} else {
								((Deflector)(thePieceIAmOn)).setKillSkip(false);
								//thePieceIAmOn.dieCheck();
								//Kill the piece (done in the deflector class)
							}
						} else if (thePieceIAmOn.getDirection() == 0) {
							if (this.getDirection() == 2) {
								((Deflector)(thePieceIAmOn)).setKillSkip(true);
							} else if (this.getDirection() == 1) {
								((Deflector)(thePieceIAmOn)).setKillSkip(true);
							} else {
								((Deflector)(thePieceIAmOn)).setKillSkip(false);
								//thePieceIAmOn.dieCheck();
								//Kill the piece (done in the deflector class)
							}
						} else if (thePieceIAmOn.getDirection() == 2) {
							if (this.getDirection() == 3) {
								((Deflector)(thePieceIAmOn)).setKillSkip(true);
							} else if (this.getDirection() == 0) {
								((Deflector)(thePieceIAmOn)).setKillSkip(true);
								System.out.println("Skipping kill");
							} else {
								((Deflector)(thePieceIAmOn)).setKillSkip(false);
								//thePieceIAmOn.dieCheck();
								//Kill the piece (done in the deflector class)
							}
						} else if (thePieceIAmOn.getDirection() == 3) {
							if (this.getDirection() == 1) {
								((Deflector)(thePieceIAmOn)).setKillSkip(true);
							} else if (this.getDirection() == 0) {
								((Deflector)(thePieceIAmOn)).setKillSkip(true);
							} else {
								((Deflector)(thePieceIAmOn)).setKillSkip(false);
								//thePieceIAmOn.dieCheck();
								//Kill the piece (done in the deflector class)
							}
						}
					} else if (thePieceIAmOn.getType().equals("Defender")) {
						if ((thePieceIAmOn.getDirection() + 6) % 4 == this.getDirection()) {
							this.setActive(false);
							System.out.println("Block");
						}
					}
				} else {
					//System.out.println("Dead piece");
				}
			}
		} else {
			System.out.println("OOB ERROR CAUGHT");
			this.setActive(false);
		}
	}
	
	public int getRow() {
		return this.row;
	}
	
	private Board getBoard() {
		return this.board;
	}
	
	public void moveLaser() {
		if (moveCountDelay > 5) {
			this.checkNextTile();
			if (nextMoveLegal) {
				this.checkThisTile();
				if (this.getDirection() == 0) {
					this.setColumn(this.getColumn() + 1);
				} else if (this.getDirection() == 1) {
					this.setRow(this.getRow() - 1);
				} else if (this.getDirection() == 2) {
					this.setColumn(this.getColumn() - 1);
				} else if (this.getDirection() == 3) {
					this.setRow(this.getRow() + 1);
				}
				this.checkThisTileBenign();
			} else {
				//this.checkNextTile();
				this.setActive(false);
				System.out.println("Nextmove illegal?");
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