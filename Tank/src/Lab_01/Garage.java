package Lab_01;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Garage<T extends ITransport> {

	ArrayList<T> places;

	private int pictureWidth;

	private int pictureHeight;

	private int placeSizeWidth = 210;

	private int placeSizeHeight = 80;

	public Garage(int size, int pictureWidth, int pictureHeight) {
		places = new ArrayList<T>(size);
		this.pictureWidth = pictureWidth;
		this.pictureHeight = pictureHeight;
		for (int i = 0; i < size; i++) {
			places.add(null);
		}
	}

	public int addTank(T tank) {
		for (int i = 0; i < places.size(); i++) {
			if (checkFreePlace(i)) {
				places.add(i, tank);
				places.get(i).SetPosition(10 + i / 5 * placeSizeWidth + 5, i % 5 * placeSizeHeight + 15, pictureWidth,
						pictureHeight);
				return i;
			}
		}
		return -1;
	}

	public T removeTank(int index) {
		if (index < 0 || index > places.size()) {
			return null;
		}
		if (!checkFreePlace(index)) {
			T ship = places.get(index);
			places.set(index, null);
			return ship;
		}
		return null;
	}

	private boolean checkFreePlace(int index) {
		return places.get(index) == null;
	}

	public void Draw(Graphics g) {
		DrawMarking(g);
		for (int i = 0; i < places.size(); i++) {
			if (!checkFreePlace(i)) {
				places.get(i).DrawTank(g);
			}
		}
	}

	private void DrawMarking(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, (places.size() / 5) * placeSizeWidth, 480);
		for (int i = 0; i < places.size() / 5; i++) {
			for (int j = 0; j < 6; ++j) {
				g.drawLine(i * placeSizeWidth, j * placeSizeHeight, i * placeSizeWidth + 110, j * placeSizeHeight);
			}
			g.drawLine(i * placeSizeWidth, 0, i * placeSizeWidth, 400);
		}
	}
}
