package Lab_01;

import java.awt.Graphics;

import javax.swing.JPanel;

public class JPanelDraw extends JPanel {

	private ITransport tank;

	public void setTransport(ITransport transport) {
		this.tank = transport;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (tank != null) {
			tank.DrawTank(g);
		}
	}
}