package laserchess;

public class Board {
	private Tile[][] board = new Tile[5][5];
	
	public Board() {
		board = new Tile[5][5];
	}
	
	public Tile[][] getBoard() {
		return board;
	}
	
	public Tile getTile(int row, int col) {
		return board[row][col];
	}
}