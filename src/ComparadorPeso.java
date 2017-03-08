import java.util.Comparator;

public class ComparadorPeso implements Comparator<Persona> {
	
	public int compare(Persona o1, Persona o2) {
		return o1.getPeso() - o2.getPeso();
	}

}
