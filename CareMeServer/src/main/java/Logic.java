import processing.core.PApplet;

public class Logic {

	private PApplet app;
	private UserInterface ui;
	private ArduinoConection a;
	private Firebase f;
	
	public Logic(PApplet app) {
		this.app = app;
	}
	
	public void display() {
		
	}

	//GETTERS AND SETTERS
	public UserInterface getUi() {
		return ui;
	}

	public void setUi(UserInterface ui) {
		this.ui = ui;
	}

	public ArduinoConection getA() {
		return a;
	}

	public void setA(ArduinoConection a) {
		this.a = a;
	}

	public Firebase getF() {
		return f;
	}

	public void setF(Firebase f) {
		this.f = f;
	}
	
}
