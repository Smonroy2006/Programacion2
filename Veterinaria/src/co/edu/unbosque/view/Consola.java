package co.edu.unbosque.view;

import java.util.Scanner;

public class Consola {
	private Scanner lector;

	public Consola() {
		lector = new Scanner(System.in);
	}

	public int leerEntero() {
		return lector.nextInt();
	}

	public long leerLong() {
		return lector.nextLong();
	}

	public double leerDouble() {
		return lector.nextDouble();
	}

	public float leerFloat() {
		return lector.nextFloat();
	}

	public String leerPalabra() {
		return lector.next();
	}

	public String leerLinea() {
		return lector.next();
	}

	public char leerCaracter() {
		return lector.next().charAt(0);
	}

	public boolean leerBooleano() {
		String entrada = leerPalabra().toLowerCase();

		if (entrada.contains("si")) {
			return true;
		} else {
			return false;
		}
	}

	public void imprimirConSalto(String texto) {
		System.out.println(texto);
	}

	public void imprimirSinSalto(String texto) {
		System.out.print(texto);
	}

	public void quemarLinea() {
		lector.nextLine();
	}
}
