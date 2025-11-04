package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Ruedor;
import co.edu.unbosque.model.RuedorDTO;

public class RuedorDAO implements OperacionDAO<RuedorDTO, Ruedor> {

	private ArrayList<Ruedor> listaRuedores;
	private final String TEXT_FILE_NAME = "ruedor.csv";
	private final String SERIAL_FILE_NAME = "ruedor.dat";

	public RuedorDAO() {

		listaRuedores = new ArrayList<>();
		cargarDesdeArchivo();

	}

	@Override
	@Override
	public String showAll() {

		String rta = "";
		if (listaRuedores.isEmpty()) {
			return "No hay mascotas en la lista";
		} else {
			for (Ruedor ruedor : listaRuedores) {
				rta += ruedor;
			}
			return rta;
		}

	}

	@Override
	@Override
	public ArrayList<RuedorDTO> getAll() {
		return DataMapper.listaRuedorToListaRuedorDTO(listaRuedores);
	}

	@Override
	@Override
	public boolean add(RuedorDTO newData) {

		if (find(DataMapper.ruedorDTOToRuedor(newData)) == null) {
			listaRuedores.add(DataMapper.ruedorDTOToRuedor(newData));
			return true;
		} else {
			return false;
		}

	}

	@Override
	@Override
	public boolean delete(RuedorDTO toDelete) {
		Ruedor found = find(DataMapper.ruedorDTOToRuedor(toDelete));
		if (found != null) {
			return listaRuedores.remove(found);
		} else {
			return false;
		}
	}

	@Override
	@Override
	public Ruedor find(Ruedor toFind) {

		Ruedor found = null;
		if (!listaRuedores.isEmpty()) {
			for (Ruedor ruedor : listaRuedores) {
				if (ruedor.getNombre().equals(toFind.getNombre())) {
					found = ruedor;
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
	public boolean update(RuedorDTO previous, RuedorDTO newData) {

		Ruedor found = find(DataMapper.ruedorDTOToRuedor(previous));
		if (found != null) {
			listaRuedores.remove(found);
			listaRuedores.add(DataMapper.ruedorDTOToRuedor(newData));
			return true;
		} else {
			return false;
		}

	}

	@Override
	@Override
	public int cantidad() {
		return listaRuedores.size();
	}

	public ArrayList<Ruedor> getListaRuedores() {
		return listaRuedores;
	}

	public void setListaRuedores(ArrayList<Ruedor> listaRuedores) {
		this.listaRuedores = listaRuedores;
	}

	@Override
	public void escribirEnArchivo() {

		String contenido = "";

		for (int i = 0; i < listaRuedores.size(); i++) {

			contenido += listaRuedores.get(i).getNombre() + ";";
			contenido += listaRuedores.get(i).getRaza() + ";";
			contenido += listaRuedores.get(i).getEdad() + ";";
			contenido += listaRuedores.get(i).getPeso() + ";";
			contenido += listaRuedores.get(i).getTamañoDiente() + ";";
			contenido += listaRuedores.get(i).getTipoMadriguera() + "\n";

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
			int tamañoDiente = Integer.parseInt(columnas[4]);
			String tipoMadriguera = columnas[5];

			listaRuedores.add(new Ruedor(nombre, raza, edad, peso, i, tipoMadriguera));
		}

	}

	// Funciones para serializado

	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaRuedores);

	}

	public void cargarDesdeArchivoSerializado() {

		listaRuedores = (ArrayList<Ruedor>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);

		if (listaRuedores == null) {
			listaRuedores = new ArrayList<>();
		}
	}

	public int cantidadVocalesRuedor() {

		int a = 0;
		int e = 0;
		int i = 0;
		int o = 0;
		int u = 0;

		for (Ruedor ruedor : listaRuedores) {

			String nombre = ruedor.getNombre();

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
