package Lab_01;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

public class Garage<T extends ITransport> {

	HashMap<Integer, T> places;

	private int maxCount;

	private int pictureWidth;

	private int pictureHeight;

	private int placeSizeWidth = 210;

	private int placeSizeHeight = 80;

	public Garage(int size, int pictureWidth, int pictureHeight) {
		maxCount = size;
		places = new HashMap<Integer, T>(size);
		this.pictureWidth = pictureWidth;
		this.pictureHeight = pictureHeight;
	}

	public int addTank(T tank) {
		if (places.size() == maxCount) {
			return -1;
		}
		for (int i = 0; i < maxCount; i++) {
			if (checkFreePlace(i)) {
				places.put(i, tank);
				places.get(i).SetPosition(10 + i / 5 * placeSizeWidth + 5, i % 5 * placeSizeHeight + 15, pictureWidth,
						pictureHeight);
				return i;
			}
		}
		return -1;
	}

	public T removeTank(int index) {
		if (!checkFreePlace(index)) {
			T tank = places.get(index);
			places.remove(index);
			return tank;
		}
		return null;
	}

	private boolean checkFreePlace(int index) {
		return !places.containsKey(index);
	}

	public void Draw(Graphics g) {
		DrawMarking(g);
		for (T i : places.values()) {
			i.DrawTank(g);
		}
	}

	private void DrawMarking(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, (maxCount / 5) * placeSizeWidth, 480);
		for (int i = 0; i < maxCount / 5; i++) {
			for (int j = 0; j < 6; ++j) {
				g.drawLine(i * placeSizeWidth, j * placeSizeHeight, i * placeSizeWidth + 110, j * placeSizeHeight);
			}
			g.drawLine(i * placeSizeWidth, 0, i * placeSizeWidth, 400);
		}
	}
}