import java.util.ArrayList;
import java.util.TreeSet;

import processing.core.PApplet;

public class Logica {
	PApplet app;
	private String txtNom[];
	private String txtDat[];
	private String txtCol[];
	private ArrayList<Persona> personas;
	private int r,g,b;
	
	public Logica(PApplet app){
		this.app=app;
		
		personas = new ArrayList<Persona>();
		
		cargarTxts();
		
		for (int i = 0; i < txtNom.length; i++) {
			String[] nomApe = txtNom[i].split(":");
			String[] idPesoEdad = txtDat[i].split("/");
			String[] rgb = txtCol[i].split("/");
			
			r = Integer.parseInt(rgb[0]);
			g = Integer.parseInt(rgb[1]);
			b = Integer.parseInt(rgb[2]);
			
			personas.add(new Persona(nomApe[0], nomApe[1], idPesoEdad[0], idPesoEdad[1], idPesoEdad[2], r, g, b, 50,50 +(i* 25)));
		}	
	}

	public void ejecutar() {
		pintarPersonas();
	}

	public void pintarPersonas() {
		for (int i = 0; i < personas.size(); i++) {
			personas.get(i).pintar(app);
		}
	}

	public void cargarTxts() {
		txtNom = app.loadStrings("../data/nombres.txt");
		txtDat = app.loadStrings("../data/datos.txt");
		txtCol = app.loadStrings("../data/colores.txt");
	}
}
