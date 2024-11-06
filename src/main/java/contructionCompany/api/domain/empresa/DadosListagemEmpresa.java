package contructionCompany.api.domain.empresa;

public record DadosListagemEmpresa(
        Long id,
        String nome,
        String email,
        String cnpj,
        String telefone) {
    public DadosListagemEmpresa(Empresa empresa) {
        this(
                empresa.getId(),
                empresa.getNome(),
                empresa.getEmail(),
                empresa.getCnpj(),
                empresa.getTelefone());
    }
}