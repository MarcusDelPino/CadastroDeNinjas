package dev.java10x.CadastrosDeNinjas.Ninjas;
import dev.java10x.CadastrosDeNinjas.MIssoes.MissoesModel;
import jakarta.persistence.*;

//Entity ele transforma uma classe em uma entidade do BD
@Entity
//Tabela
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String nome;
    private String email;
    private int idade;
    private String rank;

    //@ManyToOne -> um ninja tem uma unica missao
    @ManyToOne()
    @JoinColumn(name = "missoes_id") //foreing key ou chave estrangeira
    private MissoesModel missoes;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade, String rank) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.rank = rank;
    }


}
