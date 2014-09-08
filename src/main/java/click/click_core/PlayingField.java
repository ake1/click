package click.click_core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PlayingField extends JPanel {
	public JButton[][] playingFieldButtons;
	public int[][] playingField;
	private Board board;
	private int height, width;

	public PlayingField(int h, int w) {
		super(new GridLayout(h, w));
		this.height = h;
		this.width = w;
		board = new Board(this.height, this.width, 15);
		board.writeTextRepresentation();
		playingFieldButtons = new JButton[this.height][this.width];
		playingField = new int[this.height][this.width];
		setPreferredSize(new Dimension(this.height * 50, this.width * 50));
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				playingFieldButtons[i][j] = new JButton();
				playingFieldButtons[i][j].setBackground(Color.GRAY);
				playingField[i][j] = 0;
				playingFieldButtons[i][j].setSize(new Dimension(5, 5));
				playingFieldButtons[i][j].setActionCommand(Integer.toString(i)
						+ "," + Integer.toString(j));
				playingFieldButtons[i][j]
						.addActionListener(new PlayingFieldActionListener());
				this.add(playingFieldButtons[i][j]);
			}
		}
	}

	public boolean reveal(int h, int w) {
		Cell[][] c = board.getCells();

		if (h < 0 || h >= this.height || w < 0 || w >= this.width
				|| c[h][w].isSeen())
			return true;

		c[h][w].setSeen(true);

		String s = "";
		if (c[h][w].isMined()) {
			s = "X";
			playingFieldButtons[h][w].setText(s);
			gameOver();
			return false; // hit a mine.
		} else {
			s = Integer.toString(c[h][w].getAdjacent());
			playingFieldButtons[h][w].setText(s);
			playingFieldButtons[h][w].setBackground(Color.LIGHT_GRAY);
			;
			playingFieldButtons[h][w].setEnabled(false);
			if (c[h][w].getAdjacent() == 1) {
				playingFieldButtons[h][w].setBackground(Color.blue);
			}
			if (c[h][w].getAdjacent() == 2) {
				playingFieldButtons[h][w].setBackground(Color.green);
			}
			if (c[h][w].getAdjacent() == 3) {
				playingFieldButtons[h][w].setBackground(Color.red);
			}
			if (c[h][w].getAdjacent() == 4) {
				playingFieldButtons[h][w].setBackground(Color.CYAN);
			}
			if (c[h][w].getAdjacent() == 5) {
				playingFieldButtons[h][w].setBackground(Color.magenta);
			}
			if (c[h][w].getAdjacent() == 6) {
				playingFieldButtons[h][w].setBackground(Color.DARK_GRAY);
			}
			if (c[h][w].getAdjacent() == 0) {
				playingFieldButtons[h][w].setText("");
				reveal(h - 1, w - 1);
				reveal(h - 1, w);
				reveal(h - 1, w + 1);
				reveal(h, w - 1);
				reveal(h, w + 1);
				reveal(h + 1, w - 1);
				reveal(h + 1, w);
				reveal(h + 1, w + 1);
			}
			return true;
		}
	}

	private void gameOver() {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				// tbd
			}
		}
	}
}