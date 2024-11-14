package contructionCompany.api.service;

import contructionCompany.api.domain.empresa.*;
import contructionCompany.api.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;


@Service
public class EmpresaService implements  EmpresaInterfece {

    @Autowired
    private EmpresaRepository repository;

    @Transactional
    @Override
    public Optional<DadosEmpresaDetalhado> detalharCadastroEmpresa(Long id) {
        Empresa empresa = repository.findById(id).orElseThrow(() -> new NotFoundException("Empresa não encontrada"));
        return Optional.of(new DadosEmpresaDetalhado(empresa));
    }

    @Transactional
    @Override
    public DadosEmpresaDetalhado cadastrar(DadosCadastroEmpresa dados) {
        var empresa = new Empresa(dados);
        repository.save(empresa);
        return new DadosEmpresaDetalhado(empresa);
    }
    @Transactional
    @Override
    public DadosEmpresaDetalhado atualizar(Long id, DadosAtualizacaoEmpresa dados) {
        var empresa = repository.getReferenceById(id);
        empresa.altualizarInformacoes(dados) ;
        return new DadosEmpresaDetalhado(empresa);
    }
    @Transactional
    @Override
    public void excluir(Long id) {
        var empresa = repository.getReferenceById(id);
        repository.delete(empresa);
    }

}

