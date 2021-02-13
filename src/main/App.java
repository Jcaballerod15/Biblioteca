package main;

import classes.Entrada;

public class App {

	public static void main(String[] args) {

		Biblioteca b;
		int i;
		do {

			System.out.println("1. Nueva Biblioteca");
			System.out.println("2. Cargar Biblioteca");
			System.out.println("---------------------");
			System.out.println("0. Exit");
			i = Entrada.pedirNum("Su eleccion es:");

			if (i == 1) {
				b = new Biblioteca();
			} else if (i == 2) {
				b = Biblioteca.cargar();
			}

		} while (i != 0);

	}

}
