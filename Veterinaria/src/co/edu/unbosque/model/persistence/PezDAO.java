package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Pez;
import co.edu.unbosque.model.PezDTO;

public  class PezDAO implements OperacionDAO<PezDTO, Pez> {

	private ArrayList<Pez> listaPeces;
	private final String TEXT_FILE_NAME = "pez.csv";
	private final String SERIAL_FILE_NAME = "pez.dat";


	public PezDAO() {

		listaPeces = new ArrayList<>();
		cargarDesdeArchivo();

	}

	@Override
	@Override
	public String showAll() {
		String rta = "";
		if (listaPeces.isEmpty()) {
			return "No hay mascotas en la lista";
		} else {
			for (Pez pez : listaPeces) {
				rta += pez;
			}
			return rta;
		}
	}



	@Override
	@Override
	public ArrayList<PezDTO> getAll() {
		return DataMapper.listaPezToListaPezDTO(listaPeces);
	}



	@Override
	@Override
	public boolean add(PezDTO newData) {

		if (find(DataMapper.pezDTOToPez(newData)) == null) {
			listaPeces.add(DataMapper.pezDTOToPez(newData));
			return true;
		} else {
			return false;
		}

	}



	@Override
	@Override
	public boolean delete(PezDTO toDelete) {
		Pez found = find(DataMapper.pezDTOToPez(toDelete));
		if (found != null) {
			return listaPeces.remove(found);
		} else {
			return false;
		}
	}



	@Override
	@Override
	public Pez find(Pez toFind) {
		Pez found = null;
		if (!listaPeces.isEmpty()) {
			for (Pez pez : listaPeces) {
				if (pez.getNombre().equals(toFind.getNombre())) {
					found = pez;
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
	public boolean update(PezDTO previous, PezDTO newData) {
		Pez found = find(DataMapper.pezDTOToPez(previous));
		if (found != null) {
			listaPeces.remove(found);
			listaPeces.add(DataMapper.pezDTOToPez(newData));
			return true;
		} else {
			return false;
		}
	}



	@Override
	@Override
	public int cantidad() {
		return listaPeces.size();
	}

	public ArrayList<Pez> getListaPeces() {
		return listaPeces;
	}

	public void setListaPeces(ArrayList<Pez> listaPeces) {
		this.listaPeces = listaPeces;
	}

	@Override
	public void escribirEnArchivo() {
		String contenido = "";

		for (int i = 0; i < listaPeces.size(); i++) {

			contenido += listaPeces.get(i).getNombre() + ";";
			contenido += listaPeces.get(i).getRaza() + ";";
			contenido += listaPeces.get(i).getEdad() + ";";
			contenido += listaPeces.get(i).getPeso() + ";";
			contenido += listaPeces.get(i).isEsVenenoso() + ";";
			contenido += listaPeces.get(i).isEsAvisal() + "\n";

		}
		FileManager.escribirArchivoDeTexto(TEXT_FILE_NAME, contenido);

	}

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
			boolean esVenenoso = Boolean.parseBoolean(columnas[4]);
			boolean esAvisal = Boolean.parseBoolean(columnas[5]);

			listaPeces.add(new Pez(nombre, raza, edad, peso, esVenenoso, esAvisal));

		}

	}

	// Funciones para serializado

	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaPeces);

	}

	public void cargarDesdeArchivoSerializado() {

		listaPeces = (ArrayList<Pez>)FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);

		if (listaPeces == null) {
			listaPeces = new ArrayList<>();
		}
	}

	public int cantidadVocalesPez() {

		int a = 0;
		int e = 0;
		int i = 0;
		int o = 0;
		int u = 0;

		for (Pez pez: listaPeces) {

			String nombre = pez.getNombre();

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
