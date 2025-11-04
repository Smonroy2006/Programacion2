package co.edu.unbosque.VidaAcademicaService.controller;

import co.edu.unbosque.VidaAcademicaService.model.VidaAcademicaDTO;
import co.edu.unbosque.VidaAcademicaService.services.VidaAcademicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AcademicaController {

    @Autowired
    private VidaAcademicaService vidaAcademicaService;

    @GetMapping("/vidaAcademicas")
    public List<VidaAcademicaDTO> findAll(){
        return vidaAcademicaService.findAll();
    }

    @PostMapping("/vidaAcademica/save")
    public VidaAcademicaDTO save(@RequestBody VidaAcademicaDTO dto){
        return vidaAcademicaService.save(dto);
    }

    @PostMapping("/vidaAcademica/update")
    public VidaAcademicaDTO update(@RequestBody VidaAcademicaDTO dto){
        return vidaAcademicaService.update(dto);
    }

    @PostMapping("/vidaAcademica/delete")
    public boolean delete(@RequestBody Map<String, String> request){
        return vidaAcademicaService.delete(request.get("id"));
    }

}
