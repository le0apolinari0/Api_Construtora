package contructionCompany.api.domain.empresa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import contructionCompany.api.endereco.Endereco;

    @Getter
    @EqualsAndHashCode(of = "id")
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "empresa")
    @Entity(name = "Empresa")

    public class Empresa {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String cnpj;
        private String email;
        private String telefone;

        @Embedded
        private Endereco endereco;
        private boolean ativo;

        public Empresa(DadosCadastroEmpresa dados) {
            this.ativo= true;
            this.nome = dados.nome();
            this.cnpj = dados.cnpj();
            this.email = dados.email();
            this.telefone = dados.telefone();
            this.endereco = new Endereco(dados.endereco());
        }

        public void altualizarInformacoes(DadosAtualizacaoEmpresa dados) {

            if (dados.nome() != null){
                this.nome= dados.nome();
            }
            if (dados.telefone() != null){
                this.telefone= dados.telefone();
            }
            if (dados.endereco() != null){
                this.endereco.atualizarInformacoes(dados.endereco()) ;
            }
        }
        public void excluir() {
            this.ativo = false;
        }
    }

