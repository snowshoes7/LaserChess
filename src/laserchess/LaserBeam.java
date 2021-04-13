package laserchess;

public class LaserBeam {
	private int row;
	private int column;
	private int direction;
	/*
	 * 0 = Right
	 * 1 = Up
	 * 2 = Left
	 * 3 = Down
	 */
	private boolean doesNextTileContainPiece;
	private boolean nextMoveLegal;
	
	public LaserBeam(int roww, int col, int dir) {
		this.row = roww;
		this.column = col;
		this.direction = dir;
	}
	
	public void checkNextTile() {
		if (direction == 0) {
			
		} else if (direction == 1) {
			
		} else if (direction == 2) {
			
		} else if (direction == 3) {
			
		}
	}
	
	public int getRow() {
		return this.row;
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