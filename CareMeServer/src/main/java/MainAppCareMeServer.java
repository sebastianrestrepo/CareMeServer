import processing.core.PApplet;

public class MainAppCareMeServer extends PApplet {

	Logic log;

	public static void main(String[] args) {
		PApplet.main("MainAppCareMeServer");
	}

	@Override
	public void settings() {
		fullScreen();
	}

	@Override
	public void setup() {
		imageMode(CENTER);
		log = new Logic(this);
	}

	@Override
	public void draw() {
		log.display();
	}

	@Override
	public void mouseReleased() {
		log.click();
		System.out.println("Mouse X: " + mouseX + "Mouse Y: " + mouseY);
	}
	
	@Override
	public void keyReleased() {
		log.key();
	}

}
