package dev.java10x.CadastroDeNinjas.service;

import dev.java10x.CadastroDeNinjas.model.MissoesModel;
import dev.java10x.CadastroDeNinjas.model.NinjaModel;
import dev.java10x.CadastroDeNinjas.repository.NinjaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public List<NinjaModel> getAll(){
        return ninjaRepository.findAll();
    }

    public NinjaModel getById(Long id){
        return ninjaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ninja com ID " + id + " não encontrado"));
    }

    public NinjaModel save(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    public void delete(Long id){
        if(!ninjaRepository.existsById(id)){
            throw new RuntimeException("Ninja com ID " + id + " não encontrado");
        }

        ninjaRepository.deleteById(id);
    }
}
