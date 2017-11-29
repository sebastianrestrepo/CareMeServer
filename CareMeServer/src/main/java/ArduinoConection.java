import processing.core.PApplet;
import processing.serial.Serial;

public class ArduinoConection {

	private PApplet app;
	private Serial port;
	private int humidity;

	public ArduinoConection(PApplet app) {
		this.app = app;
		port = new Serial(app, Serial.list()[2], 9600);
	}

	public void read() {
		if (port.available() > 0) {
			//if (port.read() != 13 && port.read() != -1) {
				humidity = port.read();
			//}
			 System.out.print("Arduino dice:" + humidity + "\n");
		}
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

}
