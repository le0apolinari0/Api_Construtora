package contructionCompany.api.service;

import contructionCompany.api.domain.colaborador.Colaborador;
import contructionCompany.api.domain.colaborador.DadosAtualizacaoColaborador;
import contructionCompany.api.domain.colaborador.DadosCadastroColaborador;
import contructionCompany.api.domain.colaborador.DadosListagemColaborador;
import contructionCompany.api.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FuncionarioService  implements  FuncionarioInterfece{

    @Autowired
    private ColaboradorRepository repository;

    @Override
    public DadosListagemColaborador buscarColaboradorPorId(Long id) {
        Colaborador colaborador = repository.getReferenceById(id);
        return new DadosListagemColaborador(colaborador);
    }

    @Transactional
    @Override
    public DadosListagemColaborador cadastrar(DadosCadastroColaborador dados) {
        Colaborador colaborador = new Colaborador(dados);
        repository.save(colaborador);
        return new DadosListagemColaborador(colaborador);
    }
    @Transactional
    @Override
    public void atualizar(DadosAtualizacaoColaborador dados) {
        Colaborador colaborador = repository.getReferenceById((dados.id()));
        colaborador.atualizarInformacoes(dados);
        repository.save(colaborador);
    }
    @Transactional
    @Override
    public void excluir(Long id) {
        Colaborador colaborador = repository.getReferenceById(id);
        repository.delete(colaborador);
    }
}
