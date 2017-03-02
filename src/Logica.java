import java.util.TreeSet;

import processing.core.PApplet;

public class Logica {
	PApplet app;
	private String txtNom[];
	private String txtDat[];
	private String txtCol[];
	private TreeSet<Persona> personas;
	
	
	public Logica(PApplet app){
		this.app=app;
		cargarTxts();
	}
	
	public void ejecutar(){
		
	}
	
	public void pintarPersonas(){
		
	}
	
	public void cargarTxts() {
		txtNom = app.loadStrings("../data/nombres.txt");
		txtDat = app.loadStrings("../data/datos.txt");
		txtCol = app.loadStrings("../data/colores.txt");
	}
}
