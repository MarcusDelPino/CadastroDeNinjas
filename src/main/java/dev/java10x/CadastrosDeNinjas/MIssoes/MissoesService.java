package dev.java10x.CadastrosDeNinjas.MIssoes;

import dev.java10x.CadastrosDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;


    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    // criar as missoes
    public MissoesDTO criarMissoes(MissoesDTO missoesDTO) {
        MissoesModel ninja = missoesMapper.map(missoesDTO);
        ninja = missoesRepository.save(ninja);
        return missoesMapper.map(ninja);
    }

    // listar todas as missoes
    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();

        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //lista missoes por id
    public MissoesDTO mostrarMissaoPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    }

    //deletar missao
    public void deletarMissao(Long id) {
        missoesRepository.deleteById(id);
    }

    //atualizar missoes
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missaoDTO) {
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if(missaoExistente.isPresent()){
            MissoesModel missaoAtualizado = missoesMapper.map(missaoDTO);
            missaoAtualizado.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizado);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }

}
