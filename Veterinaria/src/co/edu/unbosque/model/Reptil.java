package co.edu.unbosque.model;

import java.io.Serializable;

public class Reptil extends Animal implements Serializable {

	private boolean esVenenoso;
	private int tiempoDeMudaDePiel;

	public Reptil() {

	}

	public Reptil(boolean esVenenoso, int tiempoDeMudaDePiel) {
		super();
		this.esVenenoso = esVenenoso;
		this.tiempoDeMudaDePiel = tiempoDeMudaDePiel;
	}

	public Reptil(String nombre, String raza, int edad, float peso, boolean esVenenoso, int tiempoDeMudaDePiel) {
		super(nombre, raza, edad, peso);
		this.esVenenoso = esVenenoso;
		this.tiempoDeMudaDePiel = tiempoDeMudaDePiel;
	}



	public boolean isEsVenenoso() {
		return esVenenoso;
	}

	public void setEsVenenoso(boolean esVenenoso) {
		this.esVenenoso = esVenenoso;
	}

	public int getTiempoDeMudaDePiel() {
		return tiempoDeMudaDePiel;
	}

	public void setTiempoDeMudaDePiel(int tiempoDeMudaDePiel) {
		this.tiempoDeMudaDePiel = tiempoDeMudaDePiel;
	}

	@Override
	@Override
	public String toString() {
		return super.toString() +  "Reptil [esVenenoso=" + esVenenoso + ", tiempoDeMudaDePiel=" + tiempoDeMudaDePiel + "]";
	}

	@Override
	@Override
	public String alimentarse() {
		// TODO Auto-generated method stub
		return "El reptil se alimenta de carne";
	}

	@Override
	@Override
	public String reproducirse() {
		// TODO Auto-generated method stub
		return null;
	}

}
