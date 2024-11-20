package contructionCompany.api.service;


import contructionCompany.api.domain.colaborador.DadosAtualizacaoColaborador;
import contructionCompany.api.domain.colaborador.DadosCadastroColaborador;
import contructionCompany.api.domain.colaborador.DadosListagemColaborador;
import org.springframework.transaction.annotation.Transactional;

public interface FuncionarioInterfece {

    DadosListagemColaborador buscarColaboradorPorId(Long id);

    @Transactional
    DadosListagemColaborador cadastrar(DadosCadastroColaborador dados);

    @Transactional
    void atualizar(DadosAtualizacaoColaborador dados);

    @Transactional
    void excluir(Long id);
}


