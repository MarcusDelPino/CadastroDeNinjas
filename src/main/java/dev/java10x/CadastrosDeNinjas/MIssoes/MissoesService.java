package dev.java10x.CadastrosDeNinjas.MIssoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // listar todas as missoes
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    //lista missoes por id
    public MissoesModel mostrarMissaoPorId(Long id) {
        Optional<MissoesModel> missaoOptional = missoesRepository.findById(id);
        return missaoOptional.orElse(null);
    }

    // criar as missoes
    public MissoesModel criarMissoes(MissoesModel missoesModel) {
        return missoesRepository.save(missoesModel);
    }

    //deletar missao
    public void deletarMissao(Long id) {
        missoesRepository.deleteById(id);
    }

    //atualizar missoes
    public MissoesModel atualizarMissao(Long id, MissoesModel missaoAtualizada) {
        if (missoesRepository.existsById(id)) {
            missaoAtualizada.setId(id);
            return missoesRepository.save(missaoAtualizada);

        }
        return null;

    }

}
