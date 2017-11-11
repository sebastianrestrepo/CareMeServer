import processing.core.PApplet;

public class UserInterface extends Thread {

	private Logic logic;
	private PApplet app;
	private int screens;
	
	public UserInterface(Logic logic, PApplet app) {
		this.logic = logic;
		this.app = app;
	}
	
	public void showHumidity() {
		
	}
	
	public void screens() {
		switch(screens) {
		
		}
	}
	
}
