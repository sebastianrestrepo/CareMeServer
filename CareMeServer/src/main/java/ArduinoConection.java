import processing.core.PApplet;
import processing.serial.Serial;

public class ArduinoConection {

	private PApplet app;
	private Serial puerto;

	public ArduinoConection(PApplet app) {
		this.app = app;
		puerto = new Serial(app, Serial.list()[2], 9600);
	}

	public void read() {
		if (puerto.available() > 0) {
			int humidity = puerto.read();
			//System.out.print("Arduino dice:" + humidity +"\n");
		}
	}
	
	public void serialEvent(Serial s) {
		/*
		if (puerto.available() > 0) {
			int humidity = s.read();
			System.out.print("Arduino dice:" + humidity);
		}
		*/
	}

}
