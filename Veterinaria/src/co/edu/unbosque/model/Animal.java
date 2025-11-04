package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Esta una de las super clases del programa, que le da los atributos generales
 * a cada objeto
 */
public abstract class Animal implements OperacionAnimal, Serializable {

	/*
	 * La interfaz serializable, su tarea es marcar Las clases que se pueden
	 * serializar
	 *
	 * Esta clase tiene atrnutos generales de todos los animales, ademas de eso se
	 * genera como una clase abstracta, por que no se instanciar (Crea un objeto),
	 * pero sirve como una plantilla para las demas
	 */

	private String nombre;
	private String raza;
	private int edad;
	private float peso;

	/**
	 * Siempre debemos generar un constructor vacio, para evitar problemas con
	 * algunos datos
	 */
	public Animal() {

	}

	/**
	 * Se crea un constructor con parametros para ser utilizado en una clase, para
	 * utilizar sus atributos
	 *
	 * @param nombre
	 * @param raza
	 * @param edad
	 * @param peso
	 */
	public Animal(String nombre, String raza, int edad, float peso) {

		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.peso = peso;

	}

	// Getters and Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	/**
	 * Esta funcion lo que hace es pasar todos los atributos a un formato de texto
	 * (To Strign) para que sea imprimido
	 */
	@Override
	public String toString() {
		return "Animal: " + "\n -Nombre: " + nombre + "\n -Raza: " + raza + "\n -Edad: " + edad + "\n -Peso: " + peso;
	}

	/**
	 * Esta funcion nos dice como se alimenta el animal,pero en este caso solo sirve
	 * como plantilla para otras
	 */
	@Override
	@Override
	public String alimentarse() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Esta funcion nos dice como se reprduce el animal pero en este caso solo
	 * permite que sea como una plantilla para cada animal
	 */
	@Override
	@Override
	public String reproducirse() {
		// TODO Auto-generated method stub
		return null;
	}
}