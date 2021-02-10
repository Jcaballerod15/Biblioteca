package classes;

public class Test {

	public static void main(String[] args) {
		Libro l = new Libro("yo","tu",1234);
		l.crearAnyadirEjemplar(3);
		
		System.out.println(l);

	}

}
