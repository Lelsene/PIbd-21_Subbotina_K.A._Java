package Lab_01;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Vehicle implements ITransport {

	protected float _startPosX;

	protected float _startPosY;

	protected int _pictureWidth;

	protected int _pictureHeight;

	public int MaxSpeed;

	public int getMaxSpeed() {
		return MaxSpeed;
	}

	public void setMaxSpeed(int value) {
		MaxSpeed = value;
	}

	public float Weight;

	public float getWeight() {
		return Weight;
	}

	public void setWeight(float value) {
		Weight = value;
	}

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