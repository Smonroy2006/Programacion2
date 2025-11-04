package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Esta clase tiene todos los atributos de gato y implementa dos cosas, se
 * extiende con animal para compartir sus atributos y se marca con
 * "Serializable" para que pueda serializar sus atributos
 */
public class Gato extends Animal implements Serializable {

	private String patronPelaje;
	private boolean tienePelo;

	/**
	 * Constructor vacio por norma
	 */
	public Gato() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Un constructor con las variables solo de gato
	 *
	 * @param patronPelaje
	 * @param tienePelo
	 */
	public Gato(String patronPelaje, boolean tienePelo) {
		super();
		this.patronPelaje = patronPelaje;
		this.tienePelo = tienePelo;
	}

	/**
	 * Un constructor con mas parametros que incluyen las de animal y las de gato
	 *
	 * @param nombre
	 * @param raza
	 * @param edad
	 * @param peso
	 * @param patronPelaje
	 * @param tienePelo
	 */
	public Gato(String nombre, String raza, int edad, float peso, String patronPelaje, boolean tienePelo) {
		super(nombre, raza, edad, peso);

		this.patronPelaje = patronPelaje;
		this.tienePelo = tienePelo;
	}

	// Setters and Getters

	public String getPatronPelaje() {
		return patronPelaje;
	}

	public void setPatronPelaje(String patronPelaje) {
		this.patronPelaje = patronPelaje;
	}

	public boolean isTienePelo() {
		return tienePelo;
	}

	public void setTienePelo(boolean tienePelo) {
		this.tienePelo = tienePelo;
	}

	/**
	 * Funcion que nos permite imprimir las variables de gato y se extienda con la
	 * super clase
	 */
	@Override
	@Override
	public String toString() {
		return super.toString() + "Gato [patronPelaje=" + patronPelaje + ", tienePelo=" + tienePelo + "]";
	}

	/**
	 * Esta funcion nos perimte saber como se alimenta el animal, y utiliza el valor
	 * de la super clase
	 */
	@Override
	@Override
	public String alimentarse() {
		// TODO Auto-generated method stub
		return super.alimentarse();
	}

	/**
	 * Esta funcion nos dice como se reproduce el gato, devolviendo un string con
	 * esa informacion
	 */
	@Override
	@Override
	public String reproducirse() {
		// TODO Auto-generated method stub
		return "El gato se aparea con el de genero contrario";
	}

}