package co.edu.unbosque.vidafinanciera.controller;

import co.edu.unbosque.vidafinanciera.model.VidaFinanciera;
import co.edu.unbosque.vidafinanciera.model.VidaFinancieraDTO;
import co.edu.unbosque.vidafinanciera.services.VidaFinancieraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class FinancieraController {

    @Autowired
    private VidaFinancieraService vidaFinancieraService;

    @GetMapping("/findAll")
    public List<VidaFinancieraDTO> findAll() {
        return vidaFinancieraService.findAll();
    }

    @PostMapping("/save")
    public VidaFinancieraDTO save(@RequestBody VidaFinancieraDTO dto){
        return vidaFinancieraService.save(dto);
    }

    @PostMapping("/update")
    public VidaFinancieraDTO update(@RequestBody VidaFinancieraDTO dto){
        return vidaFinancieraService.update(dto);
    }

    @PostMapping("/delete")
    public boolean delete(@RequestBody Map<String, String> request){
        return vidaFinancieraService.delete(request.get("id"));
    }

}
