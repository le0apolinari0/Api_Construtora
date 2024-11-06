package contructionCompany.api.controller;

import contructionCompany.api.domain.empresa.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("empresa")
public class EmpresaController  {

        @Autowired
        private EmpresaRepository repository;

        @PostMapping
        @Transactional
        public ResponseEntity cadastrar(
                @RequestBody @Valid DadosCadastroEmpresa dados, UriComponentsBuilder uriCadastro) {
            var empresa = new Empresa(dados);
            repository.save(empresa);

            var uri = uriCadastro.path("/empresa/{id}").buildAndExpand(empresa.getId()).toUri();
            return ResponseEntity.created(uri).body( new DadosEmpresaDetalhado(empresa));
        }


        @GetMapping
        public ResponseEntity <Page<DadosListagemEmpresa>> listar(
                @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){

            var page = repository.findAllByAtivoTrue(paginacao)
                    .map(DadosListagemEmpresa::new);

            return ResponseEntity.ok(page);

        }

        @PutMapping
        @Transactional
        public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoEmpresa dados){
            var  empresa = repository.getReferenceById(dados.id());
            empresa.altualizarInformacoes(dados);

            return  ResponseEntity.ok(new DadosEmpresaDetalhado(empresa));
        }

        @DeleteMapping("/{id}")
        @Transactional
        public ResponseEntity excluir( @PathVariable Long id){
            var  empresa = repository.getReferenceById(id);
            empresa.excluir();

            return ResponseEntity.noContent().build();

        }
        @GetMapping("/{id}")
        public  ResponseEntity detalharCadastroEmpresa(@PathVariable Long id){
            var empresa = repository.getReferenceById(id);

            return ResponseEntity.ok(new DadosEmpresaDetalhado(empresa));
        }


    }

