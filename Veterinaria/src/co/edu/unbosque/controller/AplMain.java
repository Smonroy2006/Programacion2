package co.edu.unbosque.controller;

/**
 * Esta clase se encarga de lanzar al programa trayendo todo lo de controller
 */
public class AplMain {

	/**
	 * Esta es una funcion Main, que es lo principal para que el programa se
	 * ejecute, y dentro se importa el controller y se le dice que inicie con la
	 * funcuon run
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		Controller C = new Controller();
		C.run();

	}
}
