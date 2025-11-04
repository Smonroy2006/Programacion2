package co.edu.unbosque.vidapersonalservice.services;

import co.edu.unbosque.vidapersonalservice.model.VidaPersonal;
import co.edu.unbosque.vidapersonalservice.model.VidaPersonalDTO;
import co.edu.unbosque.vidapersonalservice.repository.VidaPersonalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VidaPersonalService {

    private final VidaPersonalRepository vidaPersonalRepository;
    private ModelMapper modelMapper;

    public VidaPersonalService(VidaPersonalRepository vidaPersonalRepository) {
        this.vidaPersonalRepository = vidaPersonalRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<VidaPersonalDTO> findAll(){
        return vidaPersonalRepository.findAll()
                .stream()
                .map(x -> modelMapper.map(x, VidaPersonalDTO.class))
                .collect(Collectors.toList());
    }

    public VidaPersonalDTO save(VidaPersonalDTO dto){
        VidaPersonal vidaPersonal = modelMapper.map(dto, VidaPersonal.class);
        vidaPersonal = vidaPersonalRepository.save(vidaPersonal);
        return modelMapper.map(vidaPersonal, VidaPersonalDTO.class);
    }

    public boolean delete(String id){

        if(vidaPersonalRepository.existsById(id)){
            vidaPersonalRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public VidaPersonalDTO update(VidaPersonalDTO dto){

        Optional<VidaPersonal> optional = vidaPersonalRepository.findById(dto.getId());

        if(optional.isPresent()){
            VidaPersonal vidaPersonal = optional.get();
            vidaPersonal.setId(dto.getId());
            vidaPersonal.setNombre(dto.getNombre());

            VidaPersonal update = vidaPersonalRepository.save(vidaPersonal);
            return modelMapper.map(update, VidaPersonalDTO.class);
        }
        return null;
    }

}
