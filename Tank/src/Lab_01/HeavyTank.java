package Lab_01;

import java.awt.Color;
import java.awt.Graphics;

public class HeavyTank extends LightTank {

	private static final int carWidth = 100;

	private static final int carHeight = 60;

	// Дополнительный цвет
	private Color DopColor;

	public Color getDopColor() {
		return DopColor;
	}

	public void setDopColor(Color value) {
		DopColor = value;
	}

	// Признак наличия первого дула
	private boolean FirstMuzzle;

	public boolean getFirstMuzzle() {
		return FirstMuzzle;
	}

	public void setFirstMuzzle(boolean value) {
		FirstMuzzle = value;
	}

	// Признак наличия второго дула
	private boolean SecondMuzzle;

	public boolean getSecondMuzzle() {
		return SecondMuzzle;
	}

	public void setSecondMuzzle(boolean value) {
		SecondMuzzle = value;
	}

	// Конструктор
	public HeavyTank(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean firstMuzzle,
			boolean secondMuzzle) {
		super(maxSpeed, weight, mainColor);

		DopColor = dopColor;
		FirstMuzzle = firstMuzzle;
		SecondMuzzle = secondMuzzle;
	}

	@Override
	public void DrawTank(Graphics g) {
		super.DrawTank(g);
		g.setColor(getDopColor());
		
		// дуло
		if (FirstMuzzle) {
			g.fillRect((int) _startPosX + 10, (int) _startPosY + 12, 40, 3);
		}
		
		if (SecondMuzzle) {
			g.fillRect((int) _startPosX + 8, (int) _startPosY + 17, 40, 3);
		}
	}
}
