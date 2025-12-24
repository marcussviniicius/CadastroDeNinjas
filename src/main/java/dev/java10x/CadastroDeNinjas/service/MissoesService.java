package dev.java10x.CadastroDeNinjas.service;

import dev.java10x.CadastroDeNinjas.model.MissoesModel;
import dev.java10x.CadastroDeNinjas.repository.MissoesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MissoesService {

    private final MissoesRepository missoesRepository;

    public List<MissoesModel> getAll(){
        return missoesRepository.findAll();
    }

    public MissoesModel save(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    public void delete(Long id){
        missoesRepository.deleteById(id);
    }
}
