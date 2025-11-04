package co.edu.unbosque.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;

import co.edu.unbosque.model.Gato;
import co.edu.unbosque.model.GatoDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Perro;
import co.edu.unbosque.model.PerroDTO;
import co.edu.unbosque.model.Pez;
import co.edu.unbosque.model.PezDTO;
import co.edu.unbosque.model.Reptil;
import co.edu.unbosque.model.ReptilDTO;
import co.edu.unbosque.model.Ruedor;
import co.edu.unbosque.model.RuedorDTO;
import co.edu.unbosque.util.exception.NegativeNumberException;
import co.edu.unbosque.util.exception.OnlyBooleanException;
import co.edu.unbosque.util.exception.OnlyCharException;
import co.edu.unbosque.util.exception.OnlyStringException;
import co.edu.unbosque.view.Consola;

public class Controller {

	private Consola con;
	private ModelFacade mf;
	private Properties prop;

	public Controller() throws Exception {
		con = new Consola();
		mf = new ModelFacade();

	}

	public void run() {

		prop = new Properties();

		con.imprimirConSalto("Choose your Language");
		con.imprimirConSalto("1. Español:");
		con.imprimirConSalto("2. English");

		int opcionIdioma = 0;
		try {
			opcionIdioma = con.leerEntero();
		} catch (InputMismatchException e) {
			con.imprimirConSalto("Put a correct number");
			con.quemarLinea();
		}

		switch (opcionIdioma) {

		case 1: { // Español

			try {
				prop.load(new FileInputStream(new File("src/Archivos/textosespanol.properties")));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
			break;

		case 2: { // Ingles

			try {
				prop.load(new FileInputStream(new File("src/Archivos/textosingles.properties")));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			break;

		}

		cicloPrincipal: while (true) {

			// prop.getProperty("archivospropiedades.juego" + i + ".nombre");
			con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.separador"));
			con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.bienvenida"));

			// Resgistrar un perro
			con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.registrar"));

			// Mostrar todos los perros
			con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.mostrar"));

			// Elinar un animal
			con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.eliminar"));

			// Actualizar datos
			con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.actualizar"));

			// Mostrar todos los animales
			con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.mostrartodos"));

			// Busqueda
			con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.busqueda"));

			// Meotodo de reproduccion
			con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.reproduccion"));

			// Metodo de alimentacion
			con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.alimentacion"));

			// Salir
			con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.salir"));

			int opcion1 = 0;
			try {
				opcion1 = con.leerEntero();
			} catch (InputMismatchException e) {
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
				con.quemarLinea();
			}

			switch (opcion1) { // Registrar el perro
			case 1: {

				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.registrar"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.perro"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.gato"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.pez"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.reptil"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.ruedor"));
				int registrar;// falt
				while (true) {
					try {
						con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.numeroanimal"));
						registrar = con.leerEntero();
						ExceptionChecker.checkNegativeNumber(registrar);

						break;
					} catch (InputMismatchException e) {
						con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
						con.quemarLinea();
					} catch (NegativeNumberException e) {
						con.imprimirConSalto(e.getMessage());
					}
				}

				switch (registrar) {

				case 1: { // Perro

					int cantidadRegistro = 0;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.cantidadcrear"));
							cantidadRegistro = con.leerEntero();
							ExceptionChecker.checkNegativeNumber(cantidadRegistro);
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					for (int i = 0; i < cantidadRegistro; i++) {

						String nombre;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.nombre"));
								con.quemarLinea();
								nombre = con.leerLinea();
								ExceptionChecker.CheckOnlyString(nombre);
								break;
							} catch (OnlyStringException e) {
								con.imprimirConSalto(e.getMessage());
							}

						}

						String raza;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.raza"));
								raza = con.leerLinea();
								ExceptionChecker.CheckOnlyString(raza);
								break;
							} catch (OnlyStringException e) {
								con.imprimirConSalto(e.getMessage());
							}
						}

						int edad;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.edad"));
								edad = con.leerEntero();
								break;
							} catch (InputMismatchException e) {
								con.imprimirConSalto(
										prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
								con.quemarLinea();
							}
						}

						float peso;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.peso"));
								peso = con.leerFloat();
								break;
							} catch (InputMismatchException e) {
								con.imprimirConSalto(
										prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
								con.quemarLinea();
							}
						}

						String formaNariz;

						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.formanariz"));
								con.quemarLinea();
								formaNariz = con.leerLinea();
								ExceptionChecker.CheckOnlyString(formaNariz);
								break;
							} catch (OnlyStringException e) {
								con.imprimirConSalto(e.getMessage());
							}

						}
						mf.getPerroDAO().add(new PerroDTO(nombre, raza, edad, peso, formaNariz));

						con.imprimirConSalto(prop.getProperty("archivospropiedades.menueventos.creado"));
					}
					break;
				}

				case 2: { // Gato

					int cantidadRegistro = 0;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.cantidadcrear"));
							cantidadRegistro = con.leerEntero();
							ExceptionChecker.checkNegativeNumber(cantidadRegistro);
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					for (int i = 0; i < cantidadRegistro; i++) {

						String nombre;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.nombre"));
								con.quemarLinea();
								nombre = con.leerLinea();
								ExceptionChecker.CheckOnlyString(nombre);
								break;
							} catch (OnlyStringException e) {
								con.imprimirConSalto(e.getMessage());
							}

						}

						String raza;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.raza"));
								raza = con.leerLinea();
								ExceptionChecker.CheckOnlyString(raza);
								break;
							} catch (OnlyStringException e) {
								con.imprimirConSalto(e.getMessage());
							}
						}

						int edad;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.edad"));
								edad = con.leerEntero();
								break;
							} catch (InputMismatchException e) {
								con.imprimirConSalto(
										prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
								con.quemarLinea();
							}
						}

						float peso;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.peso"));
								peso = con.leerFloat();
								break;
							} catch (InputMismatchException e) {
								con.imprimirConSalto(
										prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
								con.quemarLinea();
							}
						}

						String cadena;
						boolean tienePelo;

						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.tipopelo"));
								cadena = con.leerLinea();
								ExceptionChecker.checkOnlyBoolean(cadena);
								tienePelo = Boolean.parseBoolean(cadena);
								break;
							} catch (OnlyBooleanException e) {
								con.imprimirConSalto(e.getMessage());
							}
						}

						String patronPelo;
						while (true) {
							try {
								con.imprimirConSalto(
										prop.getProperty("archivospropiedades.menumodificar.patronpelaje"));
								patronPelo = con.leerLinea();
								ExceptionChecker.CheckOnlyString(patronPelo);
								break;
							} catch (OnlyStringException e) {
								con.imprimirConSalto(e.getMessage());
							}
						}

						mf.getGatoDAO().add(new GatoDTO(nombre, raza, edad, peso, patronPelo, tienePelo));

						con.imprimirConSalto(prop.getProperty("archivospropiedades.menueventos.creado"));

					}
					break;
				}

				case 3: { // Pez

					int cantidadRegistro = 0;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.cantidadcrear"));
							cantidadRegistro = con.leerEntero();
							ExceptionChecker.checkNegativeNumber(cantidadRegistro);
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					for (int i = 0; i < cantidadRegistro; i++) {

						String nombre;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.nombre"));
								nombre = con.leerLinea();
								ExceptionChecker.CheckOnlyString(nombre);
								break;
							} catch (OnlyStringException e) {
								con.imprimirConSalto(e.getMessage());
							}
						}

						String raza;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.raza"));
								raza = con.leerLinea();
								ExceptionChecker.CheckOnlyString(raza);
								break;
							} catch (OnlyStringException e) {
								con.imprimirConSalto(e.getMessage());
							}
						}

						int edad;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.edad"));
								edad = con.leerEntero();
								break;
							} catch (InputMismatchException e) {
								con.imprimirConSalto(
										prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
								con.quemarLinea();
							}
						}

						float peso;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.peso"));
								peso = con.leerFloat();
								break;
							} catch (InputMismatchException e) {
								con.imprimirConSalto(
										prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
								con.quemarLinea();
							}
						}

						String esVenenosoCadena;
						boolean esVenenoso;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.esvenenoso"));
								esVenenosoCadena = con.leerLinea();
								ExceptionChecker.checkOnlyBoolean(esVenenosoCadena);
								esVenenoso = Boolean.parseBoolean(esVenenosoCadena);
								break;
							} catch (OnlyBooleanException e) {
								con.imprimirConSalto(e.getMessage());
							}
						}

						String esAvisalCadena;
						boolean esAvisal;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.esavisal"));
								esAvisalCadena = con.leerLinea();
								ExceptionChecker.checkOnlyBoolean(esAvisalCadena);
								esAvisal = Boolean.parseBoolean(esAvisalCadena);
								break;
							} catch (OnlyBooleanException e) {
								con.imprimirConSalto(e.getMessage());
							}
						}

						mf.getPezDAO().add(new PezDTO(nombre, raza, edad, peso, esVenenoso, esAvisal));

						con.imprimirConSalto(prop.getProperty("archivospropiedades.menueventos.creado"));
					}
					break;
				}

				case 4: { // Reptil

					int cantidadRegistro = 0;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.cantidadcrear"));
							cantidadRegistro = con.leerEntero();
							ExceptionChecker.checkNegativeNumber(cantidadRegistro);
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					for (int i = 0; i < cantidadRegistro; i++) {

						String nombre;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.nombre"));
								nombre = con.leerLinea();
								ExceptionChecker.CheckOnlyString(nombre);
								break;
							} catch (OnlyStringException e) {
								con.imprimirConSalto(e.getMessage());
							}
						}

						String raza;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.raza"));
								raza = con.leerLinea();
								ExceptionChecker.CheckOnlyString(raza);
								break;
							} catch (OnlyStringException e) {
								con.imprimirConSalto(e.getMessage());
							}
						}

						int edad;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.edad"));
								edad = con.leerEntero();
								break;
							} catch (InputMismatchException e) {
								con.imprimirConSalto(
										prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
								con.quemarLinea();
							}
						}

						float peso;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.peso"));
								peso = con.leerFloat();
								break;
							} catch (InputMismatchException e) {
								con.imprimirConSalto(
										prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
								con.quemarLinea();
							}
						}

						String esVenenosoCadena;
						boolean esVenenoso;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.esvenenoso"));
								esVenenosoCadena = con.leerLinea();
								ExceptionChecker.checkOnlyBoolean(esVenenosoCadena);
								esVenenoso = Boolean.parseBoolean(esVenenosoCadena);
								break;
							} catch (OnlyBooleanException e) {
								con.imprimirConSalto(e.getMessage());
							}
						}

						con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.tiempomudapiel"));
						int tiempoDeMudaDePiel = con.leerEntero();

						mf.getReptilDAO().add(new ReptilDTO(nombre, raza, edad, peso, esVenenoso, tiempoDeMudaDePiel));

						con.imprimirConSalto(prop.getProperty("archivospropiedades.menueventos.creado"));

					}
					break;
				}

				case 5: { // Ruedor

					int cantidadRegistro = 0;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.cantidadcrear"));
							cantidadRegistro = con.leerEntero();
							ExceptionChecker.checkNegativeNumber(cantidadRegistro);
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					for (int i = 0; i < cantidadRegistro; i++) {

						String nombre;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.nombre"));
								con.quemarLinea();
								nombre = con.leerLinea();
								ExceptionChecker.CheckOnlyString(nombre);
								break;
							} catch (OnlyStringException e) {
								con.imprimirConSalto(e.getMessage());
							}
						}

						String raza;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.raza"));
								raza = con.leerLinea();
								ExceptionChecker.CheckOnlyString(raza);
								break;
							} catch (OnlyStringException e) {
								con.imprimirConSalto(e.getMessage());
							}
						}

						int edad;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.edad"));
								edad = con.leerEntero();
								break;
							} catch (InputMismatchException e) {
								con.imprimirConSalto(
										prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
								con.quemarLinea();
							}
						}

						float peso;
						while (true) {
							try {
								con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.peso"));
								peso = con.leerFloat();
								break;
							} catch (InputMismatchException e) {
								con.imprimirConSalto(
										prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
								con.quemarLinea();
							}
						}

						int tamanoDiente;
						while (true) {
							try {
								con.imprimirConSalto(
										prop.getProperty("archivospropiedades.menumodificar.tamañodiente"));
								tamanoDiente = con.leerEntero();
								break;
							} catch (InputMismatchException e) {
								con.imprimirConSalto(
										prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
								con.quemarLinea();
							}
						}

						String tipoMadriguera;
						while (true) {
							try {
								con.imprimirConSalto(
										prop.getProperty("archivospropiedades.menumodificar.tipomadriguera"));
								con.quemarLinea();
								tipoMadriguera = con.leerLinea();
								ExceptionChecker.CheckOnlyString(tipoMadriguera);
								break;
							} catch (OnlyStringException e) {
								con.imprimirConSalto(e.getMessage());
							}
						}

						mf.getRuedorDAO().add(new RuedorDTO(nombre, raza, edad, peso, tamanoDiente, tipoMadriguera));
						con.imprimirConSalto(prop.getProperty("archivospropiedades.menueventos.creado"));
					}

					break;

				}

				}

				break;
			}

			case 2: { // Mostrar los animales guardados

				con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.mostrar"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.numeroanimal"));

				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.perro"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.gato"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.pez"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.reptil"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.ruedor"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.todos"));

				int mostrar;
				while (true) {
					try {
						mostrar = con.leerEntero();
						ExceptionChecker.checkNegativeNumber(mostrar);
						break;
					} catch (InputMismatchException e) {
						con.imprimirConSalto("Ingrese un numero valido");
						con.quemarLinea();
					} catch (NegativeNumberException e) {
						con.imprimirConSalto(e.getMessage());
					}
				}

				switch (mostrar) {

				case 1: { // perro

					con.imprimirConSalto(prop.getProperty("archivospropiedades.meneventos.mostrar"));

					con.imprimirConSalto(mf.getPerroDAO().showAll());
					break;
				}

				case 2: { // Gato

					con.imprimirConSalto(prop.getProperty("archivospropiedades.meneventos.mostrar"));

					con.imprimirConSalto(mf.getGatoDAO().showAll());

					break;
				}

				case 3: { // pez

					con.imprimirConSalto(prop.getProperty("archivospropiedades.meneventos.mostrar"));

					con.imprimirConSalto(mf.getPezDAO().showAll());

					break;
				}

				case 4: { // Reptil

					con.imprimirConSalto(prop.getProperty("archivospropiedades.meneventos.mostrar"));
					con.imprimirConSalto(mf.getReptilDAO().showAll());

					break;
				}

				case 5: { // Ruedor

					con.imprimirConSalto(prop.getProperty("archivospropiedades.meneventos.mostrar"));
					con.imprimirConSalto(mf.getReptilDAO().showAll());

					break;
				}

				case 6: { // Todos

					con.imprimirConSalto(prop.getProperty("archivospropiedades.meneventos.mostrar"));
					con.imprimirConSalto("");
					con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.separadorperro"));
					con.imprimirConSalto("");

					con.imprimirConSalto(mf.getPerroDAO().showAll());

					con.imprimirConSalto("");
					con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.separadorgato"));
					con.imprimirConSalto("");

					con.imprimirConSalto(mf.getGatoDAO().showAll());

					con.imprimirConSalto("");
					con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.separadorpez"));
					con.imprimirConSalto("");

					con.imprimirConSalto(mf.getPezDAO().showAll());

					con.imprimirConSalto("");
					con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.separadorreptil"));
					con.imprimirConSalto("");

					con.imprimirConSalto(mf.getReptilDAO().showAll());

					con.imprimirConSalto("");
					con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.separadorruedor"));
					con.imprimirConSalto("");
					con.imprimirConSalto(mf.getReptilDAO().showAll());

					break;
				}

				}

				break;
			}

			case 3: { // Eliminar datos

				con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.eliminar"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.numeroanimal"));

				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.perro"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.gato"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.pez"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.perro"));
				con.imprimirConSalto("5. Ruedor");

				int eliminar;
				while (true) {
					try {
						eliminar = con.leerEntero();
						ExceptionChecker.checkNegativeNumber(eliminar);
						break;
					} catch (InputMismatchException e) {
						con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
						con.quemarLinea();
					} catch (NegativeNumberException e) {
						con.imprimirConSalto(e.getMessage());
					}
				}

				switch (eliminar) {

				case 1: { // Perro
					String nombre;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.eliminaranimal"));
							nombre = con.leerLinea();
							ExceptionChecker.CheckOnlyString(nombre);
							break;
						} catch (OnlyStringException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.nostring"));
							con.quemarLinea();
						}
					}

					if (mf.getPerroDAO().delete(new PerroDTO(nombre, null, 0, 0, null))) {
						con.imprimirConSalto(prop.getProperty("archivospropiedades.menueventos.eliminado"));
					} else {
						con.imprimirConSalto(prop.getProperty("archivospropiedades.menueventos.noeliminado"));

					}
				}
					break;

				case 2: { // Gato
					String nombre;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.eliminaranimal"));
							nombre = con.leerLinea();
							ExceptionChecker.CheckOnlyString(nombre);
							break;
						} catch (OnlyStringException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.nostring"));
							con.quemarLinea();
						}
					}

					if (mf.getGatoDAO().delete(new GatoDTO(nombre, null, 0, 0, null, false))) {
						con.imprimirConSalto(prop.getProperty("archivospropiedades.menueventos.eliminado"));
					} else {
						con.imprimirConSalto(prop.getProperty("archivospropiedades.menueventos.noeliminado"));
					}

				}
					break;

				case 3: { // Pez
					String nombre;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.eliminaranimal"));
							nombre = con.leerLinea();
							ExceptionChecker.CheckOnlyString(nombre);
							break;
						} catch (OnlyStringException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.nostring"));
							con.quemarLinea();
						}
					}

					if (mf.getPezDAO().delete(new PezDTO(nombre, null, 0, 0, false, false))) {
						con.imprimirConSalto(prop.getProperty("archivospropiedades.menueventos.eliminado"));

					} else {
						con.imprimirConSalto(prop.getProperty("archivospropiedades.menueventos.noeliminado"));
					}
				}

					break;
				case 4: { // Reptil
					String nombre;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.eliminaranimal"));
							nombre = con.leerLinea();
							ExceptionChecker.CheckOnlyString(nombre);
							break;
						} catch (OnlyStringException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						}
					}

					if(mf.get) {

					}

				}
					break;

				case 5: { // Reptil

					con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.numeroanimal"));

					int valor = con.leerEntero();
					int index = (valor - 1);

					/*
					 * TODO if (mf.getRuedorDAO().eliminar(index) >= 1) {
					 *
					 * mf.getRuedorDAO().eliminar(index); con.imprimirConSalto(prop.getProperty(
					 * "archivospropiedades.menueventos.eliminado"));
					 *
					 * } else { con.imprimirConSalto(prop.getProperty(
					 * "archivospropiedades.menueventos.noeliminado")); }
					 */
				}
					break;

				}
				break;
			}

			case 4: { // Actualizar datos

				con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.actualizar"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.numeroanimal"));

				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.perro"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.gato"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.pez"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.reptil"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.ruedor"));

				int actualizar;
				while (true) {
					try {
						actualizar = con.leerEntero();
						ExceptionChecker.checkNegativeNumber(actualizar);
						break;
					} catch (InputMismatchException e) {
						con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
						con.quemarLinea();
					} catch (NegativeNumberException e) {
						con.imprimirConSalto(e.getMessage());
					}
				}
				switch (actualizar) {

				case 1: { // Perro

					int valor;
					int index;
					while (true) {
						try {
							con.imprimirConSalto(
									prop.getProperty("archivospropiedades.menupreguntas.cantidadactualizar"));
							valor = con.leerEntero();
							index = (valor - 1);
							ExceptionChecker.checkNegativeNumber(valor);
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					String nombre;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.nombre"));
							con.quemarLinea();
							nombre = con.leerLinea();
							ExceptionChecker.CheckOnlyString(nombre);
							break;
						} catch (OnlyStringException e) {
							con.imprimirConSalto(e.getMessage());
						}

					}

					String raza;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.raza"));
							raza = con.leerLinea();
							ExceptionChecker.CheckOnlyString(raza);
							break;
						} catch (OnlyStringException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					int edad;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.edad"));
							edad = con.leerEntero();
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						}
					}

					float peso;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.peso"));
							peso = con.leerFloat();
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						}
					}

					String formaNariz;

					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.formanariz"));
							con.quemarLinea();
							formaNariz = con.leerLinea();
							ExceptionChecker.CheckOnlyString(formaNariz);
							break;
						} catch (OnlyStringException e) {
							con.imprimirConSalto(e.getMessage());
						}

					}

					Perro perroActualizado = new Perro(nombre, raza, edad, peso, formaNariz);

					/*
					 * TODO if (mf.getPerroDAO().actualizar(index, perroActualizado) >= 1) {
					 * con.imprimirConSalto(prop.getProperty(
					 * "archivospropiedades.menueventos.actualizado")); } else {
					 * con.imprimirConSalto(prop.getProperty(
					 * "archivospropiedades.menumodificar.noactualizad")); }
					 */
				}
					break;

				case 2: { // Gato
					int valor;
					int index;
					while (true) {
						try {
							con.imprimirConSalto(
									prop.getProperty("archivospropiedades.menupreguntas.cantidadactualizar"));
							valor = con.leerEntero();
							index = (valor - 1);
							ExceptionChecker.checkNegativeNumber(valor);
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					String nombre;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.nombre"));
							con.quemarLinea();
							nombre = con.leerLinea();
							ExceptionChecker.CheckOnlyString(nombre);
							break;
						} catch (OnlyStringException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					String raza;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.raza"));
							raza = con.leerLinea();
							ExceptionChecker.CheckOnlyString(raza);
							break;
						} catch (OnlyStringException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					int edad;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.edad"));
							edad = con.leerEntero();
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						}
					}

					float peso;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.peso"));
							peso = con.leerFloat();
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						}
					}

					String patronPelaje;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.patronpelaje"));
							con.quemarLinea();
							patronPelaje = con.leerLinea();
							ExceptionChecker.CheckOnlyString(patronPelaje);
							break;
						} catch (OnlyStringException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					String cadena;
					boolean tienePelo;

					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.tipopelo"));
							cadena = con.leerLinea();
							ExceptionChecker.checkOnlyBoolean(cadena);
							tienePelo = Boolean.parseBoolean(cadena);
							break;
						} catch (OnlyBooleanException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					Gato gatoActualizado = new Gato(nombre, raza, edad, peso, patronPelaje, tienePelo);

					/*
					 * TODO if (mf.getGatoDAO().update(index, gatoActualizado) >= 1) {
					 * con.imprimirConSalto(prop.getProperty(
					 * "archivospropiedades.menueventos.actualizar")); } else {
					 * con.imprimirConSalto(prop.getProperty(
					 * "archivospropiedades.menuerrores.noactualizar")); }
					 */
				}
					break;

				case 3: { // Pez
					int valor;
					int index;
					while (true) {
						try {
							con.imprimirConSalto(
									prop.getProperty("archivospropiedades.menupreguntas.cantidadactualizar"));
							valor = con.leerEntero();
							index = (valor - 1);
							ExceptionChecker.checkNegativeNumber(valor);
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					String nombre;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.nombre"));
							con.quemarLinea();
							nombre = con.leerLinea();
							ExceptionChecker.CheckOnlyString(nombre);
							break;
						} catch (OnlyStringException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					String raza;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.raza"));
							raza = con.leerLinea();
							ExceptionChecker.CheckOnlyString(raza);
							break;
						} catch (OnlyStringException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					int edad;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.edad"));
							edad = con.leerEntero();
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						}
					}

					float peso;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.peso"));
							peso = con.leerFloat();
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						}
					}

					String esVenenosoCadena;
					boolean esVenenoso;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.esvenenoso"));
							esVenenosoCadena = con.leerLinea();
							ExceptionChecker.checkOnlyBoolean(esVenenosoCadena);
							esVenenoso = Boolean.parseBoolean(esVenenosoCadena);
							break;
						} catch (OnlyBooleanException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					String esAvisalCadena;
					boolean esAvisal;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.esavisal"));
							esAvisalCadena = con.leerLinea();
							ExceptionChecker.checkOnlyBoolean(esAvisalCadena);
							esAvisal = Boolean.parseBoolean(esAvisalCadena);
							break;
						} catch (OnlyBooleanException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					Pez pezActualizado = new Pez(nombre, raza, edad, peso, esVenenoso, esAvisal);

					/*
					 * TODO if (mf.getPezDAO().actualizar(index, pezActualizado) >= 1) {
					 * con.imprimirConSalto(prop.getProperty(
					 * "archivospropiedades.menueventos.actualizado")); } else {
					 * con.imprimirConSalto(prop.getProperty(
					 * "archivospropiedades.menueventos.noactualizado")); }
					 */
				}
					break;

				case 4: { // Reptil
					int valor;
					int index;
					while (true) {
						try {
							con.imprimirConSalto(
									prop.getProperty("archivospropiedades.menupreguntas.cantidadactualizar"));
							valor = con.leerEntero();
							index = (valor - 1);
							ExceptionChecker.checkNegativeNumber(valor);
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					String nombre;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.nombre"));
							con.quemarLinea();
							nombre = con.leerLinea();
							ExceptionChecker.CheckOnlyString(nombre);
							break;
						} catch (OnlyStringException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					String raza;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.raza"));
							raza = con.leerLinea();
							ExceptionChecker.CheckOnlyString(raza);
							break;
						} catch (OnlyStringException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					int edad;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.edad"));
							edad = con.leerEntero();
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
						}
					}

					float peso;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.peso"));
							peso = con.leerFloat();
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
						}
					}

					String esVenenosoCadena;
					boolean esVenenoso;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.esvenenoso"));
							esVenenosoCadena = con.leerLinea();
							ExceptionChecker.checkOnlyBoolean(esVenenosoCadena);
							esVenenoso = Boolean.parseBoolean(esVenenosoCadena);
							break;
						} catch (OnlyBooleanException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					int tiempoDeMudaDePiel;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.tiempomudapiel"));
							tiempoDeMudaDePiel = con.leerEntero();
							ExceptionChecker.checkNegativeNumber(tiempoDeMudaDePiel);
							break;
						} catch (NegativeNumberException e) {
							con.imprimirConSalto(e.getMessage());
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						}
					}

					Reptil reptilActualizado = new Reptil(nombre, raza, edad, peso, esVenenoso, tiempoDeMudaDePiel);

					/*
					 * TODO if (mf.getReptilDAO().actualizar(index, reptilActualizado) >= 1) {
					 * con.imprimirConSalto(prop.getProperty(
					 * "archivospropiedades.menueventos.actualizar")); } else {
					 * con.imprimirConSalto(prop.getProperty(
					 * "archivospropiedades.menuevetnos.noactualizar")); }
					 */
				}
					break;

				case 5: { // Roedor
					int valor;
					int index;
					while (true) {
						try {
							con.imprimirConSalto(
									prop.getProperty("archivospropiedades.menupreguntas.cantidadactualizar"));
							valor = con.leerEntero();
							index = (valor - 1);
							ExceptionChecker.checkNegativeNumber(valor);
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					String nombre;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.nombre"));
							con.quemarLinea();
							nombre = con.leerLinea();
							ExceptionChecker.CheckOnlyString(nombre);
							break;
						} catch (OnlyStringException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					String raza;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.raza"));
							raza = con.leerLinea();
							ExceptionChecker.CheckOnlyString(raza);
							break;
						} catch (OnlyStringException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					int edad;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.edad"));
							edad = con.leerEntero();
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						}
					}

					float peso;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.peso"));
							peso = con.leerFloat();
							break;
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						}
					}

					int tamanoDiente;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.tamañodiente"));
							tamanoDiente = con.leerEntero();
							ExceptionChecker.checkNegativeNumber(tamanoDiente);
							break;
						} catch (NegativeNumberException e) {
							con.imprimirConSalto(e.getMessage());
						} catch (InputMismatchException e) {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
							con.quemarLinea();
						}
					}

					String tipoMadriguera;
					while (true) {
						try {
							con.imprimirConSalto(prop.getProperty("archivospropiedades.menumodificar.tipomadriguera"));
							con.quemarLinea();
							tipoMadriguera = con.leerLinea();
							ExceptionChecker.CheckOnlyString(tipoMadriguera);
							break;
						} catch (OnlyStringException e) {
							con.imprimirConSalto(e.getMessage());
						}
					}

					Ruedor ruedorActualizado = new Ruedor(nombre, raza, edad, peso, tamanoDiente, tipoMadriguera);

					/*
					 * TODOif (mf.getRuedorDAO().actualizar(index, ruedorActualizado) >= 1) {
					 * con.imprimirConSalto(prop.getProperty(
					 * "archivospropiedades.menueventos.actualizado")); } else {
					 * con.imprimirConSalto(prop.getProperty(
					 * "archivospropiedades.menumodificar.noactualizado")); }
					 */
				}
					break;

				}

			}
				break;

			case 5: {

				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuavisos.mostrar"));

				if (mf.getListaAnimales().isEmpty()) {
					con.imprimirConSalto(mf.mostrarTodosLosAnimales());
				} else {
					con.imprimirConSalto(mf.mostrarTodosLosAnimales());
				}
				break;
			}

			case 6: {

				String letra;

				while (true) {
					try {
						con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.buscar"));
						con.quemarLinea();
						letra = con.leerPalabra();
						ExceptionChecker.checkOnlyOneChar(letra);
						ExceptionChecker.checkOnlyChar(letra);
						break;
					} catch (OnlyCharException e) {
						con.imprimirConSalto(e.getMessage());
					}
				}
				con.imprimirConSalto(prop
						.getProperty("archivospropiedades.menuavisos.empiezaporlaletra" + mf.empiezaPorLaLetra(letra)));
			}

			case 7: {

				con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.reproduccion"));

				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.perro"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.gato"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.pez"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.reptil"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.ruedor"));

				int metodoReproduccion = 0;
				try {
					metodoReproduccion = con.leerEntero();
				} catch (InputMismatchException e) {
					con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
					con.quemarLinea();
				}

				switch (metodoReproduccion) {
				case 1: {

					con.imprimirConSalto(mf.getPerroDAO().getListaPerros().get(0).reproducirse());

					break;
				}

				case 2: {

					con.imprimirConSalto(mf.getGatoDAO().getListaGatos().get(0).reproducirse());

					break;
				}

				case 3: {

					con.imprimirConSalto(mf.getPezDAO().getListaPeces().get(0).reproducirse());

					break;
				}
				case 4: {

					con.imprimirConSalto(mf.getReptilDAO().getListaReptil().get(0).reproducirse());

					break;
				}
				case 5: {

					con.imprimirConSalto(mf.getRuedorDAO().getListaRuedores().get(0).reproducirse());

					break;
				}

				}
				break;
			}

			case 8: {

				con.imprimirConSalto(prop.getProperty("archivospropiedades.menupreguntas.alimentacion"));

				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.perro"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.gato"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.pez"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.reptil"));
				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuanimales.ruedor"));

				int metodoAlimentacion = 0;
				try {
					metodoAlimentacion = con.leerEntero();
				} catch (InputMismatchException e) {
					con.imprimirConSalto(prop.getProperty("archivospropiedades.menuerrores.numeroinvalido"));
					con.quemarLinea();
				}
				switch (metodoAlimentacion) {
				case 1: {

					con.imprimirConSalto(mf.getPerroDAO().getListaPerros().get(0).alimentarse());

					break;
				}

				case 2: {

					con.imprimirConSalto(mf.getGatoDAO().getListaGatos().get(0).alimentarse());

					break;
				}

				case 3: {

					con.imprimirConSalto(mf.getPezDAO().getListaPeces().get(0).alimentarse());

					break;
				}
				case 4: {

					con.imprimirConSalto(mf.getReptilDAO().getListaReptil().get(0).alimentarse());

					break;
				}
				case 5: {

					con.imprimirConSalto(mf.getRuedorDAO().getListaRuedores().get(0).alimentarse());

					break;
				}

				}
				break;
			}

			case 9: // Salir del programa

				con.imprimirConSalto(prop.getProperty("archivospropiedades.menuprincipal.despedida"));

				break cicloPrincipal;

			default: {
				break;
			}
			}
		}
	}

}