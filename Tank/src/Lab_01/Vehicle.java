package Lab_01;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Vehicle implements ITransport {

	// Левая координата отрисовки автомобиля
	protected float _startPosX;

	/// Правая кооридната отрисовки автомобиля
	protected float _startPosY;

	/// Ширина окна отрисовки
	protected int _pictureWidth;

	/// Высота окна отрисовки
	protected int _pictureHeight;

	// Максимальная скорость
	public int MaxSpeed;

	public int getMaxSpeed() {
		return MaxSpeed;
	}

	public void setMaxSpeed(int value) {
		MaxSpeed = value;
	}

	// Вес автомобиля
	public float Weight;

	public float getWeight() {
		return Weight;
	}

	public void setWeight(float value) {
		Weight = value;
	}

	// Основной цвет кузова
	public Color MainColor;

	public Color getMainColor() {
		return MainColor;
	}

	public void setMainColor(Color value) {
		MainColor = value;
	}

	public void SetPosition(int x, int y, int width, int height) {
		_startPosX = x;
		_startPosY = y;
		_pictureWidth = width;
		_pictureHeight = height;
	}

	public abstract void DrawTank(Graphics g);

	public abstract void MoveTank(Direction direction);

}
