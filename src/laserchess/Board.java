package laserchess;

public class Board {
	private Tile[][] board = new Tile[8][10];
	private LaserBeam laser;
	private boolean isPlayingGame = true;
	
	public Board() {
		board = new Tile[8][10];
		laser = new LaserBeam(0, 0, 0, this);
	}
	
	public Tile[][] getBoard() {
		return board;
	}
	
	public Tile getTile(int row, int col) {
		return board[row][col];
	}
	
	public void setTile(Tile t, int row, int col) {
		board[row][col] = t;
	}
	
	public int[] getLaserPosition() {
		int[] toReturn = {laser.getRow(), laser.getColumn()};
		return toReturn;
	}
	
	public void setLaserPosition(int[] rowcol) {
		laser.setRow(rowcol[0]);
		laser.setColumn(rowcol[1]);
	}
	
	public LaserBeam getLaserObject() {
		return this.laser;
	}
	
	public boolean isPlayingGame() {
		return this.isPlayingGame;
	}
	
	public void setPlayingGame(boolean p) {
		this.isPlayingGame = p;
	}
	
	public void kingDeath() {
		this.isPlayingGame = false;
	}
}