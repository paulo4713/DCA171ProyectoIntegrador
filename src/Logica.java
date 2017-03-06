import java.util.ArrayList;
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
	private int r, g, b;

	public Logica(PApplet app) {
		this.app = app;

		personas = new ArrayList<Persona>();
		treePersonas = new TreeSet<Persona>();
		cargarTxts();

		for (int i = 0; i < txtNom.length; i++) {
			String[] nomApe = txtNom[i].split(":");
			String[] idPesoEdad = txtDat[i].split("/");
			String[] rgb = txtCol[i].split("/");

			r = Integer.parseInt(rgb[0]);
			g = Integer.parseInt(rgb[1]);
			b = Integer.parseInt(rgb[2]);

			treePersonas.add(new Persona(nomApe[0], nomApe[1], idPesoEdad[0], idPesoEdad[1], idPesoEdad[2], r, g, b, 50,
					50 + (i * 25)));
		}
	}

	public void ejecutar() {
		pintarPersonas();
	}

	public void pintarPersonas() {

		if (!personas.isEmpty()) {
			for (int i = 0; i < personas.size(); i++) {
				personas.get(i).pintar(app);
			}
		}

		if (!treePersonas.isEmpty()) {
			Iterator<Persona> it2 = treePersonas.iterator();
			int i2 = 0;
			while (it2.hasNext()) {
				Persona temp = it2.next();
				temp.setY(50 + (i2 * 25));
				temp.pintar(app);
				i2++;
			}
		}
	}

	public void cargarTxts() {
		txtNom = app.loadStrings("../data/nombres.txt");
		txtDat = app.loadStrings("../data/datos.txt");
		txtCol = app.loadStrings("../data/colores.txt");
	}

	public void teclado() {

		if (app.keyCode == '1') {
			if (!personas.isEmpty()) {
				treePersonas.addAll(personas);
				personas.removeAll(treePersonas);
			}
			System.out.println("Objetos en el Array: " + personas.size());
			System.out.println("Objetos en el Tree: " + treePersonas.size());
		}

		if (app.key == '2') {
			if (!treePersonas.isEmpty()) {
				personas.addAll(treePersonas);
				treePersonas.removeAll(personas);
			}

			System.out.println("Objetos en el Array: " + personas.size());
			System.out.println("Objetos en el Tree: " + treePersonas.size());
		}
	}
}
