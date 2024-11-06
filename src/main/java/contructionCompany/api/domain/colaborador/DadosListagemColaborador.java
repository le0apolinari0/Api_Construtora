package contructionCompany.api.domain.colaborador;

public record DadosListagemColaborador(
        Long id,
        String nome,
        String email,
        String cpf,
        String idade,
        String dataNascimento,
        Especialidade especialidade) {

    public DadosListagemColaborador(Colaborador colaborador) {
        this(
                colaborador.getId(),
                colaborador.getNome(),
                colaborador.getIdade(),
                colaborador.getDataNascimento(),
                colaborador.getEmail(),
                colaborador.getCpf(),
                colaborador.getEspecialidade());
    }

}
