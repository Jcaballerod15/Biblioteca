package classes;

import java.util.LinkedList;
import java.util.List;

public class Biblio {

	List<Libro> listaLibro ;
	List<Socios> socios;
	
	public Biblio() {
		this.listaLibro = new LinkedList<Libro>();
		this.socios = new LinkedList<Socios>();
	}
	public void addSocio(Socios p) {
		socios.add(p); 
	}
	public boolean exLibro(Libro e) {
		if(listaLibro.contains(e)) {
			return true;
		}else {
			return false;
		} 
	}
	public boolean exSocio(Socios s) {
		if(socios.contains(s)){
			return true;
		}else {
			return false;
		} 
	}
	public void addLibros(Libro e) {
			listaLibro.add(e);
	}
	public void addEjemplar(Libro e,int num) {
		e.crearAnyadirEjemplar(num);
	}
	public void prestarLibro(Libro e, Socios s) {
		
		int aux = listaLibro.indexOf(e);
		int aux2 = socios.indexOf(s);
		socios.get(aux2).getLibrosPrestados().add(listaLibro.get(aux).getEjemplar().remove(1));
		
	}
//	public void devolLibro(Libro e, Socios s) {
//		
//		int aux = listaLibro.indexOf(e);
//		int aux2 = socios.indexOf(s);
//		listaLibro.get(aux).getEjemplar().add(socios.get(aux2).getLibrosPrestados().poll());
//		
//	}
	
	public List<Libro> getListaLibro() {
		return listaLibro;
	}

	public List<Socios> getSocios() {
		return socios;
	}
	
	
	@Override
	public String toString() {
		return "Biblio [listaLibro=" + listaLibro + ", socios=" + socios.toString() + "]";
	}
	
	
	
}