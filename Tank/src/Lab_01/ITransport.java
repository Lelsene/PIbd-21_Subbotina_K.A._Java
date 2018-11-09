package Lab_01;

import java.awt.Graphics;
import java.awt.Graphics2D;

public interface ITransport {

	void SetPosition(int x, int y, int width, int height);

	void MoveTank(Direction direction);

	void DrawTank(Graphics g);

}
