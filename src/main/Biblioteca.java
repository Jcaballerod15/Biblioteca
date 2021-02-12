package main;

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
				addBook();
				break;
			case 2:
				deleteBook();
				break;
			case 3:
				showBook();
				break;
			case 4:
				showBooks();
				break;
			case 5:
				sortBooks();
				break;
			case 6:
				
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}

		} while (option != 0);
	}
	
	private void crearLibroAux() {
		this.biblioteca.getAux().setTitulo(Entrada.pedirFrase("Introduzca el titulo del Libro"));
		this.biblioteca.getAux().setAutor(Entrada.pedirFrase("Introduzca el autor del Libro"));
		this.biblioteca.getAux().setISBM(Entrada.pedirNum("Lo mas importente introduzca el ISBM de el Libro"));
	}
	private void crearSocioAux1() {
		this.biblioteca.getAux1().setNombre(Entrada.pedirFrase("Introduzca el nombre del socio"));
		this.biblioteca.getAux1().setApellido(Entrada.pedirFrase("Introduzca el apellido del socio"));
		this.biblioteca.getAux1().setDNI(Entrada.pedirFrase("Introduzca el DNI del socio"));
	}
	private void sortBooks() {
		
		
	}

	private void showBooks() {


	}

	private void showBook() {


	}

	private void deleteBook() {

		
	}

	private static void addBook() {
		
	}

	public static void showMenu() {

		System.out.println("1. Introducir socio nuevo");
		System.out.println("2. Introducir Libro nuevo");
		System.out.println("3. Introducir Ejemplar");
		System.out.println("4. Mostrar Libros");
		System.out.println("5. Mostrar Socios");
		System.out.println("6. Guardar");
		System.out.println("-------------------");
		System.out.println("0. Salir");
		System.out.println("-------------------");
		System.out.println();
	}

}
