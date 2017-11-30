import processing.core.PApplet;

public class Logic {

	private PApplet app;
	private UserInterface ui;
	private ArduinoConection a;
	private Firebase f;
	private int screens = 1;

	public Logic(PApplet app) {
		this.app = app;
		ui = new UserInterface(this, app);
		ui.start();
		a = new ArduinoConection(app);
		a.start();
	}

	public void display() {
		screens();
		a.read();
	}

	public void screens() {
		switch (screens) {
		case 1:
			ui.inicio();
			break;
		case 2:
			ui.home();
			ui.showHumidity();
			break;
		}
	}

	public void click() {
		
		switch (screens) {
		case 1:
			if (app.mouseX > 525 && app.mouseX < 728 && app.mouseY > 627 && app.mouseY < 661) {
				screens = 2;
				f = new Firebase(app, this);
				f.initiateProject();
				f.start();
			}
			break;
		case 2:
			ui.playButton();
			ui.click();
			break;
		}
		
	}

	public void key() {
		switch (screens) {
		case 1:
			if(app.key == app.ENTER) {
				screens = 2;
				f = new Firebase(app, this);
				f.initiateProject();
				f.start();
			}
			break;
		}
	}

	// GETTERS AND SETTERS
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
