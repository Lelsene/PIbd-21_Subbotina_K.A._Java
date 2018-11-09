package Lab_01;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JList;
import javax.swing.JPanel;

public class JPanelGarage extends JPanel {

	private MultiLevelGarage garage;

	private JList list;

	public void setGarage(MultiLevelGarage garage) {
		this.garage = garage;
	}

	public void setList(JList list) {
		this.list = list;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		try {
			if (garage != null) {
				if (list.getSelectedIndex() != -1) {
					garage.getGarage(list.getSelectedIndex()).Draw(g);
				}
			}
		} catch (Exception ex) {
		}
	}

}
