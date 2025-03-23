package dev.java10x.CadastrosDeNinjas.MIssoes;

import dev.java10x.CadastrosDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private Long id;
    private String nome;
    private String dificuldade;
    private Boolean missaoCompleta;
    private List<NinjaModel> ninja;
}
