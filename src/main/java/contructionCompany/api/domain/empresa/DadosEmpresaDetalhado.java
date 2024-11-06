package contructionCompany.api.domain.empresa;

import contructionCompany.api.endereco.Endereco;

public record DadosEmpresaDetalhado(
        Long id,
        String nome,
        String email,
        String telefone,
        String cnpj,
        Endereco endereco) {

    public DadosEmpresaDetalhado(Empresa empresa){
        this(
                empresa.getId(),
                empresa.getNome(),
                empresa.getEmail(),
                empresa.getTelefone(),
                empresa.getCnpj(),
                empresa.getEndereco());

    }
}