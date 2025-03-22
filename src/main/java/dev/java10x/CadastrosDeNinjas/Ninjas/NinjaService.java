package dev.java10x.CadastrosDeNinjas.Ninjas;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //listar todos meus ninjas
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();

        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //listar ninja por ID
    public NinjaDTO listarNinjasPorId(Long idNinja){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(idNinja);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }
    //criar ninjas
    public NinjaDTO criarNinjas(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //deletar ninja - tem que ser um metodo void
    public void deletarNinjaPorId(Long id){
         ninjaRepository.deleteById(id);

    }

    //atualizar ninja
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente =  ninjaRepository.findById(id);
        if(ninjaExistente.isPresent()){
            NinjaModel ninjaComDadosAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaComDadosAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaComDadosAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

}
