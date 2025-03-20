package dev.java10x.CadastrosDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Esse minha é minha primeira mensagem nessa rota";
    }

    // add ninja
    @PostMapping("/criar")
    public String criarNinja() {
        return "Criar Ninja";
    }

    // mostrar os ninjas
    @GetMapping("/listarninjas")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // procurar ninja por id
    @GetMapping("/mostrarninja/{id}")
    public NinjaModel mostrarNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarNinjasPorId(id);
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
