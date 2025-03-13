package dev.java10x.CadastrosDeNinjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/boasvindas")

    public String boasVindas(){
        return "Esse minha é minha primeira mensagem nessa rota";
    }

}
