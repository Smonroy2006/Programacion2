package co.edu.unbosque.controller;

import co.edu.unbosque.util.exception.NegativeNumberException;
import co.edu.unbosque.util.exception.OnlyBooleanException;
import co.edu.unbosque.util.exception.OnlyCharException;
import co.edu.unbosque.util.exception.OnlyNumbersException;
import co.edu.unbosque.util.exception.OnlyStringException;

/**
 * Esta clase se encarga de manejar las excepciones propias
 */
public class ExceptionChecker {

	/**
	 * Esta excepcion solo permite letras, no numeros, no simbolos....
	 *
	 * @param nombre
	 * @throws OnlyStringException
	 */
	public static void CheckOnlyString(String nombre) throws OnlyStringException {
		// Con una expresion regular revisa que si el nombre no es parecido, "Matches"
		// revisa que los caracteres digitados concuerden con la escpresion regular, en
		// caso de no hacerlo, arroja un excepcion
		if (!nombre.matches("^[a-zA-Z ]+$")) {
			throw new OnlyStringException();
		}
	}

	/**
	 * Esta excepcion se encarga de verificar si el programa tiene numeros, y solo
	 * permite el paso de estos. Y solo permite ingresar datos de tipo float
	 *
	 * @param numero
	 * @throws OnlyNumbersException
	 */
	public static void checkOnlyFloats(float numero) throws OnlyNumbersException {
		// Revisa dos cosas, que cuando se digite el numero permita numeros positivos y
		// negativos, pero no deja pasar otra cosa que no se pueda comparar con un
		// numero. Pero ademas, revisa que el dato sea un float
		if (numero > 0 || numero < 0) {
			throw new OnlyNumbersException();
		}
	}

	/**
	 * Esta Excepcion revisa si el numero es negativo y acciona el try catch, solo
	 * permite numeros positivos
	 *
	 * @param entero
	 * @throws NegativeNumberException
	 */
	public static void checkNegativeNumber(int entero) throws NegativeNumberException {
		// Revisa si el numero es menor a 0, osea negativo, y lanza un error, ademas
		// tampoco deja pasar cualquier otra cosa que no sea un numero
		if (entero < 0) {
			throw new NegativeNumberException();
		}
	}

	/**
	 * Esta excepcion solo permite pasar numeros, no deja que ningun caraceter pase,
	 * y verifica que el dato sea un int
	 *
	 * @param numero
	 * @throws OnlyNumbersException
	 */
	public static void checkOnlyNumbers(int numero) throws OnlyNumbersException {
		// Con un if revisa dos casos, que el numero sea mayor o menor que 0, eso
		// significa que deja pasar todo que se pueda comparar con un numero y sea del
		// tipo int
		if (numero > 0 || numero < 0) {
			throw new OnlyNumbersException();
		}
	}

	/**
	 * Esta excepcion revisa si el lo ingresado es un boolean, con una
	 * modificiacion. En vez de True / False, reconoce Si / No
	 *
	 * @param booleano
	 * @throws OnlyBooleanException
	 */
	public static void checkOnlyBoolean(String booleano) throws OnlyBooleanException {
		// Revisa que el dato ingresado sea un booleano, ignoradon todas las
		// mayusuculas, y las compara con el string Si || No, ya que el programa esta
		// adaptado para que pueda resivir esos datos
		if (booleano.toLowerCase() == "si" || booleano.toLowerCase() == "no") {
			throw new OnlyBooleanException();
		}
	}

	/**
	 * Esta excepcion verifica si el dato registrado solo es un caracter, cualquier
	 * otro caracter no lo deja pasar
	 *
	 * @param letra
	 * @throws OnlyCharException
	 */
	public static void checkOnlyOneChar(String letra) throws OnlyCharException {
		// Esta excepcion revisa que el langotud del dato ingresado solo sea uno, con
		// .lenght y que si no es igual a 1. ERROR
		if (letra.length() != 1) {
			throw new OnlyCharException();
		}
	}

	/**
	 * Este se encarga de mirar si el dato que se esta revisando sea un solo un
	 * caracterer
	 *
	 * @param letra
	 * @throws OnlyCharException
	 */
	public static void checkOnlyChar(String letra) throws OnlyCharException {
		// Este verifica que los datos sean un string y solo un string
		if (!letra.matches("^[a-zA-Z]+$")) {
			throw new OnlyCharException();
		}
	}

}
