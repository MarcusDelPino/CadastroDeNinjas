package dev.java10x.CadastrosDeNinjas.MIssoes;


import dev.java10x.CadastrosDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity

@AllArgsConstructor
@Data

@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;
    private Boolean missaoCompleta;

    // @OneToMany - uma missa para varios ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;


}
