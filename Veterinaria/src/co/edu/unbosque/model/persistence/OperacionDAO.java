package co.edu.unbosque.model.persistence;

import java.util.ArrayList;


public interface OperacionDAO <C, E> {

	public String showAll(); //mostrar todo

	public ArrayList<C> getAll(); //mostrar todo Todito como DTO

	public boolean add(C newData); //ahora verifico que no haya duplicados c:

	public boolean delete(C toDelete); //eliminar

	public E find(E toFind); //to buscar; verificar si existe o no; null -> no existe

	public boolean update(C previous, C newData); //actualizarr

	public int cantidad();

	public void escribirEnArchivo();

	public void cargarDesdeArchivo();

}

