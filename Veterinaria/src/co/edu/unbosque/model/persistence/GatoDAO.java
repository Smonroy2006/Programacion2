package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Gato;
import co.edu.unbosque.model.GatoDTO;

public class GatoDAO implements OperacionDAO<GatoDTO, Gato> {

	private ArrayList<Gato> listaGatos;
	private final String TEXT_FILE_NAME = "gato.csv";
	private final String SERIAL_FILE_NAME = "gato.dat";

	public GatoDAO() {

		listaGatos = new ArrayList<>();
		cargarDesdeArchivo();
	}

	@Override
	@Override
	public String showAll() {
		String rta = "";
		if (listaGatos.isEmpty()) {
			return "No hay mascotas en la lista";
		} else {
			for (Gato gato : listaGatos) {
				rta += gato;
			}
			return rta;
		}
	}

	@Override
	@Override
	public ArrayList<GatoDTO> getAll() {
		return DataMapper.listaGatoToListaGatoDTO(listaGatos);
	}

	@Override
	@Override
	public boolean add(GatoDTO newData) {

		if (find(DataMapper.gatoDTOToGato(newData)) == null) {
			listaGatos.add(DataMapper.gatoDTOToGato(newData));
			return true;
		} else {
			return false;

		}
	}

	@Override
	@Override
	public boolean delete(GatoDTO toDelete) {

		Gato found = find(DataMapper.gatoDTOToGato(toDelete));
		if (found != null) {
			return listaGatos.remove(found);
		} else {
			return false;
		}

	}

	@Override
	@Override
	public Gato find(Gato toFind) {
		Gato found = null;
		if (!listaGatos.isEmpty()) {
			for (Gato gato : listaGatos) {
				if (gato.getNombre().equals(toFind.getNombre())) {
					found = gato;
					return found;
				} else {
					continue; // las sig lineas desps de continue no se ejecutan, saltan a la sig iteracion
				}
			}
		} else {
			return null;
		}
		return null;
	} 

	@Override
	@Override
	public boolean update(GatoDTO previous, GatoDTO newData) {

		Gato found = find(DataMapper.gatoDTOToGato(previous));
		if (found != null) {
			listaGatos.remove(found);
			listaGatos.add(DataMapper.gatoDTOToGato(newData));
			return true;
		} else {
			return false;
		}

	}

	@Override
	@Override
	public int cantidad() {
		// TODO Auto-generated method stub
		return listaGatos.size();
	}

	public ArrayList<Gato> getListaGatos() {
		return listaGatos;
	}

	public void setListaGatos(ArrayList<Gato> listaGatos) {
		this.listaGatos = listaGatos;
	}

	@Override
	@Override
	public void escribirEnArchivo() {
		String contenido = "";

		for (int i = 0; i < listaGatos.size(); i++) {

			contenido += listaGatos.get(i).getNombre() + ";";
			contenido += listaGatos.get(i).getRaza() + ";";
			contenido += listaGatos.get(i).getEdad() + ";";
			contenido += listaGatos.get(i).getPeso() + ";";
			contenido += listaGatos.get(i).getPatronPelaje() + ";";
			contenido += listaGatos.get(i).isTienePelo() + "\n";

		}
		FileManager.escribirArchivoDeTexto(TEXT_FILE_NAME, contenido);

	}

	@Override
	@Override
	public void cargarDesdeArchivo() {
		String contenido = FileManager.leerArchivoDeTexto(TEXT_FILE_NAME);

		if (contenido.isBlank() || contenido.isEmpty()) {
			return;
		}

		String[] filas = contenido.split("\n");

		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			String nombre = columnas[0];
			String raza = columnas[1];
			int edad = Integer.parseInt(columnas[2]);
			float peso = Float.parseFloat(columnas[3]);
			String patronPelaje = columnas[4];
			boolean tienePelo = Boolean.parseBoolean(columnas[5]);

			listaGatos.add(new Gato(nombre, raza, edad, peso, patronPelaje, tienePelo));
		}

	}

	// Funciones para serializado

	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaGatos);

	}

	public void cargarDesdeArchivoSerializado() {

		listaGatos = (ArrayList<Gato>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);

		if (listaGatos == null) {
			listaGatos = new ArrayList<>();
		}
	}

	public int cantidadVocalesGato() {

		int a = 0;
		int e = 0;
		int i = 0;
		int o = 0;
		int u = 0;

		for (Gato gato : listaGatos) {

			String nombre = gato.getNombre();

			for (int x = 0; x < nombre.length(); x++) {

				char actual = nombre.toLowerCase().charAt(x);

				switch (actual) {
				case 'a':
					a++;
					break;
				case 'e':
					e++;
					break;
				case 'i':
					i++;
					break;
				case 'o':
					o++;
					break;
				case 'u':
					u++;
					break;
				default:
					break;
				}

			}

		}
		return (a + e + i + o + u);

	}



}