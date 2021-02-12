package classes;

import java.util.ArrayList;
import java.util.Comparator;

public class Libro implements Comparable<Libro>{

	private String titulo;
	private String autor;
	private int ISBM;
	private ArrayList<Ejemplar> ejemplares;
	
	public static final Comparator COMPARE_BY_TITULO = new Comparator<Libro>() {
		@Override
		public int compare(Libro p0, Libro p1) {
			
			return p0.getTitulo().compareTo(p1.getTitulo());
		}			
	};
	public static final Comparator<Libro> COMPARE_BY_AUTOR = (p0,p1) -> p0.getAutor().compareTo(p1.getAutor()) ;
	
	public static final Comparator COMPARE_BY_NUMEJEMPLARES = new Comparator<Libro>() {
		@Override
		public int compare(Libro p0, Libro p1) {
		
			return p0.getEjemplar().size() - p1.getEjemplar().size();
		}			
	};

	public Libro(String titulo, String autor, int isbm) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		ISBM = isbm;
		ejemplares = new ArrayList<Ejemplar>();
	}

	public void crearAnyadirEjemplar(int numEjem) {
		for(int i =0; i<numEjem ; i++) {
			ejemplares.add(new Ejemplar(ejemplares.size(),this));
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public ArrayList<Ejemplar> getEjemplar() {
		return ejemplares;
	}

	public void setEjemplar(ArrayList<Ejemplar> ejemplar) {
		this.ejemplares = ejemplar;
	}

	public int getISBM() {
		return ISBM;
	}
	public void setISBM(int num) {
		this.ISBM = num;
	}
	
	@Override
	public boolean equals(Object o) {

		if (o instanceof Libro) {
			Libro l = (Libro) o;
			return l.ISBM == ISBM;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", ISBM=" + ISBM +"] Ejemplares = " + ejemplares.size();
	}

	@Override
	public int compareTo(Libro arg0) {
		
		return 0;
	}

}
