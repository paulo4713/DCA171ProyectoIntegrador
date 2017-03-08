import processing.core.PApplet;

public class Persona implements Comparable<Persona> {
	private String nombre, apellido, id;
	private int peso, edad;
	private int r, g, b;
	private int x, y;
	private int sumaColor;

	public int getSumaColor() {
		return sumaColor;
	}

	public void setSumaColor(int sumaColor) {
		this.sumaColor = sumaColor;
	}

	public Persona(String nombre, String apellido, String id, int edad, int peso, int r, int g, int b, int x,
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
		sumaColor = r+g+b;
	}

	public void pintar(PApplet app) {
		app.fill(r, g, b);
		app.text(nombre, x, y);
		app.text(apellido, x + 70, y);
		app.text(id, x +150, y);
		app.text(edad, x +250, y);
		app.text(peso, x +300, y);
		
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
		return this.sumaColor == p.getSumaColor();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.sumaColor;
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

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
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
