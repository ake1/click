package click.click_core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PlayingFieldActionListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		int x = Integer.parseInt((s.split("[,]"))[0]);
		int y = Integer.parseInt((s.split("[,]"))[1]);
		PlayingField field = ((PlayingField) ((JButton) e.getSource()).getParent());
		field.reveal(x, y);
	}
}