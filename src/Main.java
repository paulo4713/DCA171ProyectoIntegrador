import processing.core.PApplet;

public class Main extends PApplet {
	private Logica log;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");
	}

	public void setup() {
		log = new Logica(this);
	}

	public void settings() {
		size(410, 500);
	}

	public void draw() {
		background(0);
		log.ejecutar();
	}

	public void keyPressed() {
		log.teclado();
	}
}
