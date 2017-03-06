import processing.core.PApplet;

public class Persona implements Comparable<Persona> {
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

	@Override
	public int compareTo(Persona obj) {
		if (this.apellido.equals(obj.getApellido())) {
			return 0;
		}
		return this.apellido.compareTo(obj.getApellido());
	}

	@Override
	public boolean equals(Object obj) {
		Persona p = (Persona) obj;
		return this.apellido.equals(p.getApellido());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
