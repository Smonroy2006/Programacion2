package co.edu.unbosque.model;

import java.io.Serializable;

public class RuedorDTO extends Animal implements Serializable {

	private int tamanoDiente;
	private String tipoMadriguera;

	public RuedorDTO() {

	}

	public RuedorDTO(int tamanoDiente, String tipoMadriguera) {
		super();
		this.tamanoDiente = tamanoDiente;
		this.tipoMadriguera = tipoMadriguera;
	}


	public RuedorDTO(String nombre, String raza, int edad, float peso, int tamanoDiente, String tipoMadriguera) {
		super(nombre, raza, edad, peso);
		this.tamanoDiente = tamanoDiente;
		this.tipoMadriguera = tipoMadriguera;
	}


	public int getTamañoDiente() {
		return tamanoDiente;
	}

	public void setTamañoDiente(int tamañoDiente) {
		this.tamanoDiente = tamañoDiente;
	}

	public String getTipoMadriguera() {
		return tipoMadriguera;
	}

	public void setTipoMadriguera(String tipoMadriguera) {
		this.tipoMadriguera = tipoMadriguera;
	}

	@Override
	@Override
	public String toString() {
		return "Ruedor [tamañoDiente=" + tamanoDiente + ", tipoMadriguera=" + tipoMadriguera + "]";
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
