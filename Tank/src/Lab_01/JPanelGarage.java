package Lab_01;

import java.awt.Graphics;

import javax.swing.JPanel;

public class JPanelGarage extends JPanel {
	private Garage<ITransport> garage;

	public void setGarage(Garage garage) {
		this.garage = garage;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		try {
			if (garage != null) {
				garage.Draw(g);
			}
		} catch (Exception ex) {
		}
	}
}
