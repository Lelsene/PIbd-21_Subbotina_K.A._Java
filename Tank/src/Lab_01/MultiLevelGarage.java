package Lab_01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MultiLevelGarage {

	ArrayList<Garage<ITransport>> garageStages;

	int currentLevel;

	private final int countPlaces = 15;

	private int pictureWidth;

	private int pictureHeight;

	public MultiLevelGarage(int countStages, int pictureWidth, int pictureHeight) {
		garageStages = new ArrayList<Garage<ITransport>>();
		for (int i = 0; i < countStages; ++i) {
			garageStages.add(new Garage<ITransport>(countPlaces, pictureWidth, pictureHeight));
		}
	}

	public Garage<ITransport> getGarage(int index) {
		if (index > -1 && index < garageStages.size()) {
			return garageStages.get(index);
		}
		return null;
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public boolean levelUp() {
		if (currentLevel + 1 < garageStages.size()) {
			currentLevel++;
			return true;
		}
		return false;
	}

	public boolean levelDown() {
		if (currentLevel > 0) {
			currentLevel--;
			return true;
		}
		return false;
	}

	public boolean save(String filename) {
		File file = new File(filename);
		if (file.exists()) {
			file.delete();
		}
		try (FileOutputStream fileStream = new FileOutputStream(file)) {
			try (BufferedOutputStream bs = new BufferedOutputStream(fileStream)) {
				String str = "CountLeveles:" + garageStages.size() + System.lineSeparator();
				ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
				for (int i = 0; i < str.length(); i++) {
					byteOut.write(str.charAt(i));
				}
				byte[] info = byteOut.toByteArray();
				fileStream.write(info, 0, info.length);
				for (Garage<ITransport> level : garageStages) {
					byteOut = new ByteArrayOutputStream();
					str = "Level" + System.lineSeparator();

					for (int i = 0; i < str.length(); i++) {
						byteOut.write(str.charAt(i));
					}
					info = byteOut.toByteArray();
					fileStream.write(info, 0, info.length);

					for (int i = 0; i < countPlaces; i++) {
						ITransport tank = level.getTank(i);
						if (tank != null) {
							byteOut = new ByteArrayOutputStream();
							String tankInfo = tank.getClass().getName() + ":" + tank.getInfo() + System.lineSeparator();
							tankInfo = tankInfo.substring(7);
							for (int j = 0; j < tankInfo.length(); j++) {
								byteOut.write(tankInfo.charAt(j));
							}
							info = byteOut.toByteArray();
							fileStream.write(info, 0, info.length);
						}
					}
				}
			}
			fileStream.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public boolean load(String filename)
			throws GarageOverflowException, GarageOccupiedPlaceException, GarageAlreadyHaveException {
		File file = new File(filename);
		if (!file.exists()) {
			return false;
		}
		try (FileInputStream fileStream = new FileInputStream(filename)) {
			String s = "";
			try (BufferedInputStream bs = new BufferedInputStream(fileStream)) {
				Path path = Paths.get(file.getAbsolutePath());
				byte[] b = new byte[fileStream.available()];
				b = Files.readAllBytes(path);
				ByteArrayInputStream bos = new ByteArrayInputStream(b);
				String value = new String(b, StandardCharsets.UTF_8);
				while (bos.read(b, 0, b.length) > 0) {
					s += value;
				}
				s = s.replace("\r", "");
				String[] strs = s.split("\n");
				if (strs[0].contains("CountLeveles")) {
					if (garageStages != null) {
						garageStages.clear();
					}
					garageStages = new ArrayList<Garage<ITransport>>();
				} else {
					return false;
				}
				int counter = -1;
				for (int i = 0; i < strs.length; i++) {
					if (strs[i].startsWith("Level")) {
						counter++;
						garageStages.add(new Garage<ITransport>(countPlaces, pictureWidth, pictureHeight));
					} else if (strs[i].startsWith("LightTank")) {
						ITransport tank = new LightTank(strs[i].split(":")[1]);
						int number = garageStages.get(counter).addTank(tank);
						if (number == -1) {
							return false;
						}
					} else if (strs[i].startsWith("HeavyTank")) {
						ITransport tank = new HeavyTank(strs[i].split(":")[1]);
						int number = garageStages.get(counter).addTank(tank);
						if (number == -1) {
							return false;
						}
					}
				}
			}
			return true;
		} catch (IOException ex) {
			return false;
		}
	}

	public void Sort() {
		garageStages.sort(null);
	}
}