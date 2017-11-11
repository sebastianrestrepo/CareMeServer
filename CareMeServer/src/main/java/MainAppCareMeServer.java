import processing.core.PApplet;

public class MainAppCareMeServer extends PApplet {

	Logic log;

	public static void main(String[] args) {
		PApplet.main("MainAppCareMeServer");
	}

	@Override
	public void settings() {
		size(1200, 700);
	}

	@Override
	public void setup() {
		log = new Logic(this);
	}

}
