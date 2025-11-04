package co.edu.unbosque.vidafinanciera.services;

import co.edu.unbosque.vidafinanciera.model.VidaFinanciera;
import co.edu.unbosque.vidafinanciera.model.VidaFinancieraDTO;
import co.edu.unbosque.vidafinanciera.repository.VidaFinancieraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VidaFinancieraService {

    private final VidaFinancieraRepository vidaFinancieraRepository;
    private ModelMapper modelMapper;

    public VidaFinancieraService(VidaFinancieraRepository vidaFinancieraRepository) {
        this.vidaFinancieraRepository = vidaFinancieraRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<VidaFinancieraDTO> findAll(){
        return vidaFinancieraRepository.findAll()
                .stream()
                .map(x -> modelMapper.map(x, VidaFinancieraDTO.class))
                .collect(Collectors.toList());
    }

    public VidaFinancieraDTO save(VidaFinancieraDTO dto){
        VidaFinanciera vidaFinanciera = modelMapper.map(dto, VidaFinanciera.class);
        vidaFinanciera = vidaFinancieraRepository.save(vidaFinanciera);
        return modelMapper.map(vidaFinanciera, VidaFinancieraDTO.class);
    }

    public boolean delete(String id){

        if(vidaFinancieraRepository.existsById(id)){
            vidaFinancieraRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public VidaFinancieraDTO update(VidaFinancieraDTO dto){

        Optional<VidaFinanciera> optional = vidaFinancieraRepository.findById(dto.getId());

        if(optional.isPresent()){
            VidaFinanciera vidaFinanciera = optional.get();
            vidaFinanciera.setBanco(dto.getBanco());
            vidaFinanciera.setEndeudado(dto.isEndeudado());

            VidaFinanciera updated = vidaFinancieraRepository.save(vidaFinanciera);
            return modelMapper.map(updated, VidaFinancieraDTO.class);
        }
        return null;
    }

}
