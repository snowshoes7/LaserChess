package laserchess;

import processing.core.PApplet;
import processing.core.PImage;

public class LaserChess extends PApplet {
	
	boolean playingGame = true; //False if a king dies.
	Board mainBoard = new Board();
	PImage piece = new PImage();
	
	public void settings() {
		size(500, 500);
	}

	public void setup() {
		surface.setTitle("Laser Chess");
		piece = loadImage("chess.png");
	}
	
	public void drawBoard() {
		background(0);
		stroke(255);
		fill(0);
		strokeWeight(4);
		rect(50, 50, 400, 400);
		line(50+80, 50, 50+80, 450);
		line(50+80+80, 50, 50+80+80, 450);
		line(50+80+80+80, 50, 50+80+80+80, 450);
		line(50+80+80+80+80, 50, 50+80+80+80+80, 450);
		line(50, 50+80, 450, 50+80);
		line(50, 50+80+80, 450, 50+80+80);
		line(50, 50+80+80+80, 450, 50+80+80+80);
		line(50, 50+80+80+80+80, 450, 50+80+80+80+80);
		fill(255);
		text("Laser Chess Demo", 15, 25);
	}
	
	public void drawPieces() {
		int baseRowLoc = 50;
		int baseColLoc = 50;
		for (int row = 0; row < mainBoard.getBoard().length; row++) {
			for (int col = 0; col < mainBoard.getBoard()[row].length; col++) {
				if ((mainBoard.getTile(row, col) != null) && (mainBoard.getTile(row, col).hasAnyPiece())) { //null check must go first, otherwise we risk a NullPointerException
					image(piece, baseRowLoc + 22, baseColLoc + 5, 35, 70);
				}
				baseRowLoc += 80;
			}
			baseColLoc += 80;
			baseRowLoc = 50;
		}
	}

	public void draw() {
		if (playingGame) {
			drawBoard();
			
			drawPieces();
		}
	}
	
	public void keyPressed() {
		if (keyCode == ESC) {
			stop();
		}
		if (keyCode == RETURN || keyCode == ENTER) {
			//Advance scenario if previous scenario is done
		}
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { laserchess.LaserChess.class.getName() });
	}
}