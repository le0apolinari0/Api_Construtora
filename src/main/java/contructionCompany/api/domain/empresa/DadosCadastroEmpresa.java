package contructionCompany.api.domain.empresa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import contructionCompany.api.endereco.DadosEndereco;
import org.hibernate.validator.constraints.br.CNPJ;

//armazena dados
    public record DadosCadastroEmpresa (

            @NotBlank(message = "O campo Nome Empresa é obrigatório")
            String nome,

            @NotBlank(message = "O Campo CNPJ é obrigatório")
            @Pattern(regexp = "^(\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2})|([0-9]{14})$",
            message = "Formato do CNPJ Digitado é inválido! Digite 14 numeros")
            String cnpj,

            @NotBlank(message = "O Campo Telefone é obrigatório")
            @Pattern(regexp = "^\\(?([0-9]{2})\\)?[-.\\s]?([0-9]{5})[-.\\s]?([0-9]{4})$",
                    message = "Formato do Numero Digitado é inválido")
            String telefone,

            @NotBlank(message = "O Campo Email é obrigatório")
            @Email(message = "Formato do Email Digitado é inválido")
            String email,

            @NotNull(message = "Os Dados do endereço são obrigatórios")
            @Valid DadosEndereco endereco){
    }

