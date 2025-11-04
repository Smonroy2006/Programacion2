package co.edu.unbosque.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.Perro;
import co.edu.unbosque.model.PerroDTO;
import co.edu.unbosque.model.persistence.DataMapper;

public class PerroDTOTest {

	static Perro entidad;
	static PerroDTO entidadDTO;
	static int pruebasHechas = 0;

	@BeforeClass // Se ejecuta una sola vez siempre antes de todas las pruebas
	public static void antesDeTodasLasPruebas() {

		entidad = new Perro("Max", "Border", 12, 20, "Chato");
		entidadDTO = new PerroDTO("Alaska", "Criolla", 20, 30, "Osico Alargado");
		System.out.println(
				"____________________________________________________________________________________________________");
		System.out.println("Inciado prubas de la clase perro DTO");
		System.out.println("------------------------------------------");

		System.out.println("Los datos de Perro incialmente son:" + entidad.toString());
		System.out.println("------------------------------------------");
		System.out.println("Los datos del PerroDTO inicialmente son: " + entidadDTO.toString());
	}

	// las unicas funciones estaticas son las que son clases
	// Segunda parte del test
	@Before
	public void antesDeCadaPrueba() {

		System.out.println(
				"____________________________________________________________________________________________________");
		System.out.println("Ejecutando una funcion antes de la prueba reinicializando la entidad");

		System.out.println("");
		System.out.println("Inciado prubas de la clase perro DTO");
		System.out.println("------------------------------------------");

	}

	// tercera fase para todo el programa
	@Test
	public void comprobarConversionEntidadDTO() {

		System.out.println("Inciando prueba de conversion de entidad a DTO");
		PerroDTO dto = DataMapper.perroToPerroDTO(entidad);
		System.out.println("------------------------------------------");

		// Revision de Nombre
		boolean nombre;
		if (entidad.getNombre().equals(dto.getNombre())) {
			nombre = true;
			System.out.println("Igualdad de nomre: " + nombre);
		} else {
			nombre = false;
			System.out.println("Igualdad de nombre: " + nombre);
		}

		// Revision de edad
		boolean edad;
		if (entidad.getEdad() == dto.getEdad()) {
			edad = true;
			System.out.println("Igualdad de edad: " + edad);
		} else {
			edad = false;
			System.out.println("Iguadad de edad: " + edad);
		}

		// Revision de peso
		boolean peso;
		if (entidad.getPeso() == dto.getPeso()) {
			peso = true;
			System.out.println("Igualdad de peso: " + peso);
		} else {
			peso = false;
			System.out.println("Igualda de peso: " + peso);
		}

		// Revision de raza
		boolean raza;
		if (entidad.getRaza().equals(dto.getRaza())) {
			raza = true;
			System.out.println("Igualdad de nomre: " + raza);
		} else {
			raza = false;
			System.out.println("Igualdad de raza: " + raza);
		}

		// Revision de forma de nariz
		boolean formaNariz;
		if (entidad.getFormaNariz().equals(dto.getFormaNariz())) {
			formaNariz = true;
			System.out.println("Igualdad de forma nariz: " + formaNariz);
		} else {
			formaNariz = false;
			System.out.println("igualdad de forma nariz: " + formaNariz);
		}

		pruebasHechas++;
	}

	@Test
	public void comprobarConversionDTOIdentidad() {

		System.out.println("Inciando prueba de conversion de DTO a Identidad");
		Perro objeto = DataMapper.perroDTOToPerro(entidadDTO);
		System.out.println("------------------------------------------");

		// Revision de Nombre
		boolean nombre;
		if (entidadDTO.getNombre().equals(objeto.getNombre())) {
			nombre = true;
			System.out.println("Igualdad de nomre: " + nombre);
		} else {
			nombre = false;
			System.out.println("Igualdad de nombre: " + nombre);
		}

		// Revision de edad
		boolean edad;
		if (entidadDTO.getEdad() == objeto.getEdad()) {
			edad = true;
			System.out.println("Igualdad de edad: " + edad);
		} else {
			edad = false;
			System.out.println("Iguadad de edad: " + edad);
		}

		// Revision de peso
		boolean peso;
		if (entidadDTO.getPeso() == objeto.getPeso()) {
			peso = true;
			System.out.println("Igualdad de peso: " + peso);
		} else {
			peso = false;
			System.out.println("Igualda de peso: " + peso);
		}

		// Revision de raza
		boolean raza;
		if (entidadDTO.getRaza().equals(objeto.getRaza())) {
			raza = true;
			System.out.println("Igualdad de nomre: " + raza);
		} else {
			raza = false;
			System.out.println("Igualdad de raza: " + raza);
		}

		// Revision de forma de nariz
		boolean formaNariz;
		if (entidadDTO.getFormaNariz().equals(objeto.getFormaNariz())) {
			formaNariz = true;
			System.out.println("Igualdad de forma nariz: " + formaNariz);
		} else {
			formaNariz = false;
			System.out.println("igualdad de forma nariz: " + formaNariz);
		}

		pruebasHechas++;
	}

	@Test
	public void comprobarContructoPerroDTO() {
		System.out.println("Inciando verificacion de constructor");
		System.out.println("------------------------------------------");

		//Revision de nombre en el constructor
		boolean nombre;
		if(entidadDTO.getNombre().isEmpty() || !entidadDTO.getNombre().equals("Alaska")) {

			nombre = false;
			System.out.println("La verificacion de nombre es: " + nombre);

		}else {
			nombre = true;
			System.out.println("La verificacion de nombre es: " + nombre);
		}

		//Revision del contructor de raza
		boolean raza;
		if(entidadDTO.getRaza().isEmpty() || !entidadDTO.getRaza().equals("Criolla")) {
			raza = false;
			System.out.println("La verificacion de raza es: " + raza);
		} else {
			raza = true;
			System.out.println("La verificacion de raza es: " + raza);
		}

		//Revision de constructor de edad
		boolean edad;
		if(entidadDTO.getEdad() == 0 || entidadDTO.getEdad() != 20){
			edad = false;
			System.out.println("La verificacion de edad es: " + edad);
		} else {
		 edad = true;
			System.out.println("La verificacion de edad es: " + edad);
		}

		//Revision del valor de peso
		boolean peso;
		if(entidadDTO.getPeso() == 0 || entidadDTO.getPeso() != 30) {
			peso = false;
			System.out.println("La verificacion de peso es: " + peso);
		} else {
			peso = true;
			System.out.println("La verificacion de peso es: " + peso);
		}

		//revision de forma de nariz
		boolean formaNariz;
		if(entidadDTO.getFormaNariz().isEmpty() || !entidadDTO.getFormaNariz().equals("Osico Alargado")) {
			formaNariz = false;
			System.out.println("La verificacion de Forma Nariz es: " + formaNariz);
		} else {
			formaNariz = true;
			System.out.println("La verificacion de Forma Nariz es: " + formaNariz);
		}




		pruebasHechas++;
	}

	@Test
	public void comprobartoString() {

		String formato = "Animal: " + "\n -Nombre: " + entidad.getNombre() + "\n -Raza: " + entidad.getRaza()
				+ "\n -Edad: " + entidad.getEdad() + "\n -Peso: " + entidad.getPeso() + "\n -FormaNariz: "
				+ entidad.getFormaNariz() + "\n -TIENE_DIENTES_CANINOS: "
				+ (entidad.isTIENE_DIENTES_CANINOS() ? "Si" : "No");

		System.out.println("Iniciando preubas de verificacion de ToString");
		System.out.println("------------------------------------------");

		boolean igualdadToString;
		if(entidad.toString().equals(formato)) {
			igualdadToString = true;
			System.out.println("La igualdad de ToString: " + igualdadToString);
		} else {
			igualdadToString = false;
			System.out.println("La igualdad de ToString: " + igualdadToString);
		}

		pruebasHechas++;
	}

	/*
	 * Fase 4 para despues de todas las pruebas, para que todos los valores vuelvan
	 * a lo mismo
	 */
	@After
	public void realizarDespuesDeCadaPrueba() {

		System.out.println("------------------------------------------");
		System.out.println(" ");
		System.out.println("Cantidad de preubas hechas: " + pruebasHechas);
		System.out.println(" ");
	}

	/*
	 * Es estatico y solo se jecuta una sola vez
	 */
	@AfterClass
	public static void finalDeTodasLasPruebas() {
		if(entidad.getNombre() == null || entidad.getNombre().equals("Max")) {
		}

	}

	/*
	 * Hacer prubeas unitarias
	 * 1- El constructor completo si esta funcionado
	 * 2- Hacer una pruena de identidad a DTO
	 * 3- Verificacion de ToString
	 * 4- De DTO a indentidad
	 */

}
