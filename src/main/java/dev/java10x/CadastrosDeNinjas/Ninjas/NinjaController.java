package dev.java10x.CadastrosDeNinjas.Ninjas;

import jakarta.persistence.PostUpdate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")

    public String boasVindas(){
        return "Esse minha é minha primeira mensagem nessa rota";
    }

    // add ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "Criar Ninja";
    }

    // mostrar os ninjas
    @GetMapping("/todosninjas")
    public String mostrarNinjas() {
        return "Mostrar todos os ninjas";
    }

    // procurar ninja por id
    @GetMapping("/ninja")
    public String mostrarPorId() {
        return "Mostrar o ninja procurado";
    }

    //atualizar ninjas
    @PutMapping("/atualizar")
    public String atualizarNinjas() {
        return "Atualizar ninjas";
    }

    // deletar ninja
    @DeleteMapping("/deletar")
    public String deletarNinjaPorId() {
        return "Ninja deletado por id";
    }

}
