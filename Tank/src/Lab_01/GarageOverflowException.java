package Lab_01;

public class GarageOverflowException extends Exception {

	public GarageOverflowException() {
		super("No free places");
	}
}
