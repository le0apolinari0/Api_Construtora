package contructionCompany.api.endereco;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank String cidade,
        @NotBlank String bairro,
        @NotBlank @Pattern(regexp = "\\d{1,8}") String cep,
        @NotBlank @Pattern(regexp = "\\d{1,8}") String numero,
        @NotBlank String uf,
        String logradouro,
        String complemento
        ) {
}
