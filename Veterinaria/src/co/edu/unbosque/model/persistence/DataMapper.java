package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Gato;
import co.edu.unbosque.model.GatoDTO;
import co.edu.unbosque.model.Perro;
import co.edu.unbosque.model.PerroDTO;
import co.edu.unbosque.model.Pez;
import co.edu.unbosque.model.PezDTO;
import co.edu.unbosque.model.Reptil;
import co.edu.unbosque.model.ReptilDTO;
import co.edu.unbosque.model.Ruedor;
import co.edu.unbosque.model.RuedorDTO;

public class DataMapper {

	// Funciones para perro
	public static Perro perroDTOToPerro(PerroDTO dto) {
		Perro entity;
		entity = new Perro(dto.getNombre(), dto.getRaza(), dto.getEdad(), dto.getPeso(), dto.getFormaNariz());
		return entity;

	}

	public static PerroDTO perroToPerroDTO(Perro entity) {
		PerroDTO dto;
		dto = new PerroDTO(entity.getNombre(), entity.getRaza(), entity.getEdad(), entity.getPeso(),
				entity.getFormaNariz());
		return dto;

	}

	public static ArrayList<PerroDTO> listaPerroToListaPerroDTO(ArrayList<Perro> entityList) {

		ArrayList<PerroDTO> dtoList = new ArrayList<>();
		for (Perro p : entityList) {
			dtoList.add(new PerroDTO(p.getNombre(), p.getRaza(), p.getEdad(), p.getPeso(), p.getFormaNariz()));
		}
		return dtoList;
	}

	public static ArrayList<Perro> listaPerroDTOToListaPerro(ArrayList<PerroDTO> dtoList) {

		ArrayList<Perro> entityList = new ArrayList<>();
		for (PerroDTO d : dtoList) {
			entityList.add(new Perro(d.getNombre(), d.getRaza(), d.getEdad(), d.getPeso(), d.getFormaNariz()));
		}
		return entityList;
	}

	// Funciones para Gato
	public static Gato gatoDTOToGato(GatoDTO dto) {
		Gato entity;
		entity = new Gato(dto.getNombre(), dto.getRaza(), dto.getEdad(), dto.getPeso(), dto.getPatronPelaje(),
				dto.isTienePelo());
		return entity;

	}

	public static GatoDTO gatoToGatoDTO(Gato entity) {
		GatoDTO dto;
		dto = new GatoDTO(entity.getNombre(), entity.getRaza(), entity.getEdad(), entity.getPeso(),
				entity.getPatronPelaje(), entity.isTienePelo());
		return dto;

	}

	public static ArrayList<GatoDTO> listaGatoToListaGatoDTO(ArrayList<Gato> entityList) {

		ArrayList<GatoDTO> dtoList = new ArrayList<>();
		for (Gato p : entityList) {
			dtoList.add(new GatoDTO(p.getNombre(), p.getRaza(), p.getEdad(), p.getPeso(), p.getPatronPelaje(),
					p.isTienePelo()));
		}
		return dtoList;
	}

	public static ArrayList<Gato> listaGatoDTOToListaGato(ArrayList<GatoDTO> dtoList) {

		ArrayList<Gato> entityList = new ArrayList<>();
		for (GatoDTO d : dtoList) {
			entityList.add(new Gato(d.getNombre(), d.getRaza(), d.getEdad(), d.getPeso(), d.getPatronPelaje(),
					d.isTienePelo()));
		}
		return entityList;
	}

	// Funciones para Pez
	public static Pez pezDTOToPez(PezDTO dto) {
		Pez entity;
		entity = new Pez(dto.getNombre(), dto.getRaza(), dto.getEdad(), dto.getPeso(), dto.isEsVenenoso(),
				dto.isEsAvisal());
		return entity;

	}

	public static PezDTO pezToPezDTO(Pez entity) {
		PezDTO dto;
		dto = new PezDTO(entity.getNombre(), entity.getRaza(), entity.getEdad(), entity.getPeso(),
				entity.isEsVenenoso(), entity.isEsVenenoso());
		return dto;

	}

	public static ArrayList<PezDTO> listaPezToListaPezDTO(ArrayList<Pez> entityList) {

		ArrayList<PezDTO> dtoList = new ArrayList<>();
		for (Pez p : entityList) {
			dtoList.add(
					new PezDTO(p.getNombre(), p.getRaza(), p.getEdad(), p.getPeso(), p.isEsAvisal(), p.isEsVenenoso()));
		}
		return dtoList;
	}

	public static ArrayList<Pez> listaPezDTOToListaPez(ArrayList<PezDTO> dtoList) {

		ArrayList<Pez> entityList = new ArrayList<>();
		for (PezDTO d : dtoList) {
			entityList.add(
					new Pez(d.getNombre(), d.getRaza(), d.getEdad(), d.getPeso(), d.isEsAvisal(), d.isEsVenenoso()));
		}
		return entityList;
	}

//Funciones para Reptil
	public static Reptil reptilDTOToReptil(ReptilDTO dto) {
		Reptil entity;
		entity = new Reptil(dto.getNombre(), dto.getRaza(), dto.getEdad(), dto.getPeso(), dto.isEsVenenoso(),
				dto.getTiempoDeMudaDePiel());
		return entity;

	}

	public static ReptilDTO reptilToReptilDTO(Reptil entity) {
		ReptilDTO dto;
		dto = new ReptilDTO(entity.getNombre(), entity.getRaza(), entity.getEdad(), entity.getPeso(),
				entity.isEsVenenoso(), entity.getTiempoDeMudaDePiel());
		return dto;

	}

	public static ArrayList<ReptilDTO> listaReptilToListaReptilDTO(ArrayList<Reptil> entityList) {

		ArrayList<ReptilDTO> dtoList = new ArrayList<>();
		for (Reptil p : entityList) {
			dtoList.add(new ReptilDTO(p.getNombre(), p.getRaza(), p.getEdad(), p.getPeso(), p.isEsVenenoso(),
					p.getTiempoDeMudaDePiel()));
		}
		return dtoList;
	}

	public static ArrayList<Reptil> listaReptilDTOToListaReptil(ArrayList<ReptilDTO> dtoList) {

		ArrayList<Reptil> entityList = new ArrayList<>();
		for (ReptilDTO d : dtoList) {
			entityList.add(new Reptil(d.getNombre(), d.getRaza(), d.getEdad(), d.getPeso(), d.isEsVenenoso(),
					d.getTiempoDeMudaDePiel()));
		}
		return entityList;
	}

//Funciones para Ruedor
	public static Ruedor ruedorDTOToRuedor(RuedorDTO dto) {
		Ruedor entity;
		entity = new Ruedor(dto.getNombre(), dto.getRaza(), dto.getEdad(), dto.getPeso(), dto.getTamañoDiente(),
				dto.getTipoMadriguera());
		return entity;

	}

	public static RuedorDTO ruedorToRuedorDTO(Ruedor entity) {
		RuedorDTO dto;
		dto = new RuedorDTO(entity.getNombre(), entity.getRaza(), entity.getEdad(), entity.getPeso(),
				entity.getTamañoDiente(), entity.getTipoMadriguera());
		return dto;

	}

	public static ArrayList<RuedorDTO> listaRuedorToListaRuedorDTO(ArrayList<Ruedor> entityList) {

		ArrayList<RuedorDTO> dtoList = new ArrayList<>();
		for (Ruedor p : entityList) {
			dtoList.add(new RuedorDTO(p.getNombre(), p.getRaza(), p.getEdad(), p.getPeso(), p.getTamañoDiente(),
					p.getTipoMadriguera()));
		}
		return dtoList;
	}

	public static ArrayList<Ruedor> listaRuedorDTOToListaRuedor(ArrayList<RuedorDTO> dtoList) {

		ArrayList<Ruedor> entityList = new ArrayList<>();
		for (RuedorDTO d : dtoList) {
			entityList.add(new Ruedor(d.getNombre(), d.getRaza(), d.getEdad(), d.getPeso(), d.getTamañoDiente(),
					d.getTipoMadriguera()));
		}
		return entityList;
	}
}
