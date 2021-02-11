package classes;

import java.util.Scanner;

public class Entrada {
	
	public static int pedirNum(String frase) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(frase);
		return sc.nextInt();
	}
	public static String pedirFrase(String frase) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(frase);
		return sc.nextLine();
	}
}
