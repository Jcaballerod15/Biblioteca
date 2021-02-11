package classes;

public class Test {

	public static void main(String[] args) {
		Libro l = new Libro("yo","tu",1234);
		l.crearAnyadirEjemplar(3);
		Socios s = new Socios("hola","adios","a1234");
		Biblio b = new Biblio();
		
		b.addLibros(l);
		b.addSocio(s);
		b.prestarLibro(l, s);
		
		
		System.out.println(l);
		System.out.println(b);
		System.out.println(b.getSocios().get(0).getLibrosPrestados().toString());
		b.devolLibro(l, s);
		System.out.println(b);
		System.out.println(b.getSocios().get(0).getLibrosPrestados().toString());
		
	}

}
