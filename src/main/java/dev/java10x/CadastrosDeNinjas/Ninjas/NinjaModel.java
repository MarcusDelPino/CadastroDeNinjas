package dev.java10x.CadastrosDeNinjas.Ninjas;

import dev.java10x.CadastrosDeNinjas.MIssoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Entity ele transforma uma classe em uma entidade do BD
@Entity

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "missoes")
@Data

//Tabela
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;
    private String rank;

    @Column (name = "nivel")
    private String nivel;

    //@ManyToOne -> um ninja tem uma unica missao
    @ManyToOne()
    @JoinColumn(name = "missoes_id") //foreing key ou chave estrangeira
    private MissoesModel missoes;


}
