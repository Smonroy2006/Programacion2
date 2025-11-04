package co.edu.unbosque.transaccionesbancarias.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para mapear los datos, de un objetoDTO a un entidad o viceversa para almacenar
 */
public class DataMapper {

    /**
     * Constructor vacio
     */
    public DataMapper() {
    }

    /*
    Data Mapper de la clase cliente
     */

    //Cliente

    /**
     * Metodo que pasa de DTO a una entidad
     *
     * @param dto DTO a mapear
     * @return objeto mapeado a Entidad
     */
    public static Cliente fromClienteDTOToCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente = new Cliente(dto.getTipoDocumento(), dto.getIdentificacion(), dto.getNombre(), dto.getApellido(), dto.getCorreo());
        return cliente;
    }

    /**
     * Metodo que pasa de entidad a DTO
     *
     * @param entity entidad a mapear
     * @return DTO mapeado
     */
    public static ClienteDTO fromClientetoClienteDTO(Cliente entity) {
        ClienteDTO dto = new ClienteDTO();
        dto = new ClienteDTO(entity.getTipoDocumento(), entity.getIdentificacion(), entity.getNombre(), entity.getApellido(), entity.getCorreo());
        return dto;
    }

    /**
     * Metodo que pasa de de listDTO a listEntity
     * @param dtos lista de DTOs a ser mapeada
     * @return lista de entidades mapeada
     */
    public static List<Cliente> fromClienteDTOToCliente(List<ClienteDTO> dtos) {
        List<Cliente> clientes = new ArrayList<>();
        for (ClienteDTO d : dtos) {
            clientes.add(new Cliente(d.getTipoDocumento(), d.getIdentificacion(), d.getNombre(), d.getApellido(), d.getCorreo()));
        }
        return clientes;
    }

    /**
     * Metodo que pasa de listEntity a listDTO
     * @param entityList lista de entidad a ser mapeada
     * @return lista de DTOs mapeada
     */
    public static List<ClienteDTO> fromClienteListToClienteDTOList(List<Cliente> entityList) {
        List<ClienteDTO> dtoList = new ArrayList<>();
        for (Cliente e : entityList) {
            dtoList.add(new ClienteDTO(e.getTipoDocumento(), e.getIdentificacion(), e.getNombre(), e.getApellido(), e.getCorreo()));
        }
        return dtoList;
    }

    /*
    Data mapper de las clases transaccion
     */

    //Transaccion

    /**
     * Metodo que pasa de DTOs a Entidades
     * @param dto, dto que recibe para mapear
     * @return, el objeto mapeado a entidad
     */
    public static Transaccion fromToTransaccionDTO(TransaccionDTO dto) {
        Transaccion entity = new Transaccion();
        entity = new Transaccion(dto.getId(), dto.getNombre(), dto.getValor(), dto.getBanco(), dto.getFecha());
        return entity;
    }

    /**
     * Metodo que pasa de Entiades a DTOs
     * @param entity, entidad que recibe para mapear
     * @return, el objeto mapeado a entidad
     */
    public static TransaccionDTO fromTransaccion(Transaccion entity) {
        TransaccionDTO dto = new TransaccionDTO();
        dto = new TransaccionDTO(entity.getId(), entity.getNombre(), entity.getValor(), entity.getBanco(), entity.getFecha());
        return dto;
    }

    //List<Transacciones>

    /**
     * Metodo que pasa de ListaEntidades a ListaDTOs
     * @param dtoList, Lista que recibe para mapear
     * @return retorna la lista mapeada a DTOs
     */
    public static List<Transaccion> fromToTransaccionListaDTO(List<TransaccionDTO> dtoList) {
        List<Transaccion> entityList = new ArrayList<>();
        for(TransaccionDTO dto : dtoList){
            entityList.add(new Transaccion(dto.getId(), dto.getNombre(), dto.getValor(), dto.getBanco(), dto.getFecha()));
        }
        return entityList;
    }

    /**
     * Metodo que pasa de ListasDTOs a ListasEntidades
     * @param entityList, lista que recibe para mapear
     * @return retorna la lista mapeada a Entidades
     */
    public static List<TransaccionDTO> fromToTransaccionLista(List<Transaccion> entityList) {
        List<TransaccionDTO> dtoList = new ArrayList<>();
        for(Transaccion entity : entityList){
            dtoList.add(new TransaccionDTO(entity.getId(), entity.getNombre(), entity.getValor(), entity.getBanco(), entity.getFecha()));
        }
        return dtoList;
    }

    /*
    Data Mapper de la clase Transaccion Telefonica
     */

    //Transaccion Telefonica

    /**
     * Metodo que pasa de Entidad a DTO
     * @param dto, objeto que recibe para mapear
     * @return retorna el objeto mapeado a DTO
     */
    public static TransaccionTelefonica fromToTransaccionTelefonicaDTO(TransaccionTelefonicaDTO dto) {
        TransaccionTelefonica entity = new TransaccionTelefonica();
        entity = new TransaccionTelefonica(dto.getId(), dto.getNombre(), dto.getValor(), dto.getBanco(), dto.getFecha(), dto.getNombreDestinatario(), dto.getOperador(), dto.getNumeroTelefonico());
        return entity;
    }

    /**
     * Metodo que pasa de DTO a Entidad
     * @param entity, objeto que recibe para mapear
     * @return retorna el objeto mapeado a Entidad
     */
    public static TransaccionTelefonicaDTO fromToTransaccionTelefonica(TransaccionTelefonica entity) {
        TransaccionTelefonicaDTO dto = new TransaccionTelefonicaDTO();
        dto = new TransaccionTelefonicaDTO(entity.getId(), entity.getNombre(), entity.getValor(), entity.getBanco(), entity.getFecha(), entity.getNombreDestinatario(), entity.getOperador(), dto.getNumeroTelefonico());
        return dto;
    }

    //List<TransaccionTelefoncia>

    /**
     * Metodo que pasa de listaEntidaa a ListaDTO
     * @param dtoList, Lista que recibe para mapear
     * @return retornar la lista mapeada a DTO
     */
    public static List<TransaccionTelefonica> fromTransaccionTelefonicaListDTO(List<TransaccionTelefonicaDTO> dtoList) {
        List<TransaccionTelefonica> entityList = new ArrayList<>();
        for(TransaccionTelefonicaDTO dto : dtoList){
            entityList.add(new TransaccionTelefonica(dto.getId(), dto.getNombre(), dto.getValor(), dto.getBanco(), dto.getFecha(), dto.getNombreDestinatario(),dto.getOperador(), dto.getNumeroTelefonico()));
        }
        return entityList;
    }

    /**
     * Metodo que pasa de listaDTO a listEntidad
     * @param entityList, lista que recibe para mapear
     * @return retorna la lista mapeada a Entidad
     */
    public static List<TransaccionTelefonicaDTO> fromTransaccionTelefonicaList(List<TransaccionTelefonica> entityList){
        List<TransaccionTelefonicaDTO> dtoList = new ArrayList<>();
        for(TransaccionTelefonica entity : entityList){
            dtoList.add(new TransaccionTelefonicaDTO(entity.getId(), entity.getNombre(), entity.getValor(), entity.getBanco(), entity.getFecha(), entity.getNombreDestinatario(), entity.getOperador() , entity.getNumeroTelefonico()));
        }
        return dtoList;
    }

}
