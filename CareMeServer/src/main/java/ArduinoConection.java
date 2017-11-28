import processing.core.PApplet;
import processing.serial.Serial;

public class ArduinoConection {

	private PApplet app;
	private Serial puerto;
	
	public ArduinoConection(PApplet app) {
		this.app = app;
	}
	
}
