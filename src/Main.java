import processing.core.PApplet;

public class Main extends PApplet {
	private Logica log;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");
		System.out.println("holi");
	}
	
	public void setup() {
		log = new Logica(this);
	}

	public void draw() {

		log.ejecutar();

	}
	public void keyPressed(){
		System.out.println("hola");
	}
	
	public void mousePressed(){
		System.out.println("hola");
	}
}
