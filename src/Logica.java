import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import processing.core.PApplet;
import processing.core.PConstants;

public class Logica {
	PApplet app;
	private String txtNom[];
	private String txtDat[];
	private String txtCol[];
	private ArrayList<Persona> personas;
	private TreeSet<Persona> treePersonas;
	private TreeSet<Persona> treePersonasEdad;
	private HashSet<Persona> hashPersonas;
	private int peso, edad, r, g, b;
	private int x = 50, y = 30;
	private int pantalla;

	public Logica(PApplet app) {
		this.app = app;

		personas = new ArrayList<Persona>();
		treePersonas = new TreeSet<Persona>();
		hashPersonas = new HashSet<Persona>();
		treePersonasEdad = new TreeSet<Persona>(new ComparadorEdad());
		cargarTxts();

		for (int i = 0; i < txtNom.length; i++) {
			String[] nomApe = txtNom[i].split(":");
			String[] idPesoEdad = txtDat[i].split("/");
			String[] rgb = txtCol[i].split("/");

			r = Integer.parseInt(rgb[0]);
			g = Integer.parseInt(rgb[1]);
			b = Integer.parseInt(rgb[2]);
			edad = Integer.parseInt(idPesoEdad[1]);
			peso = Integer.parseInt(idPesoEdad[2]);

			personas.add(new Persona(nomApe[0], nomApe[1], idPesoEdad[0], edad, peso, r, g, b, 50, 50 + (i * 25)));
		}
	}

	public void ejecutar() {
		app.fill(255);
		app.text("Nombre", x, y);
		app.text("Apellido", x + 70, y);
		app.text("Id", x + 150, y);
		app.text("Edad", x + 250, y);
		app.text("Peso", x + 300, y);
		pintarPersonas();
	}

	public void pintarPersonas() {
		switch (pantalla) {
		case 0:
			if (!personas.isEmpty()) {
				for (int i = 0; i < personas.size(); i++) {
					personas.get(i).pintar(app);
				}
			}
			
			app.fill(255);
			app.textAlign(PConstants.CENTER);
			app.text("PRESENTACION ORIGINAL", app.width/2, 400);
			app.textAlign(PConstants.LEFT);
			break;

		case 1:
			if (!treePersonas.isEmpty()) {
				Iterator<Persona> it = treePersonas.iterator();
				int i = 0;
				while (it.hasNext()) {
					Persona temp = it.next();
					temp.setY(50 + (i * 25));
					temp.pintar(app);
					i++;
				}
			}
			app.fill(255);
			app.textAlign(PConstants.CENTER);
			app.text("POR APELLIDO, CON REPETIDOS", app.width/2, 400);
			app.textAlign(PConstants.LEFT);
			break;

		case 2:

			for (int i = 0; i < personas.size(); i++) {
				personas.get(i).setY(50 + (i * 25));
				personas.get(i).pintar(app);
			}
			app.fill(255);
			app.textAlign(PConstants.CENTER);
			app.text("POR PESO, CON REPETIDOS", app.width/2, 400);
			app.textAlign(PConstants.LEFT);
			break;

		case 3:
			if (!treePersonasEdad.isEmpty()) {
				Iterator<Persona> it2 = treePersonasEdad.iterator();
				int i2 = 0;
				while (it2.hasNext()) {
					Persona temp = it2.next();
					temp.setY(50 + (i2 * 25));
					temp.pintar(app);
					i2++;
				}
			}
			app.fill(255);
			app.textAlign(PConstants.CENTER);
			app.text("POR EDAD, SIN REPETIDOS", app.width/2, 400);
			app.textAlign(PConstants.LEFT);
			break;

		case 4:
			if (!hashPersonas.isEmpty()) {
				Iterator<Persona> it2 = hashPersonas.iterator();
				int i2 = 0;
				while (it2.hasNext()) {
					Persona temp = it2.next();
					temp.setY(50 + (i2 * 25));
					temp.pintar(app);
					i2++;
				}
			}
			app.fill(255);
			app.textAlign(PConstants.CENTER);
			app.text("POR IGUALDAD BASE (SUMA DE COLORES), SIN REPETIDOS", app.width/2, 400);
			app.textAlign(PConstants.LEFT);
			break;
		}

	}

	public void cargarTxts() {
		txtNom = app.loadStrings("../data/nombres.txt");
		txtDat = app.loadStrings("../data/datos.txt");
		txtCol = app.loadStrings("../data/colores.txt");
	}

	public void teclado() {

		if (app.keyCode == '1') {
			pantalla = 1;
			treePersonas.addAll(personas);
		}

		if (app.key == '2') {
			pantalla = 2;
			Collections.sort(personas, new ComparadorPeso());
		}

		if (app.key == '3') {
			pantalla = 3;
			treePersonasEdad.addAll(personas);
		}

		if (app.key == '4') {
			pantalla = 4;
			hashPersonas.addAll(personas);
		}

	}
}
