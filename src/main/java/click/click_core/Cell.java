package click.click_core;

public class Cell {
	private boolean mined, seen, visited;
	private int x, y, adjacent;

	public Cell(int i, int j) {
		x = i;
		y = j;
		mined = false;
		seen = false;
		visited = false;
		adjacent = 0;
	}

	public boolean isMined() {
		return mined;
	}

	public void setMined(boolean mined) {
		this.mined = mined;
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public int getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(int number) {
		this.adjacent = number;
	}

	public void incrementAdjacent() {
		this.adjacent++;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}
