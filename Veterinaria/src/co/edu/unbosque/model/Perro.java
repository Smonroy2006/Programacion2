package co.edu.unbosque.model;

import java.io.Serializable;

public class Perro extends Animal implements Serializable {

	private String formaNariz;
	private final boolean TIENE_DIENTES_CANINOS = true;

	public Perro() {

	}

	public Perro(String formaNariz) {
		super();

		this.formaNariz = formaNariz;
	}

	public Perro(String nombre, String raza, int edad, float peso, String formaNariz) {
		super(nombre, raza, edad, peso);
		this.formaNariz = formaNariz;
	}

	public String getFormaNariz() {
		return formaNariz;
	}

	public void setFormaNariz(String formaNariz) {
		this.formaNariz = formaNariz;
	}

	public boolean isTIENE_DIENTES_CANINOS() {
		return TIENE_DIENTES_CANINOS;
	}

	@Override
	@Override
	public String toString() {
		return super.toString() + "\n -FormaNariz: " + formaNariz + "\n -TIENE_DIENTES_CANINOS: " + (TIENE_DIENTES_CANINOS? "Si" : "No");
	}

	@Override
	@Override
	public String alimentarse() {
		// TODO Auto-generated method stub
		return "El perro se alimenta con croquetas";
	}

	@Override
	@Override
	public String reproducirse() {
		// TODO Auto-generated method stub
		return null;
	}

}
