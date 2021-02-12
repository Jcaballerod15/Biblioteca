package classes;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Socios implements Comparable<Socios>{

	private String nombre;
	private String apellido;
	private String DNI;
	private LinkedList<Ejemplar> librosPrestados;
	private int CantidaMax = 3;
	
	public static final Comparator COMPARE_BY_NAME = new Comparator<Socios>() {
		@Override
		public int compare(Socios p0, Socios p1) {
			
			return p0.getNombre().compareTo(p1.getNombre());
		}			
	};
	public static final Comparator COMPARE_BY_TITULO = new Comparator<Socios>() {
		@Override
		public int compare(Socios p0, Socios p1) {
			
			return p0.getLibrosPrestados().size() - p1.getLibrosPrestados().size();
		}			
	};

	public Socios(String nombre, String apellido, String dNI) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		DNI = dNI;
		librosPrestados= new LinkedList<Ejemplar>();
	}
	
	public int getCantidadMax(){
		return CantidaMax;
	}
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDNI() {
		return DNI;
	}
	public LinkedList<Ejemplar> getLibrosPrestados() {
		return librosPrestados;
	}
	public void setLibrosPrestados(LinkedList<Ejemplar> librosPrestados) {
		this.librosPrestados = librosPrestados;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	@Override
	public String toString() {
		return "Socios [nombre=" + nombre + ", apellido=" + apellido + ", DNI=" + DNI + "]";
	}
	@Override
	public boolean equals(Object o) {
		
		if(o instanceof Socios) {
			Socios l = (Socios) o;
			int aux = l.DNI.compareTo(DNI);
			if(aux ==0) {
				return true;
			}else
				return false;
		}else {
			return false;
		}
	}

	@Override
	public int compareTo(Socios arg0) {
			
		return 0;
	}
}
