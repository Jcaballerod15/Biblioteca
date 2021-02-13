package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import classes.Biblio;
import classes.Entrada;
import classes.Libro;
import classes.Socios;

public class Biblioteca {


		int option;
		Biblio biblioteca;
		
		public Biblioteca() {
			biblioteca = new Biblio();
			iniciar();
		}

		public void iniciar() {
		do {
			showMenu();
			option = Entrada.pedirNum("Que desea hace, selecione un numero");

			switch (option) {
			case 0:
				System.out.println("Bye!!");
				break;
			case 1:
				addSocio();
				break;
			case 2:
				addBook();
				break;
			case 3:
				addEjemplar();
				break;
			case 4:
				showBook();
				break;
			case 5:
				showSocios();
				break;
			case 6:
				prestar();
				break;
			case 7:
				devolucion();
				break;
			case 8:
				Biblioteca.guardar(this);
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}

		} while (option != 0);
	}
	
	private Libro crearLibroAux() {
		this.biblioteca.getAux().setTitulo(Entrada.pedirFrase("Introduzca el titulo del Libro"));
		this.biblioteca.getAux().setAutor(Entrada.pedirFrase("Introduzca el autor del Libro"));
		this.biblioteca.getAux().setISBM(Entrada.pedirNum("Lo mas importente introduzca el ISBM de el Libro"));
		return this.biblioteca.getAux();
	}
	private Socios crearSocioAux1() {
		this.biblioteca.getAux1().setNombre(Entrada.pedirFrase("Introduzca el nombre del socio"));
		this.biblioteca.getAux1().setApellido(Entrada.pedirFrase("Introduzca el apellido del socio"));
		this.biblioteca.getAux1().setDNI(Entrada.pedirFrase("Introduzca el DNI del socio"));
		return this.biblioteca.getAux1();
	}
	private void showSocios() {
		int in;
		do {
		System.out.println("1.Por nombre, 2.Por numero de libros prestados, 0. Exit");
		in = Entrada.pedirNum("Selecione de que forma desea ver los Socios");
		if (in == 1) {
			biblioteca.getSocios().sort(Socios.COMPARE_BY_NAME);
			System.out.println(biblioteca.getSocios());
		}else if (in == 2) {
			biblioteca.getSocios().sort(Socios.COMPARE_BY_TITULO);;
			System.out.println(biblioteca.getSocios());
		}
		}while(in !=0 );
	}

	private void addEjemplar() {
		Libro l = crearLibroAux();
		if(biblioteca.exLibro(l)) {
		int es = biblioteca.getListaLibro().indexOf(l);
		Libro l1 = biblioteca.getListaLibro().get(es);
		int option = Entrada.pedirNum("Introduzca el numero de ejemplares");
		int sum =l1.getEjemplar().size() + option;
		biblioteca.addEjemplar(l1, sum);
		}else {
			System.out.println("No existe el libro");
		}
	}
	private void prestar() {
		
		System.out.println("Introduce el socio");
		Socios s = crearSocioAux1();
		int i = biblioteca.getSocios().indexOf(s);
		if(biblioteca.getSocios().get(i).getLibrosPrestados().size() < biblioteca.getSocios().get(i).getCantidadMax()) {
			if(biblioteca.getSocios().contains(s)) {
				Libro l = crearLibroAux(); 
				biblioteca.prestarLibro(l, s);
			}else {
				System.out.println("La persona no esta registrado como socio");
			}
		}else {
			System.out.println("No se te pede prestar mas");
		}
	}
	private void devolucion() {
		System.out.println("Introduce el socio");
		Socios s = crearSocioAux1();
		if(biblioteca.getSocios().contains(s)) {
			Libro l = crearLibroAux(); 
			biblioteca.devolLibro(l, s);
		}else {
			System.out.println("La persona no esta registrado como socio");
		}
	}

	private void showBook(){
		int in;
		do {
		System.out.println("1.Por titulo, 2. Por autor, 3.Por numero de ejemplares, 0. Exit");
		in = Entrada.pedirNum("Selecione de que forma desea ver los Libros");
		if (in == 1) {
			biblioteca.getListaLibro().sort(Libro.COMPARE_BY_TITULO);
			System.out.println(biblioteca.getListaLibro());
		}else if (in == 2) {
			biblioteca.getListaLibro().sort(Libro.COMPARE_BY_TITULO);
			System.out.println(biblioteca.getListaLibro());
		}else if (in == 3) {
			biblioteca.getListaLibro().sort(Libro.COMPARE_BY_NUMEJEMPLARES);
			System.out.println(biblioteca.getListaLibro());
		}
		}while(in !=0 );
	}

	private void addSocio() {
		Socios p = crearSocioAux1();
		if(biblioteca.exSocio(p)==false) {
			biblioteca.addSocio(p);
		}else {
			System.out.println("el socio esta registrado de antes");
		}
		
	}

	private void addBook() {
		Libro l = crearLibroAux();
		if(biblioteca.exLibro(l)== false) {
		int option = Entrada.pedirNum("Intrduce el numero de ejmplares que quieres introducir");
		l.crearAnyadirEjemplar(option);
		biblioteca.addLibros(l);
		}else {
			System.out.println("el libro esta registrado de antes");
		}
		
	}
	public static void guardar(Biblioteca b){
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("biblioteca_gg.txt"))) {

			oos.writeObject(b);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}
	public static Biblioteca cargar(){
		Biblioteca p = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("biblioteca_gg.txt"))) {

			p = (Biblioteca)ois.readObject();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

	public static void showMenu() {

		System.out.println("1. Introducir socio nuevo");
		System.out.println("2. Introducir Libro nuevo");
		System.out.println("3. Introducir Ejemplar");
		System.out.println("4. Mostrar Libros");
		System.out.println("5. Mostrar Socios");
		System.out.println("6. Prestar Libro");
		System.out.println("7. Devolucion del Libro");
		System.out.println("8. Guardar");
		System.out.println("-------------------");
		System.out.println("0. Salir");
		System.out.println("-------------------");
		System.out.println();
	}
	

}
