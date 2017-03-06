import processing.core.PApplet;

public class Persona {
	private String nombre, apellido, id, peso, edad;
	private int r, g, b;
	private int x, y;

	public Persona(String nombre, String apellido, String id, String peso, String edad, int r, int g, int b, int x,
			int y) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
		this.peso = peso;
		this.edad = edad;
		this.r = r;
		this.g = g;
		this.b = b;
		this.x = x;
		this.y = y;
	}

	public void pintar(PApplet app) {
		app.fill(r, g, b);
		app.text(nombre + " " + apellido + " " + id + " " + peso + " " + edad, x, y);
	}
}
