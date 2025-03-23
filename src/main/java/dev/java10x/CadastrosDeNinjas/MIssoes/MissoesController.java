package dev.java10x.CadastrosDeNinjas.MIssoes;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criarmissoes")
    public MissoesDTO criarMissoes(@RequestBody MissoesDTO missoesDTO){
        return missoesService.criarMissoes(missoesDTO);
    }
    // visualizar todas as missoes
    @GetMapping("/listarmissoes")
    public List<MissoesDTO> missoes(){
        return missoesService.listarMissoes();
    }

    //lista missao por id
    @GetMapping("/mostrarmissao/{id}")
    public MissoesDTO mostrarMissaoPorId(@PathVariable Long id){
        return missoesService.mostrarMissaoPorId(id);
    }

    //deletar misssao
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
    }

    // atualizar por id
    @PutMapping("/atualizar/{id}")
    public MissoesDTO atualizarMissao(@RequestBody MissoesDTO missoesAtualizada, @PathVariable Long id ){
        return missoesService.atualizarMissao(id, missoesAtualizada);
    }



}
