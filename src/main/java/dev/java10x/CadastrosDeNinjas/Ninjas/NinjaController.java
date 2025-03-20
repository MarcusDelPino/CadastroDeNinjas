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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinjas(ninja) ;
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
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
    }

}
