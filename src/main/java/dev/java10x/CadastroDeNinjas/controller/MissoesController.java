package dev.java10x.CadastroDeNinjas.controller;

import dev.java10x.CadastroDeNinjas.model.MissoesModel;
import dev.java10x.CadastroDeNinjas.model.NinjaModel;
import dev.java10x.CadastroDeNinjas.service.MissoesService;
import dev.java10x.CadastroDeNinjas.service.NinjaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
@AllArgsConstructor
public class MissoesController {

    private final MissoesService missoesService;

    @GetMapping
    public List<MissoesModel> getAll(){
        return missoesService.getAll();
    }

    @PostMapping
    public MissoesModel create(@RequestBody MissoesModel missao){
        return missoesService.save(missao);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        missoesService.delete(id);
    }

    @PutMapping("/{id}")
    public MissoesModel update(@PathVariable Long id, @RequestBody MissoesModel missao) {
        missao.setId(id);
        return missoesService.save(missao);
    }
}
