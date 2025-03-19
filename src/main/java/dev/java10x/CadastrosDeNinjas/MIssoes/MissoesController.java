package dev.java10x.CadastrosDeNinjas.MIssoes;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @PostMapping("/criar")
    public String criarMissoes(){
        return "criando missoes";
    }

    @GetMapping("/todasmissoes")
    public String missoes(){
        return "Todas as missões";
    }

    @PutMapping("/atualizar")
    public String atualizarMissao(){
        return "Atualizar missoes";
    }

    @DeleteMapping("/deletar")
    public String deletarMissoes(){
        return "deletar missoes";
    }

}
