package dev.java10x.CadastrosDeNinjas.Ninjas;

import jakarta.persistence.PostUpdate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
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
    @GetMapping("/allNinjas")
    public String mostrarNinjas() {
        return "Mostrar todos os ninjas";
    }

    // procurar ninja por id
    @GetMapping("/allId")
    public String mostrarPorId() {
        return "Mostrar o ninja procurado";
    }

    //atualizar ninjas
    @PutMapping("/atualizar")
    public String atualizarNinjas() {
        return "Atualizar ninjas";
    }

    // deletar ninja
    @DeleteMapping("/deletarId")
    public String deletarNinjaPorId() {
        return "Ninja deletado por id";
    }

}
