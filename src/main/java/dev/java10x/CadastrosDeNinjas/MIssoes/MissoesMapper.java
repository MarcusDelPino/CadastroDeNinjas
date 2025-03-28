package dev.java10x.CadastrosDeNinjas.MIssoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO  missoesDTO){
        MissoesModel missoesModel = new MissoesModel();

        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setMissaoCompleta(missoesDTO.getMissaoCompleta());
        missoesModel.setNinja(missoesDTO.getNinja());
        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel){
        MissoesDTO missoesDTO = new MissoesDTO();

        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        missoesDTO.setMissaoCompleta(missoesModel.getMissaoCompleta());
        missoesDTO.setNinja(missoesModel.getNinja());

        return missoesDTO;
    }

}
