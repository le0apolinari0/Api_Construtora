package contructionCompany.api.controller;

import contructionCompany.api.domain.colaborador.Colaborador;
import contructionCompany.api.domain.colaborador.DadosCadastroColaborador;
import contructionCompany.api.domain.colaborador.DadosListagemColaborador;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String olaMundo() {
        return "teste!";
    }
}
