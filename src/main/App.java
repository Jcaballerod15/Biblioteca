package main;

import classes.Entrada;

public class App {

	public static void main(String[] args) {

		Biblioteca b;
		int i;
		

			System.out.println("1.Biblioteca");
			System.out.println("---------------------");
			System.out.println("0. Exit");
			i = Entrada.pedirNum("Su eleccion es:");

			if (i == 1) {
				b = new Biblioteca();
			}else {
				System.out.println("Bay");
			}

			

	}

}
