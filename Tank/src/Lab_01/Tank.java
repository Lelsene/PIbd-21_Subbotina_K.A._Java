package Lab_01;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	// Левая координата отрисовки танка
	private float _startPosX;
	// Правая кооридната отрисовки танка
	private float _startPosY;
	// Ширина окна отрисовки
	private int _pictureWidth;
	// Высота окна отрисовки
	private int _pictureHeight;
	// Ширина отрисовки танка
	private static final int carWidth = 100;
	// Высота отрисовки танка
	private static final int carHeight = 60;

	// Максимальная скорость
	private int MaxSpeed;

	public int getMaxSpeed() {
		return MaxSpeed;
	}

	public void setMaxSpeed(int value) {
		MaxSpeed = value;
	}

	// Вес танка
	private float Weight;

	public float getWeight() {
		return Weight;
	}

	public void setWeight(float value) {
		Weight = value;
	}

	// Основной цвет кузова
	private Color MainColor;

	public Color getMainColor() {
		return MainColor;
	}

	public void setMainColor(Color value) {
		MainColor = value;
	}

	// Дополнительный цвет
	private Color DopColor;

	public Color getAddColor() {
		return DopColor;
	}

	public void setAddColor(Color value) {
		DopColor = value;
	}

	public Tank(int maxSpeed, float weight, Color mainColor, Color dopColor) {
		MaxSpeed = maxSpeed;
		Weight = weight;
		MainColor = mainColor;
		DopColor = dopColor;
	}

	public void setPosition(int x, int y, int width, int height) throws Exception {
		_startPosX = x;
		_startPosY = y;
		_pictureWidth = width;
		_pictureHeight = height;
	}

	public void moveTank(Direction direction) throws Exception {
		float step = getMaxSpeed() * 100 / getWeight();
		switch (direction) {
		case Right:
			// вправо
			if (_startPosX + step < _pictureWidth - carWidth) {
				_startPosX += step;
			}
			break;
		case Left:
			// влево
			if (_startPosX - step > 5) {
				_startPosX -= step;
			}
			break;
		case Up:
			// вверх
			if (_startPosY - step > 30) {
				_startPosY -= step;
			}
			break;
		case Down:
			// вниз
			if (_startPosY + step < _pictureHeight - carHeight) {
				_startPosY += step;
			}
			break;
		}
	}

	public void drawTank(Graphics g) throws Exception {
		g.setColor(DopColor);
		// нижняя основа
		g.fillRect((int) _startPosX + 13, (int) _startPosY + 40, 75, 15);
		// верхняя основа
		g.fillRect((int) _startPosX + 30, (int) _startPosY + 23, 40, 20);
		g.fillRect((int) _startPosX + 40, (int) _startPosY + 8, 20, 15);

		g.setColor(MainColor);
		// дуло
		g.fillRect((int) _startPosX + 10, (int) _startPosY + 12, 40, 3);
		// колеса
		g.drawLine((int) _startPosX + 10, (int) _startPosY + 40, (int) _startPosX + 90, (int) _startPosY + 40);
		g.drawArc((int) _startPosX + 10, (int) _startPosY + 35, 80, 20, 180, 180);
		g.drawOval((int) _startPosX + 15, (int) _startPosY + 41, 10, 10);
		g.drawOval((int) _startPosX + 25, (int) _startPosY + 43, 10, 10);
		g.drawOval((int) _startPosX + 35, (int) _startPosY + 44, 10, 10);
		g.drawOval((int) _startPosX + 45, (int) _startPosY + 44, 10, 10);
		g.drawOval((int) _startPosX + 55, (int) _startPosY + 44, 10, 10);
		g.drawOval((int) _startPosX + 65, (int) _startPosY + 43, 10, 10);
		g.drawOval((int) _startPosX + 75, (int) _startPosY + 41, 10, 10);
	}
}
