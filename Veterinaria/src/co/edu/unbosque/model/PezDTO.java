package co.edu.unbosque.model;

import java.io.Serializable;

public class PezDTO extends Animal implements Serializable {

	private boolean esVenenoso;
	private boolean esAvisal;

	public PezDTO() {
		// TODO Auto-generated constructor stub
	}

	public PezDTO(boolean esVenenoso, boolean esAvisal) {
		super();
		this.esVenenoso = esVenenoso;
		this.esAvisal = esAvisal;
	}

	public PezDTO(String nombre, String raza, int edad, float peso, boolean esVenenoso, boolean esAvisal) {
		super(nombre, raza, edad, peso);
		this.esVenenoso = esVenenoso;
		this.esAvisal = esAvisal;
	}

	public boolean isEsVenenoso() {
		return esVenenoso;
	}

	public void setEsVenenoso(boolean esVenenoso) {
		this.esVenenoso = esVenenoso;
	}

	public boolean isEsAvisal() {
		return esAvisal;
	}

	public void setEsAvisal(boolean esAvisal) {
		this.esAvisal = esAvisal;
	}

	@Override
	@Override
	public String toString() {
		return super.toString() + "Pez [esVenenoso=" + esVenenoso + ", esAvisal=" + esAvisal + "]";
	}

	@Override
	@Override
	public String alimentarse() {
		// TODO Auto-generated method stub
		return super.alimentarse();
	}

	@Override
	@Override
	public String reproducirse() {
		// TODO Auto-generated method stub
		return null;
	}

}
