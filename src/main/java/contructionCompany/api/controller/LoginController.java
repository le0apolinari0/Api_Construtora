package contructionCompany.api.controller;
import contructionCompany.api.service.LoginInterface;
import contructionCompany.api.domain.usuarioLog.DadosAutenticacao;
import contructionCompany.api.infra.security.DadosTokenJwt;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
        @Autowired
        private LoginInterface service;

        @PostMapping
        public ResponseEntity<DadosTokenJwt> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
            DadosTokenJwt token = service.efetuarLogin(dados);
            return ResponseEntity.ok(token);
        }
    }
