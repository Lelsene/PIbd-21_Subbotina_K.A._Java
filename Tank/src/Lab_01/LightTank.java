package Lab_01;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

public class LightTank extends Vehicle implements Serializable {

	protected final int carWidth = 100;

	protected final int carHeight = 60;

	public LightTank(int maxSpeed, float weight, Color mainColor) {
		MaxSpeed = maxSpeed;
		Weight = weight;
		MainColor = mainColor;
	}

	public LightTank(String info) {
		String[] str = info.split(";");
		if (str.length == 5) {
			MaxSpeed = Integer.parseInt(str[0]);
			Weight = Float.parseFloat(str[1]);
			MainColor = new Color(Integer.parseInt(str[2]), Integer.parseInt(str[3]), Integer.parseInt(str[4]));
		}
	}

	@Override
	public void MoveTank(Direction direction) {
		float step = getMaxSpeed() * 100 / getWeight();
		switch (direction) {
		case Right:
			if (_startPosX + step < _pictureWidth - carWidth) {
				_startPosX += step;
			}
			break;
		case Left:
			if (_startPosX - step > 0) {
				_startPosX -= step;
			}
			break;
		case Up:
			if (_startPosY - step > 0) {
				_startPosY -= step;
			}
			break;
		case Down:
			if (_startPosY + step < _pictureHeight - carHeight) {
				_startPosY += step;
			}
			break;
		}
	}

	@Override
	public void DrawTank(Graphics g) {
		g.setColor(getMainColor());

		g.fillRect((int) _startPosX + 13, (int) _startPosY + 40, 75, 15);
		g.fillRect((int) _startPosX + 30, (int) _startPosY + 23, 40, 20);
		g.fillRect((int) _startPosX + 40, (int) _startPosY + 8, 20, 15);

		g.setColor(Color.black);
		g.drawLine((int) _startPosX + 10, (int) _startPosY + 40, (int) _startPosX + 90, (int) _startPosY + 40);
		g.drawArc((int) _startPosX + 10, (int) _startPosY + 35, 80, 20, 180, 180);
		g.drawOval((int) _startPosX + 15, (int) _startPosY + 40, 10, 10);
		g.drawOval((int) _startPosX + 25, (int) _startPosY + 42, 10, 10);
		g.drawOval((int) _startPosX + 35, (int) _startPosY + 43, 10, 10);
		g.drawOval((int) _startPosX + 45, (int) _startPosY + 44, 10, 10);
		g.drawOval((int) _startPosX + 55, (int) _startPosY + 44, 10, 10);
		g.drawOval((int) _startPosX + 65, (int) _startPosY + 42, 10, 10);
		g.drawOval((int) _startPosX + 75, (int) _startPosY + 40, 10, 10);
	}

	@Override
	public String getInfo() {
		return MaxSpeed + ";" + Weight + ";" + MainColor.getRed() + ";" + MainColor.getGreen() + ";"
				+ MainColor.getBlue();
	}
}