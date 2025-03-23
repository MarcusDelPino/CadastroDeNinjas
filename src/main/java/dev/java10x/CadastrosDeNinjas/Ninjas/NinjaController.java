package dev.java10x.CadastrosDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas-vindas", description = "Essa rota da uma mensagem de boas vindas")
    public String boasVindas() {
        return "Esse minha é minha primeira mensagem nessa rota";
    }

    // add ninja
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Cria uma novo ninja, e insere no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinjas(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso " + novoNinja.getNome() + "(ID): " + novoNinja.getId());
    }

    // mostrar os ninjas
    @Operation(summary = "Lista todos os ninjas", description = "Lista todos os ninjas do banco de dados.")
    @GetMapping("/listarninjas")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        return ResponseEntity.ok(ninjaService.listarNinjas());
    }

    // procurar ninja por id
    @Operation(summary = "Lista o ninja pelo seu id", description = "Busca um ninja pelo seu id!")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID do ninja não existe!")
    })
    @GetMapping("/mostrarninja/{id}")
    public ResponseEntity<?> mostrarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja Id não encontrado!");
        }
    }

    //atualizar ninjas
    @Operation(summary = "Atualiza ninja usando o id", description = "faz a atualização do ninja usando ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID do ninja não existe!")
    })
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarNinjas(
            @Parameter(description = "Usuario manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "O Usuario manda os dados no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado) {
        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.atualizarNinja(id, ninjaAtualizado);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Ninja de id: " + id + " atualizado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id Ninja não existe!");
        }
    }

    // deletar ninja
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta o ninja pelo id", description = "deleta o ninja do banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja apagado com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID do ninja não existe!")
    })
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com o ID: " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com ID não existe!");
        }
    }
}
