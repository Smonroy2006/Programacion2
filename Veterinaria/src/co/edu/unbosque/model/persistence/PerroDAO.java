package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Perro;
import co.edu.unbosque.model.PerroDTO;

public class PerroDAO implements OperacionDAO<PerroDTO, Perro> {

	private ArrayList<Perro> listaPerros;
	private final String TEXT_FILE_NAME = "perro.csv";
	private final String SERIAL_FILE_NAME = "perro.dat";

	public PerroDAO() {

		listaPerros = new ArrayList<>();
//		cargarDesdeArchivo();
		cargarDesdeArchivoSerializado();

	}

	@Override
	@Override
	public String showAll() {
		String rta = "";
		if (listaPerros.isEmpty()) {
			return "No hay mascotas en la lista";
		} else {
			for (Perro perro : listaPerros) {
				rta += perro;
			}
			return rta;
		}
	}

	@Override
	@Override
	public ArrayList<PerroDTO> getAll() {
		return DataMapper.listaPerroToListaPerroDTO(listaPerros);
	}

	@Override
	@Override
	public boolean add(PerroDTO newData) {

		if (find(DataMapper.perroDTOToPerro(newData)) == null) {
			listaPerros.add(DataMapper.perroDTOToPerro(newData));
			return true;
		} else {
			return false;
		}

	}

	@Override
	@Override
	public boolean delete(PerroDTO toDelete) {
		Perro found = find(DataMapper.perroDTOToPerro(toDelete));
		if (found != null) {
			return listaPerros.remove(found);
		} else {
			return false;
		}
	}

	@Override
	@Override
	public Perro find(Perro toFind) {
		Perro found = null;
		if (!listaPerros.isEmpty()) {
			for (Perro perro : listaPerros) {
				if (perro.getNombre().equals(toFind.getNombre())) {
					found = perro;
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
	public boolean update(PerroDTO previous, PerroDTO newData) {
		Perro found = find(DataMapper.perroDTOToPerro(previous));
		if (found != null) {
			listaPerros.remove(found);
			listaPerros.add(DataMapper.perroDTOToPerro(newData));
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Override
	public int cantidad() {
		return listaPerros.size();
	}


	// Cada vez que hagamos un cambio en los datos, se debe actualizar el archivo
	@Override
	public void escribirEnArchivo() {

		String contenido = "";

		for (int i = 0; i < listaPerros.size(); i++) {

			contenido += listaPerros.get(i).getNombre() + ";";
			contenido += listaPerros.get(i).getRaza() + ";";
			contenido += listaPerros.get(i).getEdad() + ";";
			contenido += listaPerros.get(i).getPeso() + ";";
			contenido += listaPerros.get(i).getFormaNariz() + "\n";

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
			String formaNariz = columnas[4];
			listaPerros.add(new Perro(nombre, raza, edad, peso, formaNariz));
		}

	}

	// Funciones para serializado

	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaPerros);

	}

	public void cargarDesdeArchivoSerializado() {

		listaPerros = (ArrayList<Perro>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);

		if (listaPerros == null) {
			listaPerros = new ArrayList<>();
		}
	}

	public float edadMenor() {

		float edadMenor = listaPerros.get(0).getEdad();

		for (Perro perro : listaPerros) {
			float edad = perro.getEdad();
			if (edad < edadMenor) {
				edadMenor = edad;
			}
		}

		return edadMenor;
	}

	public String edadVieja() {

		String salida = "";
		int edad = 0;

		for (Perro perro : listaPerros) {
			if (edad < perro.getEdad()) {

				edad = perro.getEdad();
				salida = perro.toString();

			}

		}

		return salida;
	}

	public String edadJoven() {

		String salida = "";
		int edad = 0;

		for (Perro perro : listaPerros) {
			if (edad > perro.getEdad()) {

				edad = perro.getEdad();
				salida = perro.toString();

			}

		}

		return salida;
	}

	public String nombreMasLargo() {

		String salida = "";

		for (Perro perro : listaPerros) {

			String nombre = perro.getNombre();
			String nombreUno = listaPerros.get(0).getNombre();

			if (nombre.length() < nombreUno.length()) {

				nombre = perro.getNombre();

			}

		}

		return salida;
	}

	public int cantidadVocalesPerro() {

		int a = 0;
		int e = 0;
		int i = 0;
		int o = 0;
		int u = 0;

		for (Perro perro : listaPerros) {

			String nombre = perro.getNombre();

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

	//setters and Getters
	public ArrayList<Perro> getListaPerros() {
		return listaPerros;
	}

	public void setListaPerros(ArrayList<Perro> listaPerros) {
		this.listaPerros = listaPerros;
	}
}
