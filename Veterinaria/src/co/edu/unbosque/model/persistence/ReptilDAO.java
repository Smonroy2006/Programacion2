package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Reptil;
import co.edu.unbosque.model.ReptilDTO;

public class ReptilDAO implements OperacionDAO <ReptilDTO, Reptil> {

	private ArrayList<Reptil> listaReptil;
	private final String TEXT_FILE_NAME = "reptil.csv";
	private final String SERIAL_FILE_NAME = "Reptil.dat";



	public ReptilDAO() {

		listaReptil = new ArrayList<>();
		cargarDesdeArchivo();

	}

	@Override
	@Override
	public String showAll() {
		String rta = "";
		if (listaReptil.isEmpty()) {
			return "No hay mascotas en la lista";
		} else {
			for (Reptil reptil : listaReptil) {
				rta += reptil;
			}
			return rta;
		}
	}



	@Override
	@Override
	public ArrayList<ReptilDTO> getAll() {
		return DataMapper.listaReptilToListaReptilDTO(listaReptil);
	}



	@Override
	@Override
	public boolean add(ReptilDTO newData) {

		if (find(DataMapper.reptilDTOToReptil(newData)) == null) {
			listaReptil.add(DataMapper.reptilDTOToReptil(newData));
			return true;
		} else {
			return false;
		}

	}



	@Override
	@Override
	public boolean delete(ReptilDTO toDelete) {

		Reptil found = find(DataMapper.reptilDTOToReptil(toDelete));
		if (found != null) {
			return listaReptil.remove(found);
		} else {
			return false;
		}

	}



	@Override
	@Override
	public Reptil find(Reptil toFind) {
		Reptil found = null;
		if (!listaReptil.isEmpty()) {
			for (Reptil reptil : listaReptil) {
				if (reptil.getNombre().equals(toFind.getNombre())) {
					found = reptil;
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
	public boolean update(ReptilDTO previous, ReptilDTO newData) {

		Reptil found = find(DataMapper.reptilDTOToReptil(previous));
		if (found != null) {
			listaReptil.remove(found);
			listaReptil.add(DataMapper.reptilDTOToReptil(newData));
			return true;
		} else {
			return false;
		}

	}



	@Override
	@Override
	public int cantidad() {
		return listaReptil.size();
	}

	public ArrayList<Reptil> getListaReptil() {
		return listaReptil;
	}

	public void setListaReptil(ArrayList<Reptil> listaReptil) {
		this.listaReptil = listaReptil;
	}

	@Override
	public void escribirEnArchivo() {
		String contenido = "";

		 for (int i = 0; i < listaReptil.size(); i++) {

			 contenido += listaReptil.get(i).getNombre() + ";";
			 contenido += listaReptil.get(i).getRaza() + ";";
			 contenido += listaReptil.get(i).getEdad() + ";";
			 contenido += listaReptil.get(i).getPeso() + ";";
			 contenido += listaReptil.get(i).isEsVenenoso() + ";";
			 contenido += listaReptil.get(i).getTiempoDeMudaDePiel() + "\n";

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
			int tiempoDeMudaDePiel = Integer.parseInt(columnas[5]);

			listaReptil.add(new Reptil(nombre, raza, edad, peso, esVenenoso, tiempoDeMudaDePiel));

		}

	}

	// Funciones para serializado

	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaReptil);

	}

	public void cargarDesdeArchivoSerializado() {

		listaReptil = (ArrayList<Reptil>)FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);

		if (listaReptil == null) {
			listaReptil = new ArrayList<>();
		}
	}

	public int cantidadVocalesReptil() {

		int a = 0;
		int e = 0;
		int i = 0;
		int o = 0;
		int u = 0;

		for (Reptil reptil: listaReptil) {

			String nombre = reptil.getNombre();

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
