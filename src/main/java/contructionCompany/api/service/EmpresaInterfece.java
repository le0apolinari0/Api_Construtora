package contructionCompany.api.service;

import contructionCompany.api.domain.empresa.DadosAtualizacaoEmpresa;
import contructionCompany.api.domain.empresa.DadosCadastroEmpresa;
import contructionCompany.api.domain.empresa.DadosEmpresaDetalhado;
import contructionCompany.api.domain.empresa.Empresa;
import jakarta.transaction.Transactional;

import java.util.Optional;

public interface EmpresaInterfece {
    Optional<DadosEmpresaDetalhado> detalharCadastroEmpresa(Long id);
    DadosEmpresaDetalhado cadastrar(DadosCadastroEmpresa dados);
    DadosEmpresaDetalhado atualizar(Long id, DadosAtualizacaoEmpresa dados);
    void excluir(Long id);
}


