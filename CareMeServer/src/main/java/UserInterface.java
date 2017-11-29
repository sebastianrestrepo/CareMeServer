import controlP5.ControlP5;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class UserInterface extends Thread {

	private Logic logic;
	private PApplet app;
	private int screens = 1;
	private PImage inicio, home, datos, pausa, pausaVerde, reanudar, reanudarVerde, saludo, cerrarSesion, planta;
	private PImage[] intro;
	private PFont pnBold, pnRegular, pnRegularBig;
	private int frameIntro;
	private int humidity = 127;
	private boolean live = true;
	private boolean play;
	private boolean loaded = false;
	private String projectName = "";
	private int num;
	private ControlP5 cp5;

	public UserInterface(Logic logic, PApplet app) {
		this.logic = logic;
		this.app = app;
		load();
		cp5 = new ControlP5(app);
				
		pnRegular = app.createFont("../data/Proxima Nova Regular.ttf", 18);
		pnRegularBig = app.createFont("../data/Proxima Nova Regular.ttf", 42);
		
		textField();
	}

	public void run() {
		while (live) {
			try {
				sleep(99);

				switch (screens) {
				case 1:
					if (loaded) {
						if (frameIntro < 81) {
							frameIntro++;
						}
						break;
					}
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void load() {
		intro = new PImage[82];
		for (int i = 0; i < intro.length; i++) {
			intro[i] = app.loadImage("../data/Intro/intro_" + i + ".png");
		}
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
		pnBold = app.createFont("../data/Proxima Nova Bold.ttf", 105);
		loaded = true;
	}

	public void showHumidity() {
		app.fill(67, 233, 123);
		app.textFont(pnBold);
		app.text(humidity + "%", app.width / 2 + 180, 298 + 237);
	}

	public void screens() {
		switch (screens) {
		case 1:
			inicio();
			break;
		case 2:
			home();
			showHumidity();
			break;
		}
	}

	public void inicio() {
		app.image(intro[frameIntro], app.width / 2, app.height / 2);
		app.text(projectName, app.width / 2, app.height / 2);
		if(frameIntro<80) {
			cp5.get("").hide();
		} else {
			cp5.get("").show();
		}
		cp5.get(" ").hide();
	}
	
	public void textField() {
		int blanco = app.color(255);
		int transp = app.color(89, 239, 163, 1);
		int negro = app.color(60, 60, 59);
		int gris = app.color(130, 130, 130);
		int verde = app.color(89, 239, 163);
		
		  cp5.addTextfield("")
		    .setPosition(444, 540)
		      .setSize(400, 30)
		        .setFont(pnRegular)
		            .setColor(negro).setColorForeground(blanco).setColorBackground(blanco).setColorActive(blanco).setColorLabel(blanco);;;
		              ;
		              
		        	  cp5.addTextfield(" ")
		  		    .setPosition(325, 404)
		  		      .setSize(71, 71)
		  		        .setFont(pnRegularBig)
		  		            .setColor(gris).setColorForeground(transp).setColorBackground(transp).setColorActive(transp).setColorLabel(transp).align(ControlP5.CENTER, ControlP5.CENTER, ControlP5.CENTER, ControlP5.CENTER);;;
		  		              ;
	}

	public void home() {
		app.image(home, app.width / 2, app.height / 2);
		app.image(planta, app.width / 2, app.height / 2 + 25);
		app.image(cerrarSesion, app.width / 2 + 493, app.height - 45);
		app.image(datos, app.width / 2 - 290, app.height / 2 + 25);
		app.image(saludo, app.width / 2 + 320, 298 + 67);
		playButton();
		cp5.get("").hide();
		cp5.get(" ").show();
	}

	public void playButton() {
		if (play) {
			if (app.mouseX > 52 && app.mouseX < 246 && app.mouseY > 733 && app.mouseY < 775) {
				app.image(pausaVerde, app.width / 2 - 493, app.height - 45);

			} else {
				app.image(pausa, app.width / 2 - 493, app.height - 45);
			}
		} else {
			if (app.mouseX > 52 && app.mouseX < 246 && app.mouseY > 733 && app.mouseY < 775) {
				app.image(reanudarVerde, app.width / 2 - 493, app.height - 45);
			} else {
				app.image(reanudar, app.width / 2 - 493, app.height - 45);
			}
		}
	}

	public void click() {
		switch (screens) {
		case 1:
			if(app.mouseX > 525 && app.mouseX < 728 && app.mouseY > 627 && app.mouseY < 661) {
				screens = 2;
			}
			break;
		case 2:
			if (app.mouseX > 52 && app.mouseX < 246 && app.mouseY > 733 && app.mouseY < 775) {
				play = !play;
			}
			break;
		}
	}

	public void key() {

	}

	// FIN DE LA CLASE
}
