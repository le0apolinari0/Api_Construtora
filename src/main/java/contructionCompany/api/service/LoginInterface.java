package contructionCompany.api.service;

import contructionCompany.api.domain.usuarioLog.DadosAutenticacao;
import contructionCompany.api.infra.security.DadosTokenJwt;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface LoginInterface extends UserDetailsService {
    DadosTokenJwt efetuarLogin(DadosAutenticacao dados);
}