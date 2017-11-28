import processing.core.PApplet;
import processing.core.PImage;

public class UserInterface extends Thread {

	private Logic logic;
	private PApplet app;
	private int screens = 1;
	private PImage inicio, home, datos, pausa, pausaVerde, reanudar, reanudarVerde, saludo, cerrarSesion, planta;

	public UserInterface(Logic logic, PApplet app) {
		this.logic = logic;
		this.app = app;
		load();
	}

	public void load() {
		inicio = app.loadImage("../data/inicio.png");
		home = app.loadImage("../data/home.png");
		datos = app.loadImage("../data/datos.png");
		pausa = app.loadImage("../data/pausa.png");
		pausaVerde = app.loadImage("../data/pausaVerde.png");
		reanudar = app.loadImage("../data/reanudar.png");
		reanudarVerde = app.loadImage("../data/reanudarVerde.png");
		saludo = app.loadImage("../data/saludo.png");
		planta = app.loadImage("../data/planta.png");
		cerrarSesion = app.loadImage("../data/cerrarSesion.png");
	}

	public void showHumidity() {

	}

	public void screens() {
		switch (screens) {
		case 1:
			inicio();
			break;
		case 2:
			home();
			break;
		}
	}

	public void inicio() {
		app.image(inicio, app.width / 2, app.height / 2);
	}

	public void home() {
		app.image(home, app.width / 2, app.height / 2);
	    app.image(planta, app.width/2, app.height/2+25);
	    app.image(pausa, app.width/2-493, app.height-45);
	    app.image(datos, app.width/2-290, app.height/2+25);
	}

	public void click() {
		switch (screens) {
		case 1:
			screens = 2;
			break;
		case 2:

			break;
		}
	}

	// FIN DE LA CLASE
}
