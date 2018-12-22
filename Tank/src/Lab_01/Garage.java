package Lab_01;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

public class Garage<T extends ITransport> implements Serializable, Comparable<Garage<T>>, Iterable<T>, Iterator<T> {

	HashMap<Integer, T> places;

	private int maxCount;

	private int pictureWidth;

	private int pictureHeight;

	private int placeSizeWidth = 210;

	private int placeSizeHeight = 80;

	private int currentIndex;

	public Garage(int size, int pictureWidth, int pictureHeight) {
		maxCount = size;
		places = new HashMap<Integer, T>(size);
		this.pictureWidth = pictureWidth;
		this.pictureHeight = pictureHeight;
	}

	public int addTank(T tank)
			throws GarageOverflowException, GarageOccupiedPlaceException, GarageAlreadyHaveException {
		if (this.places.size() == this.maxCount) {
			throw new GarageOverflowException();
		}
		int index = places.size();
		for (int i = 0; i <= places.size(); i++) {
			if (checkFreePlace(i))
				index = i;
			if (places.containsValue(tank))
				throw new GarageAlreadyHaveException();
		}
		if (index != places.size()) {
			places.put(index, tank);
			places.get(index).SetPosition(10 + index / 5 * placeSizeWidth + 5, index % 5 * placeSizeHeight + 15,
					pictureWidth, pictureHeight);
			return index;
		}
		places.put(this.places.size(), tank);
		places.get(index).SetPosition(10 + index / 5 * placeSizeWidth + 5, index % 5 * placeSizeHeight + 15,
				pictureWidth, pictureHeight);
		return this.places.size() - 1;
	}

	public T removeTank(int index) throws GarageNotFoundException {
		if (!checkFreePlace(index)) {
			T tank = places.get(index);
			places.remove(index);
			return tank;
		}
		throw new GarageNotFoundException();
	}

	private boolean checkFreePlace(int index) {
		return !places.containsKey(index);
	}

	public T getTank(int index) {
		if (places.get(index) != null) {
			return places.get(index);
		} else {
			return null;
		}
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

	@Override
	public int compareTo(Garage<T> other) {
		if (this.places.size() > other.places.size()) {
			return -1;
		} else if (this.places.size() < other.places.size()) {
			return 1;
		} else {
			Integer[] thisKeys = this.places.keySet().toArray(new Integer[this.places.size()]);
			Integer[] otherKeys = other.places.keySet().toArray(new Integer[other.places.size()]);
			for (int i = 0; i < this.places.size(); i++) {
				if (this.places.get(thisKeys[i]).getClass().equals(LightTank.class)
						&& other.places.get(otherKeys[i]).getClass().equals(HeavyTank.class)) {
					return 1;
				}
				if (this.places.get(thisKeys[i]).getClass().equals(HeavyTank.class)
						&& other.places.get(otherKeys[i]).getClass().equals(LightTank.class)) {
					return -1;
				}
				if (this.places.get(thisKeys[i]).getClass().equals(LightTank.class)
						&& other.places.get(otherKeys[i]).getClass().equals(LightTank.class)) {
					return ((LightTank) this.places.get(thisKeys[i]))
							.compareTo((LightTank) other.places.get(otherKeys[i]));
				}
				if (this.places.get(thisKeys[i]).getClass().equals(HeavyTank.class)
						&& other.places.get(otherKeys[i]).getClass().equals(HeavyTank.class)) {
					return ((HeavyTank) this.places.get(thisKeys[i]))
							.compareTo((HeavyTank) other.places.get(otherKeys[i]));
				}
			}
		}
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		if (currentIndex + 1 >= places.size()) {
			currentIndex = -1;
			return false;
		}
		currentIndex++;
		return true;
	}

	@Override
	public T next() {
		return (T) places.get(currentIndex);
	}

	private void reset() {
		currentIndex = -1;
	}
}