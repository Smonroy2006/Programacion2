package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.GatoDAO;
import co.edu.unbosque.model.persistence.PerroDAO;
import co.edu.unbosque.model.persistence.PezDAO;
import co.edu.unbosque.model.persistence.ReptilDAO;
import co.edu.unbosque.model.persistence.RuedorDAO;

/**
 * Esta clase se encarga de comunicar la informacion de modelo con el
 * controllador, simplificando la interaccion del programa
 */
public class ModelFacade {

	private PerroDAO perroDAO;
	private GatoDAO gatoDAO;
	private PezDAO pezDAO;
	private ReptilDAO reptilDAO;
	private RuedorDAO ruedorDAO;
	private ArrayList<Animal> listaAnimales;

	/**
	 * Constructor vacio donde se inicializan las variables de la clase
	 */
	public ModelFacade() {

		perroDAO = new PerroDAO();
		gatoDAO = new GatoDAO();
		pezDAO = new PezDAO();
		reptilDAO = new ReptilDAO();
		ruedorDAO = new RuedorDAO();
		listaAnimales = new ArrayList<Animal>();

	}

	/**
	 * Una funcion que no devuelve toda la informacion de cada animal, y los deja en
	 * un strign para imprimir
	 *
	 * @return salida, Un string con la informacion de todos los animales
	 */
	public String mostrarTodosLosAnimales() {

		listaAnimales.clear();
		listaAnimales.addAll(perroDAO.getListaPerros());
		listaAnimales.addAll(gatoDAO.getListaGatos());
		listaAnimales.addAll(pezDAO.getListaPeces());
		listaAnimales.addAll(reptilDAO.getListaReptil());
		listaAnimales.addAll(ruedorDAO.getListaRuedores());

		String salida = "";

		for (Animal a : listaAnimales) {
			salida += a.toString() + "\n";
		}

		return salida;
	}

	/**
	 * Funcion que nos permite reconocer todos los aniamles que su nombre empieza
	 * por una letra
	 *
	 * @param inicial
	 * @return salida, un string que nos dice los nombres de los animales que
	 *         empiezan por esa letra
	 */
	public String empiezaPorLaLetra(String inicial) {

		listaAnimales.clear();
		listaAnimales.addAll(perroDAO.getListaPerros());
		listaAnimales.addAll(gatoDAO.getListaGatos());
		listaAnimales.addAll(pezDAO.getListaPeces());
		listaAnimales.addAll(reptilDAO.getListaReptil());
		listaAnimales.addAll(ruedorDAO.getListaRuedores());

		String salida = "";
		for (Animal a : listaAnimales) {
			if (a.getNombre().toLowerCase().startsWith(inicial)) {
				salida += a.toString() + "\n";
			}
		}
		return salida;
	}

	// Getters and Setters

	public PerroDAO getPerroDAO() {
		return perroDAO;
	}

	public void setPerroDAO(PerroDAO perroDAO) {
		this.perroDAO = perroDAO;
	}

	public GatoDAO getGatoDAO() {
		return gatoDAO;
	}

	public void setGatoDAO(GatoDAO gatoDAO) {
		this.gatoDAO = gatoDAO;
	}

	public PezDAO getPezDAO() {
		return pezDAO;
	}

	public void setPezDAO(PezDAO pezDAO) {
		this.pezDAO = pezDAO;
	}

	public ReptilDAO getReptilDAO() {
		return reptilDAO;
	}

	public void setReptilDAO(ReptilDAO reptilDAO) {
		this.reptilDAO = reptilDAO;
	}

	public RuedorDAO getRuedorDAO() {
		return ruedorDAO;
	}

	public void setRuedorDAO(RuedorDAO ruedorDAO) {
		this.ruedorDAO = ruedorDAO;
	}

	public ArrayList<Animal> getListaAnimales() {
		return listaAnimales;
	}

	public void setListaAnimales(ArrayList<Animal> listaAnimales) {
		this.listaAnimales = listaAnimales;
	}

}
