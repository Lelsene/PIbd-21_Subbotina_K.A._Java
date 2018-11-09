package Lab_01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class LightTank extends Vehicle {

	// Ширина отрисовки танка
	protected final int carWidth = 100;

	// Высота отрисовки танка
	protected final int carHeight = 60;

	// Конструктор
	public LightTank(int maxSpeed, float weight, Color mainColor) {
		MaxSpeed = maxSpeed;
		Weight = weight;
		MainColor = mainColor;
	}

	@Override
	public void MoveTank(Direction direction) {
		float step = getMaxSpeed() * 100 / getWeight();
		switch (direction) {
		// вправо
		case Right:
			if (_startPosX + step < _pictureWidth - carWidth) {
				_startPosX += step;
			}
			break;
		// влево
		case Left:
			if (_startPosX - step > 0) {
				_startPosX -= step;
			}
			break;
		// вверх
		case Up:
			if (_startPosY - step > 0) {
				_startPosY -= step;
			}
			break;
		// вниз
		case Down:
			if (_startPosY + step < _pictureHeight - carHeight) {
				_startPosY += step;
			}
			break;
		}
	}
	
	public void DrawTank(Graphics g) {
		g.setColor(getMainColor());
		
		//нижняя основа
		g.fillRect((int)_startPosX + 13, (int)_startPosY + 40, 75, 15);
        //верхняя
        g.fillRect((int)_startPosX + 30, (int)_startPosY + 23, 40, 20);
        g.fillRect((int)_startPosX + 40, (int)_startPosY + 8, 20, 15);
        
        g.setColor(Color.black);
        g.drawLine((int)_startPosX + 10, (int)_startPosY + 40, (int)_startPosX + 90, (int)_startPosY + 40);
        g.drawArc((int)_startPosX + 10, (int)_startPosY + 35, 80, 20, 180, 180);
        //колеса
        g.drawOval((int)_startPosX + 15, (int)_startPosY + 40, 10, 10);
        g.drawOval((int)_startPosX + 25, (int)_startPosY + 42, 10, 10);
        g.drawOval((int)_startPosX + 35, (int)_startPosY + 43, 10, 10);
        g.drawOval((int)_startPosX + 45, (int)_startPosY + 44, 10, 10);
        g.drawOval((int)_startPosX + 55, (int)_startPosY + 44, 10, 10);
        g.drawOval((int)_startPosX + 65, (int)_startPosY + 42, 10, 10);
        g.drawOval((int)_startPosX + 75, (int)_startPosY + 40, 10, 10);
	}
}
