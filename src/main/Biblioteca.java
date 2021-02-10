package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import classes.Libro;
import classes.Lista;
import classes.Socios;

public class Biblioteca {

	public static void main(String[] args) {

		int option;
		Scanner entrada = new Scanner(System.in);

		do {
			showMenu();
			option = entrada.nextInt();

			switch (option) {
			case 0:
				System.out.println("Bye!!");
				break;
			case 1:
				addBook(libros);
				break;
			case 2:
				deleteBook(libros);
				break;
			case 3:
				showBook(libros);
				break;
			case 4:
				showBooks(libros);
				break;
			case 5:
				sortBooks(libros);
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}

		} while (option != 0);
	}
	
	private static void sortBooks(Lista libros) {
		
		libros.sort();
		System.out.println("Libros ordenados");
		
	}

	private static void showBooks(Lista libros) {

		System.out.println(libros);

	}

	private static void showBook(Lista libros) {

		Scanner entrada = new Scanner(System.in);
		Libro libro;
		String titulo;

		System.out.println("Dame el titulo:");
		titulo = entrada.nextLine();

		libro = libros.getBook(titulo);

		if (libro == null)
			System.out.println("Libro no encontrado.");
		else
			System.out.println(libro);

	}

	private static void deleteBook(Lista libros) {

		Scanner entrada = new Scanner(System.in);
		Libro libro;
		String titulo;

		System.out.println("Dame el titulo:");
		titulo = entrada.nextLine();

		libro = new Libro(titulo);

		if (libros.delete(libro))
			System.out.println("Eliminado.");
		else
			System.out.println("No eliminado.");
	}

	private static void addBook(Lista libros) {

		Scanner entrada = new Scanner(System.in);
		Libro libro;
		String titulo, autor;

		System.out.println("Dame el titulo:");
		titulo = entrada.nextLine();
		System.out.println("Dame el autor:");
		autor = entrada.nextLine();

		libro = new Libro(titulo, autor);

		libros.addElementHead(libro);
		System.out.println("Libro añadido.");
	}

	public static void showMenu() {

		System.out.println("1. Introducir socio nuevo");
		System.out.println("2. Eliminar Libro");
		System.out.println("3. Buscar Libro");
		System.out.println("4. Mostrar Libros");
		System.out.println("5. Ordenar Libros");
		System.out.println("-------------------");
		System.out.println("0. Salir");
		System.out.println("-------------------");
		System.out.println();
		System.out.println("Introduzca opcion:");
	}

}
