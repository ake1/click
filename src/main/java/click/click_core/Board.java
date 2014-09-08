package click.click_core;

import java.util.ArrayList;
import java.util.Random;

public class Board {
	private Cell[][] cells;

	private int height, width, numberOfMines;

	public Cell[][] getCells() {
		return cells;
	}

	Board(int h, int w, int mines) {
		this.height = h;
		this.width = w;
		this.numberOfMines = mines;
		this.cells = new Cell[h][w];
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				cells[i][j] = new Cell(i, j);
			}
		}
		generateMines();
		generateNumbers();
	}

	private void generateNumbers() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (cells[i][j].isMined()) {
					ArrayList<Cell> neighbours = getNeighbours(i, j);
					for (int k = 0; k < neighbours.size(); k++) {
						neighbours.get(k).incrementAdjacent();
					}
				}
			}
		}
	}

	public ArrayList<Cell> getNeighbours(int h, int w) {
		ArrayList<Cell> neighbours = new ArrayList<Cell>();
		// top
		if (h > 0) {
			neighbours.add(cells[h - 1][w]);
		}
		// bottom
		if (h < this.height - 1) {
			neighbours.add(cells[h + 1][w]);
		}
		// left
		if (w > 0) {
			neighbours.add(cells[h][w - 1]);
		}
		// right
		if (w < this.width - 1) {
			neighbours.add(cells[h][w + 1]);
		}
		// top left
		if (h > 0 && w > 0) {
			neighbours.add(cells[h - 1][w - 1]);
		}
		// top right
		if (h > 0 && w < this.width - 1) {
			neighbours.add(cells[h - 1][w + 1]);
		}
		// bottom left
		if (h < this.height - 1 && w > 0) {
			neighbours.add(cells[h + 1][w - 1]);
		}
		// bottom right
		if (h < this.height - 1 && w < this.width - 1) {
			neighbours.add(cells[h + 1][w + 1]);
		}

		return neighbours;
	}

	private void generateMines() {
		int total = 0;
		while (total < numberOfMines) {
			int h = randInt(0, height - 1);
			int w = randInt(0, width - 1);
			if (!cells[h][w].isMined()) {
				cells[h][w].setMined(true);
				System.out.println("mined: " + h + ", " + w);
				total++;
			}
		}
	}

	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public void writeTextRepresentation() {
		String a = "";
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				if (cells[i][j].isMined()) {
					a += "X";
				} else {
					a += cells[i][j].getAdjacent();
				}
			}
			a += "\n";
		}
		System.out.println(a);
	}
}