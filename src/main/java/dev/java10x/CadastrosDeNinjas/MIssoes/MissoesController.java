package dev.java10x.CadastrosDeNinjas.MIssoes;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Operation(summary = "Cria uma nova missão", description = "criar uma nova missão, e insere no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação da missão")
    })
    public ResponseEntity<String> criarMissoes(@RequestBody MissoesDTO missoesDTO){
        MissoesDTO missaoDTO = missoesService.criarMissoes(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso! ID: " + missaoDTO.getId() + " nome: " + missaoDTO.getNome());
    }
    // visualizar todas as missoes
    @Operation(summary = "Lista todos os ninjas", description = "Lista todos os ninjas do banco de dados.")
    @GetMapping("/listarmissoes")
    public ResponseEntity<List> missoes(){
        return ResponseEntity.ok(missoesService.listarMissoes());
    }

    //lista missao por id
    @Operation(summary = "Lista a missão pelo seu id", description = "Busca ua missão pelo seu id!")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão encontrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID da missão não existe!")
    })
    @GetMapping("/mostrarmissao/{id}")
    public ResponseEntity<?> mostrarMissaoPorId(@PathVariable Long id){
        MissoesDTO missoes =  missoesService.mostrarMissaoPorId(id);
        if (missoesService.mostrarMissaoPorId(id) != null){
            return ResponseEntity.ok(missoes);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Essa missão ID não existe!");
        }
    }

    //deletar misssao
    @Operation(summary = "Deleta a missão pelo id", description = "deleta a missão do banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "missão apagada com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID da missão não existe!")
    })
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if (missoesService.mostrarMissaoPorId(id) != null){
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missão de id: " + id + " deletada com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id da missão não encontrado!");
        }
    }

    // atualizar por id
    @Operation(summary = "Atualiza missão usando o id", description = "faz a atualização do missão usando ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID do missão não existe!")
    })
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarMissao(@RequestBody MissoesDTO missoesAtualizada, @PathVariable Long id ){

        if (missoesService.mostrarMissaoPorId(id) != null){
            missoesService.atualizarMissao(id, missoesAtualizada);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("A atualização da missão de id: " + id + " foi atualizada com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id da missão não existe!");
        }

    }



}
