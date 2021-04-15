package laserchess;

import processing.core.*;
import processing.data.*;

public class Piece {
	private PImage icon;
	private int row;
	private int column;
	private Board board;
	private boolean isDead;
	private int direction;
	/*
	 * 0 = Right
	 * 1 = Up
	 * 2 = Left
	 * 3 = Down
	 */
	private String color;
	/*
	 * Color is either "Red" or "Blue"
	 */
	
	public Piece(PImage iconn, int roww, int coll, int dir, String colorr, Board theBoard) {
		this.icon = iconn;
		this.row = roww;
		this.column = coll;
		this.board = theBoard;
		this.isDead = false;
		this.direction = dir;
		this.color = colorr;
	}
	
	public PImage getIcon() {
		return icon;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	public String getType() {
		return "Piece";
	}
	
	public void setDirection(int d) {
		this.direction = d;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String c) {
		this.color = c;
	}
	
	public void setIcon(PImage p) {
		this.icon = p;
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
	
	public Board getBoard() {
		return this.board;
	}
	
	public boolean isDead() {
		return this.isDead;
	}
	
	public void setDead(boolean d) {
		this.isDead = d;
		if (d == true) {
			this.board.getLaserObject().setActive(false);
		}
	}
	
	public void dieCheck() {
		if (getBoard().getLaserPosition()[0] == getRow() && getBoard().getLaserPosition()[1] == getColumn()) {
			this.isDead = true;
		}
	}
}