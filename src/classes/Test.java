package classes;

import main.Biblioteca;

public class Test {

	public static void main(String[] args) {
		Libro l = new Libro("yo","tu",1234);
		Libro l1 = new Libro("jo","zu",1274);
		l.crearAnyadirEjemplar(5);
		l1.crearAnyadirEjemplar(4);
		Socios s = new Socios("hola","adios","a1234");
		Socios s1 = new Socios("aola","haios","b5678");
		Biblio b = new Biblio();
		
		System.out.println(l);
		
		b.addLibros(l);
		System.out.println(b.getListaLibro());
		b.addLibros(l1);
		b.addSocio(s);
		b.addSocio(s1);
		
//		b.prestarLibro(l, s1);
		
		System.out.println(b);
		System.out.println();
		b.getListaLibro().sort(Libro.COMPARE_BY_TITULO);
		System.out.println(b.getListaLibro());
		System.out.println();
		b.getListaLibro().sort(Libro.COMPARE_BY_AUTOR);
		System.out.println(b.getListaLibro());
		System.out.println();
		b.getListaLibro().sort(Libro.COMPARE_BY_NUMEJEMPLARES);
		System.out.println(b.getListaLibro());
		
//		Biblioteca bi = new Biblioteca(); 
	}

}
