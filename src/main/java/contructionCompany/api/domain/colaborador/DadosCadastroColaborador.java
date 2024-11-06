package contructionCompany.api.domain.colaborador;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import contructionCompany.api.endereco.DadosEndereco;

public record DadosCadastroColaborador(

        @NotBlank String nome,

        @NotBlank @Pattern(regexp = "\\d{1,3}") String idade,

        @NotBlank @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}",
                message = "Formato de data inválido") String dataNascimento,

        @NotBlank @Email String email,

        @NotBlank String telefone,

        @NotBlank @Pattern(regexp = "\\d{1,12}") String cpf,

        @NotNull(message = "Campo especialidade deve estar preenchido")
        Especialidade especialidade,

        @NotNull(message = "Os Dados do endereço são obrigatórios")
        @Valid DadosEndereco endereco) {
}
