import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

import processing.core.PApplet;
import processing.serial.Serial;

public class ArduinoConection extends Thread {

	private PApplet app;
	private Serial port;
	private int humidity;
	private SerialPort[] ports = SerialPort.getCommPorts();
	SerialPort serialPort;
	int chosenPort;
	private Scanner s;
	private 	int value;
	
	public ArduinoConection(PApplet app) {
		this.app = app;
		//port = new Serial(app, Serial.list()[2], 9600);
		/*
		System.out.println("Select a port:");
		int i = 1;
		for (SerialPort port : ports)
			System.out.println(i++ + ": " + port.getSystemPortName());

		s = new Scanner(System.in);
		
		chosenPort = s.nextInt();
*/
		serialPort = ports[5];
		if (serialPort.openPort())
			System.out.println("Port opened successfully.");
		else {
			System.out.println("Unable to open the port.");
			return;
		}

	}
	
	@Override
	public void run() {
		while(true) {
			try {
				readData();
				sleep(66);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void readData() {

		// serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
		//serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 0, 0);

		Scanner data = new Scanner(serialPort.getInputStream());

		while (data.hasNextLine()) {
			try {
				value = Integer.parseInt(data.nextLine());
			} catch (Exception e) {
			}

		}
		humidity = value;
		System.out.println("value is: " + value);

	}

	public void read() {
		//if (port.available() > 0) {
			// if (port.read() != 13 && port.read() != -1) {
			//humidity = port.read();
			// }
			//System.out.print("Arduino dice:" + humidity + "\n");
		//}
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

}
