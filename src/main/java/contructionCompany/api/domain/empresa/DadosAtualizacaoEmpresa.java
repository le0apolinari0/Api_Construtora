package contructionCompany.api.domain.empresa;

import jakarta.validation.Valid;
import contructionCompany.api.endereco.DadosEndereco;

public record DadosAtualizacaoEmpresa(
          Long id,
          String nome,
          String telefone,
          @Valid DadosEndereco endereco
) {
}
