package co.edu.unbosque.vidapersonalservice.controller;

import co.edu.unbosque.vidapersonalservice.model.VidaPersonal;
import co.edu.unbosque.vidapersonalservice.model.VidaPersonalDTO;
import co.edu.unbosque.vidapersonalservice.services.VidaPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PersonalController {

    @Autowired
    private VidaPersonalService vidaPersonalService;

    @GetMapping("/findAll")
    public List<VidaPersonalDTO> findAllVidaPersonal(){
        return vidaPersonalService.findAll();
    }

    @PostMapping("/save")
    public VidaPersonalDTO saveVidaPersonal(@RequestBody VidaPersonalDTO dto){
        return vidaPersonalService.save(dto);
    }

    @PostMapping("/update")
    public VidaPersonalDTO updateVidaPersonal(@RequestBody VidaPersonalDTO dto){
        return vidaPersonalService.update(dto);
    }

    @PostMapping("/delete")
    public boolean deleteVidaPersonal(@RequestBody Map<String,String> request){
        return vidaPersonalService.delete(request.get("id"));
    }

}
