package Lab_01;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

public class HeavyTank extends LightTank implements Serializable {

	private static final int carWidth = 100;

	private static final int carHeight = 60;

	transient private Color DopColor;

	public Color getDopColor() {
		return DopColor;
	}

	public void setDopColor(Color value) {
		DopColor = value;
	}

	private boolean FirstMuzzle;

	public boolean getFirstMuzzle() {
		return FirstMuzzle;
	}

	public void setFirstMuzzle(boolean value) {
		FirstMuzzle = value;
	}

	private boolean SecondMuzzle;

	public boolean getSecondMuzzle() {
		return SecondMuzzle;
	}

	public void setSecondMuzzle(boolean value) {
		SecondMuzzle = value;
	}

	public HeavyTank(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean firstMuzzle,
			boolean secondMuzzle) {
		super(maxSpeed, weight, mainColor);

		DopColor = dopColor;
		FirstMuzzle = firstMuzzle;
		SecondMuzzle = secondMuzzle;
	}

	public HeavyTank(String info) {
		super(info);
		String[] str = info.split(";");
		if (str.length == 10) {
			MaxSpeed = Integer.parseInt(str[0]);
			Weight = Float.parseFloat(str[1]);
			MainColor = new Color(Integer.parseInt(str[2]), Integer.parseInt(str[3]), Integer.parseInt(str[4]));
			DopColor = new Color(Integer.parseInt(str[5]), Integer.parseInt(str[6]), Integer.parseInt(str[7]));
			FirstMuzzle = Boolean.parseBoolean(str[8]);
			SecondMuzzle = Boolean.parseBoolean(str[9]);
		}
	}

	@Override
	public void DrawTank(Graphics g) {
		super.DrawTank(g);
		g.setColor(getDopColor());

		if (FirstMuzzle) {
			g.fillRect((int) _startPosX + 10, (int) _startPosY + 12, 40, 3);
		}

		if (SecondMuzzle) {
			g.fillRect((int) _startPosX + 8, (int) _startPosY + 17, 40, 3);
		}
	}

	@Override
	public String getInfo() {
		return MaxSpeed + ";" + Weight + ";" + MainColor.getRed() + ";" + MainColor.getGreen() + ";"
				+ MainColor.getBlue() + ";" + DopColor.getRed() + ";" + DopColor.getGreen() + ";" + DopColor.getBlue()
				+ ";" + FirstMuzzle + ";" + SecondMuzzle;
	}
}