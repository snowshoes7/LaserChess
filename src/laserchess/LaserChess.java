package laserchess;

import processing.core.PApplet;
import processing.core.PImage;

public class LaserChess extends PApplet {
	
	private Board mainBoard = new Board();
	private PImage piece = new PImage();
	
	//IMAGE DECLARATIONS
	public static PImage king0 = new PImage();
	public static PImage king1 = new PImage();
	public static PImage king2 = new PImage();
	public static PImage king3 = new PImage();
	
	public static PImage defender0 = new PImage();
	public static PImage defender1 = new PImage();
	public static PImage defender2 = new PImage();
	public static PImage defender3 = new PImage();
	
	public static PImage deflector0 = new PImage();
	public static PImage deflector1 = new PImage();
	public static PImage deflector2 = new PImage();
	public static PImage deflector3 = new PImage();
	
	public static PImage switch0 = new PImage();
	public static PImage switch1 = new PImage();
	public static PImage switch2 = new PImage();
	public static PImage switch3 = new PImage();
	
	public static PImage laserCannon0 = new PImage();
	public static PImage laserCannon1 = new PImage();
	public static PImage laserCannon2 = new PImage();
	public static PImage laserCannon3 = new PImage();
	
	public static PImage laser0 = new PImage();
	public static PImage laser1 = new PImage();
	public static PImage laser2 = new PImage();
	public static PImage laser3 = new PImage();
	
	public static PImage blankImage = new PImage();
	
	public void settings() {
		size(1080, 650);
	}

	public void setup() {
		surface.setTitle("Laser Chess");
		//piece = loadImage("chess.png");
		
		//IMAGE CONFIGURATIONS
		king0 = loadImage("king0.png");
		king1 = loadImage("king1.png");
		king2 = loadImage("king2.png");
		king3 = loadImage("king3.png");
		
		defender0 = loadImage("defender0.png");
		defender1 = loadImage("defender1.png");
		defender2 = loadImage("defender2.png");
		defender3 = loadImage("defender3.png");
		
		deflector0 = loadImage("deflector0.png");
		deflector1 = loadImage("deflector1.png");
		deflector2 = loadImage("deflector2.png");
		deflector3 = loadImage("deflector3.png");
		
		switch0 = loadImage("switch0.png");
		switch1 = loadImage("switch1.png");
		switch2 = loadImage("switch2.png");
		switch3 = loadImage("switch3.png");
		
		laserCannon0 = loadImage("laserCannon0.png");
		laserCannon1 = loadImage("laserCannon1.png");
		laserCannon2 = loadImage("laserCannon2.png");
		laserCannon3 = loadImage("laserCannon3.png");
		
		laser0 = loadImage("laser0.png");
		laser1 = loadImage("laser1.png");
		laser2 = loadImage("laser2.png");
		laser3 = loadImage("laser3.png");
		
		blankImage = loadImage("blank.png");
		
		//SET UP
		mainBoard.setTile(new Tile(new LaserCannon(0, 0, 0, "red", mainBoard)), 0, 0);
		mainBoard.setTile(new Tile(new King(0, 9, 0, "blue", mainBoard)), 0, 9);
	}
	
	public void drawBoard() {
		background(0);
		stroke(255);
		fill(0);
		strokeWeight(2);
		rect(50, 50, 1000, 560);
		for (int r = 1; r < 8; r++) {
			line(50, 50 + (70 * r), 1050, 50 + (70 * r));
		}
		for (int c = 1; c < 10; c++) {
			line(50 + (100 * c), 50, 50 + (100 * c), 610);
		}
		fill(255);
		text("Laser Chess Demo", 15, 25);
	}
	
	public void drawPieces() {
		int baseRowLoc = 50;
		int baseColLoc = 50;
		for (int row = 0; row < mainBoard.getBoard().length; row++) {
			for (int col = 0; col < mainBoard.getBoard()[row].length; col++) {
				if ((mainBoard.getTile(row, col) != null) && (mainBoard.getTile(row, col).hasAnyPiece())) { //null check must go first, otherwise we risk a NullPointerException
					image(mainBoard.getTile(row, col).getPiece().getIcon(), baseRowLoc + 14, baseColLoc + 5, 75, 60);
				}
				if (mainBoard.getLaserObject().isActive() && mainBoard.getLaserPosition()[0] == row && mainBoard.getLaserPosition()[1] == col) {
					image(mainBoard.getLaserObject().getIcon(), baseRowLoc + 14, baseColLoc + 5, 75, 60);
					System.out.println("Rendered laser at" + row + " " + col);
				}
				baseRowLoc += 100;
			}
			baseColLoc += 70;
			baseRowLoc = 50;
		}
	}
	
	public void checkDeaths() {
		for (int row = 0; row < mainBoard.getBoard().length; row++) {
			for (int col = 0; col < mainBoard.getBoard()[row].length; col++) {
				if ((mainBoard.getTile(row, col) != null) && (mainBoard.getTile(row, col).hasAnyPiece())) { //null check must go first, otherwise we risk a NullPointerException
					mainBoard.getTile(row, col).getPiece().dieCheck();
				}
			}
		}
	}

	public void draw() {
		if (mainBoard.isPlayingGame()) {
			drawBoard();
			drawPieces();
			if (mainBoard.getLaserObject().isActive()) {
				mainBoard.getLaserObject().moveLaser();
			}
			checkDeaths();
		} else {
			background(0);
			stroke(255);
			fill(0);
			strokeWeight(2);
			fill(255);
			text("GAME STOPPED", 15, 25);
		}
	}
	
	public void keyPressed() {
		if (keyCode == RETURN || keyCode == ENTER) {
			//Advance scenario if previous scenario is done
			System.out.println("ENTER key pressed");
		}
		if (key == 's') {
			//Toggle game stopped manually
			mainBoard.setPlayingGame(!(mainBoard.isPlayingGame()));
		}
		if (key == 'f') {
			System.out.println("Fire sent");
			((LaserCannon)(mainBoard.getTile(0, 0).getPiece())).fire();
		}
		if (keyCode == ESC) {
			System.out.println("Quit with ESC");
			stop();
		}
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { laserchess.LaserChess.class.getName() });
	}
}