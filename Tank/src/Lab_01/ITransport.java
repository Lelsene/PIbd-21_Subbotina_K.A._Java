package Lab_01;

import java.awt.Color;
import java.awt.Graphics;

public interface ITransport {

	void SetPosition(int x, int y, int width, int height);

	void MoveTank(Direction direction);

	void DrawTank(Graphics g);

	void setMainColor(Color color);

	String getInfo();
}