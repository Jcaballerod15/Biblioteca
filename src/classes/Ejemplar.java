package classes;

import java.util.LinkedList;
import java.util.List;

public class Ejemplar {

	private int codigo;
	private Libro l;
	
	public Ejemplar(int codigo,Libro l) {
		this.codigo = codigo;
		this.l = l;
	}
	public int getCodigo() {
		return codigo;
	}
	
	public Libro getL() {
		return l;
	}
	public void setL(Libro l) {
		this.l = l;
	}
	@Override
	public boolean equals(Object o) {
		
		if(o instanceof Ejemplar) {
			Ejemplar l = (Ejemplar) o;
			return l.codigo  == codigo;
		}else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "Ejemplar [ " + l.getTitulo() + " " + l.getAutor() + " Codigo = " + codigo + "]";
	}
	
}
