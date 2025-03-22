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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinjas(ninja) ;
    }

    // mostrar os ninjas
    @GetMapping("/listarninjas")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // procurar ninja por id
    @GetMapping("/mostrarninja/{id}")
    public NinjaDTO mostrarNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    //atualizar ninjas
    @PutMapping("/atualizar/{id}")
    public NinjaDTO atualizarNinjas(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        return ninjaService.atualizarNinja(id, ninjaAtualizado) ;
    }

    // deletar ninja
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
    }

}
