package contructionCompany.api.domain.colaborador;

import jakarta.validation.constraints.NotNull;
import contructionCompany.api.endereco.DadosEndereco;

public record DadosAtualizacaoColaborador(
        @NotNull
        Long id,
        String nome,
        String telefone,
        String idade,
        String email,
        String especialidade,
        DadosEndereco endereco) {
}
