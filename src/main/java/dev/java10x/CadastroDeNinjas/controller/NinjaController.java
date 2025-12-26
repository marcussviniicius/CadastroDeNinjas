package dev.java10x.CadastroDeNinjas.controller;

import dev.java10x.CadastroDeNinjas.model.NinjaModel;
import dev.java10x.CadastroDeNinjas.service.NinjaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
@AllArgsConstructor
public class NinjaController {

    private final NinjaService ninjaService;

    @GetMapping
    public List<NinjaModel> getAll(){
        return ninjaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        NinjaModel ninja = ninjaService.getById(id);
        return ResponseEntity.ok(ninja);
    }

    @PostMapping
    public NinjaModel create(@RequestBody NinjaModel ninja){
        return ninjaService.save(ninja);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        ninjaService.delete(id);
    }

    @PutMapping("/{id}")
    public NinjaModel update(@PathVariable Long id, @RequestBody NinjaModel ninja) {
        ninja.setId(id);
        return ninjaService.save(ninja);
    }
}
