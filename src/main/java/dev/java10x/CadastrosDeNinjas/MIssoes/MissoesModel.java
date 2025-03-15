package dev.java10x.CadastrosDeNinjas.MIssoes;


import dev.java10x.CadastrosDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
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

    public MissoesModel() {
    }

    public MissoesModel(Long id, String nome, String dificuldade, Boolean missaoCompleta, List<NinjaModel> ninja) {
        this.id = id;
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.missaoCompleta = missaoCompleta;
        this.ninja = ninja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public Boolean getMissaoCompleta() {
        return missaoCompleta;
    }

    public void setMissaoCompleta(Boolean missaoCompleta) {
        this.missaoCompleta = missaoCompleta;
    }

    public List<NinjaModel> getNinja() {
        return ninja;
    }

    public void setNinja(List<NinjaModel> ninja) {
        this.ninja = ninja;
    }
}
