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

	public HeavyTank(int maxSpeed, int weight, Color mainColor, Color dopColor, boolean firstMuzzle,
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
			Weight = Integer.parseInt(str[1]);
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

	public int compareTo(HeavyTank another) {
		if (another == null) {
			return 1;
		}
		if (MaxSpeed != another.MaxSpeed) {
			return Integer.valueOf(MaxSpeed).compareTo(another.MaxSpeed);
		}
		if (Weight != another.Weight) {
			return Integer.valueOf(Weight).compareTo(another.Weight);
		}
		if (MainColor != another.MainColor) {
			return Integer.valueOf(MainColor.getRGB()).compareTo(another.MainColor.getRGB());
		}
		if (DopColor != another.DopColor) {
			return Integer.valueOf(DopColor.getRGB()).compareTo(another.DopColor.getRGB());
		}
		if (FirstMuzzle != another.FirstMuzzle) {
			return Boolean.valueOf(FirstMuzzle).compareTo(another.FirstMuzzle);
		}
		if (SecondMuzzle != another.SecondMuzzle) {
			return Boolean.valueOf(SecondMuzzle).compareTo(another.SecondMuzzle);
		}
		return 0;
	}

	@Override
	public boolean equals(Object another) {
		if (another == null) {
			return false;
		}
		if (!(another instanceof HeavyTank)) {
			return false;
		}
		HeavyTank tank = (HeavyTank) another;
		return equals(tank);
	}

	public boolean equals(HeavyTank another) {
		if (another == null) {
			return false;
		}
		if (MaxSpeed != another.MaxSpeed) {
			return false;
		}
		if (Weight != another.Weight) {
			return false;
		}
		if (MainColor != another.MainColor) {
			return false;
		}
		if (DopColor != another.DopColor) {
			return false;
		}
		if (FirstMuzzle != another.FirstMuzzle) {
			return false;
		}
		if (SecondMuzzle != another.SecondMuzzle) {
			return false;
		}
		return true;
	}

}