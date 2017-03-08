import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

import processing.core.PApplet;

public class Logica {
	PApplet app;
	private String txtNom[];
	private String txtDat[];
	private String txtCol[];
	private ArrayList<Persona> personas;
	private TreeSet<Persona> treePersonas;
	private TreeSet<Persona> treePersonasEdad;
	private int peso, edad, r, g, b;
	private int pantalla;

	public Logica(PApplet app) {
		this.app = app;

		personas = new ArrayList<Persona>();
		treePersonas = new TreeSet<Persona>();
		treePersonasEdad = new TreeSet<Persona>(new ComparadorEdad());
		cargarTxts();

		for (int i = 0; i < txtNom.length; i++) {
			String[] nomApe = txtNom[i].split(":");
			String[] idPesoEdad = txtDat[i].split("/");
			String[] rgb = txtCol[i].split("/");

			r = Integer.parseInt(rgb[0]);
			g = Integer.parseInt(rgb[1]);
			b = Integer.parseInt(rgb[2]);
			peso = Integer.parseInt(idPesoEdad[1]);
			edad = Integer.parseInt(idPesoEdad[2]);

			personas.add(new Persona(nomApe[0], nomApe[1], idPesoEdad[0], peso, edad, r, g, b, 50, 50 + (i * 25)));
		}
	}

	public void ejecutar() {
		app.fill(255);
		app.text("Nombre - Apellido - ID - Peso - Edad", 50, 30);
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
			break;
		case 2:
			if (!personas.isEmpty()) {
				for (int i = 0; i < personas.size(); i++) {
					personas.get(i).pintar(app);
				}
			}
			break;

		case 3:
			if (!treePersonasEdad.isEmpty()) {
				System.out.println("pintando personas por peso");
				Iterator<Persona> it2 = treePersonasEdad.iterator();
				int i2 = 0;
				while (it2.hasNext()) {
					Persona temp = it2.next();
					temp.setY(50 + (i2 * 25));
					temp.pintar(app);
					i2++;
				}
			}
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
			if (!personas.isEmpty()) {
				treePersonas.addAll(personas);
			}
			System.out.println("Objetos en el Array: " + personas.size());
			System.out.println("Objetos en el Tree: " + treePersonas.size());
		}

		if (app.key == '2') {
			pantalla = 2;
			if (!personas.isEmpty()) {
				Collections.sort(personas, new ComparadorPeso());
			}
		}

		if (app.key == '3') {
			pantalla = 3;
			if (!personas.isEmpty()) {
				treePersonasEdad.addAll(personas);
			}
		}

	}
}
