package Lab_01;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class JPanelDraw extends JPanel {

	private ITransport tank;

	public void setTransport(ITransport tank) {
		this.tank = tank;
	}

	public void paint(Graphics2D g) {
		super.paint(g);
		if (tank != null) {
			tank.DrawTank(g);
		}
	}
}
