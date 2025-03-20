package dev.java10x.CadastrosDeNinjas.Ninjas;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //listar todos meus ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }
    //listar ninja por ID
    public NinjaModel listarNinjasPorId(Long idNinja){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(idNinja);
        return ninjaPorId.orElse(null);
    }

    public NinjaModel criarNinjas(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //deletar ninja - tem que ser um metodo void
    public void deletarNinjaPorId(Long id){
         ninjaRepository.deleteById(id);

    }

    //atualizar ninja

}
