package co.edu.unbosque.VidaAcademicaService.services;

import co.edu.unbosque.VidaAcademicaService.model.VidaAcademica;
import co.edu.unbosque.VidaAcademicaService.model.VidaAcademicaDTO;
import co.edu.unbosque.VidaAcademicaService.repository.VidaAcademicaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VidaAcademicaService {

    private final VidaAcademicaRepository  vidaAcademicaRepository;
    private ModelMapper modelMapper;

    public VidaAcademicaService(VidaAcademicaRepository vidaAcademicaRepository) {
        this.vidaAcademicaRepository = vidaAcademicaRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<VidaAcademicaDTO> findAll() {
        return vidaAcademicaRepository.findAll()
                .stream()
                .map(x -> modelMapper.map(x, VidaAcademicaDTO.class)).
                collect(Collectors.toList());
    }

    public VidaAcademicaDTO save(VidaAcademicaDTO dto){
        VidaAcademica vidaAcademica = modelMapper.map(dto, VidaAcademica.class);
        vidaAcademica = vidaAcademicaRepository.save(vidaAcademica);
        return modelMapper.map(vidaAcademica, VidaAcademicaDTO.class);
    }

    public boolean delete(String id){

        if(vidaAcademicaRepository.existsById(id)){
            vidaAcademicaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public VidaAcademicaDTO update(VidaAcademicaDTO dto){

        Optional<VidaAcademica> optional = vidaAcademicaRepository.findById(dto.getId());

        if(optional.isPresent()){
            VidaAcademica vidaAcademica = optional.get();
            vidaAcademica.setTitulo(dto.getTitulo());
            vidaAcademica.setUniversidad(dto.getUniversidad());
            vidaAcademica.setCompletado(dto.isCompletado());

            VidaAcademica updated = vidaAcademicaRepository.save(vidaAcademica);
            return modelMapper.map(updated, VidaAcademicaDTO.class);
        }

        return null;

    }

}
