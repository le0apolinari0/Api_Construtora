package contructionCompany.api.service;

import contructionCompany.api.domain.usuarioLog.DadosAutenticacao;
import contructionCompany.api.domain.usuarioLog.Usuario;
import contructionCompany.api.infra.security.DadosTokenJwt;
import contructionCompany.api.infra.security.TokenService;
import contructionCompany.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LoginService implements LoginInterface {

    @Autowired
    @Lazy
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }

    @Override
    public DadosTokenJwt efetuarLogin(DadosAutenticacao dados) {
        try {
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

            Authentication authenticantion = manager.authenticate(token);

            String tokenJWT = tokenService.gerarToken((Usuario) authenticantion.getPrincipal());

            return new DadosTokenJwt(tokenJWT);

        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }

    }

}



