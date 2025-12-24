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

@Service
@AllArgsConstructor
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public List<NinjaModel> getAll(){
        return ninjaRepository.findAll();
    }

    public NinjaModel save(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    public void delete(Long id){
        ninjaRepository.deleteById(id);
    }
}
