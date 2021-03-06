package classes;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Biblio implements Serializable {

	List<Libro> listaLibro ;
	List<Socios> socios;
	Libro aux;
	Socios aux1;
	
	public Biblio() {
		this.listaLibro = new LinkedList<Libro>();
		this.socios = new LinkedList<Socios>();
		this.aux = new Libro(null,null,0);
		this.aux1 = new Socios(null,null,null);
	}
	public void addSocio(Socios p) {
		socios.add(new Socios (p.getNombre(),p.getApellido(),p.getDNI())); 
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
			Libro l = new Libro(e.getTitulo(),e.getAutor(),e.getISBM());
			l.crearAnyadirEjemplar(e.getEjemplar().size());
			listaLibro.add(l);
	}
	public void addEjemplar(Libro e,int num) {
		e.crearAnyadirEjemplar(num);
	}
	public void prestarLibro(Libro e, Socios s) {
		
		int aux = listaLibro.indexOf(e);
		int aux2 = socios.indexOf(s);
		socios.get(aux2).getLibrosPrestados().add(listaLibro.get(aux).getEjemplar().remove(0));
		
	}
	public void devolLibro(Libro e, Socios s) {
		
		int aux = listaLibro.indexOf(e);
		int aux2 = socios.indexOf(s);
		listaLibro.get(aux).getEjemplar().add(socios.get(aux2).getLibrosPrestados().get(sacarLibro(e,s)));
		socios.get(aux2).getLibrosPrestados().remove(sacarLibro(e,s));
		
	}
	private int sacarLibro(Libro e, Socios s) {
		
		int aux2 = socios.indexOf(s);
		for(int i = 0; i < socios.get(0).getCantidadMax(); i++) {
			if(socios.get(aux2).getLibrosPrestados().get(i).getL().equals(e)) {
				return i;
			}
		}
			return 0;
	}
	
	public List<Libro> getListaLibro() {
		return listaLibro;
	}

	public List<Socios> getSocios() {
		return socios;
	}
	
	public Libro getAux() {
		return aux;
	}
	public void setAux(Libro aux) {
		this.aux = aux;
	}
	public Socios getAux1() {
		return aux1;
	}
	public void setAux1(Socios aux1) {
		this.aux1 = aux1;
	}
	@Override
	public String toString() {
		return "Biblio [listaLibro=" + listaLibro.toString() + ", socios=" + socios.toString() + "]";
	}
	
	
	
}
