package contructionCompany.api.controller;
import contructionCompany.api.domain.usuarioLog.DadosAutenticacao;
import contructionCompany.api.domain.usuarioLog.Usuario;
import contructionCompany.api.infra.security.DadosTokenJwt;
import contructionCompany.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efeturarLogin(@RequestBody @Valid DadosAutenticacao dados) {

        try {

            var authenticantionToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
            var authenticantion = manager.authenticate(authenticantionToken);

            var tokenJWT = tokenService.gerarToken((Usuario) authenticantion.getPrincipal());

            return ResponseEntity.ok(new DadosTokenJwt(tokenJWT));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
