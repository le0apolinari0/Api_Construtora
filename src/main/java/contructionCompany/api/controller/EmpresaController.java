package contructionCompany.api.controller;

import contructionCompany.api.domain.empresa.*;
import contructionCompany.api.repository.EmpresaRepository;
import contructionCompany.api.service.EmpresaService;
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
    private EmpresaService service;

        @GetMapping("/{id}")
        public ResponseEntity<DadosEmpresaDetalhado> detalharCadastroEmpresa(@PathVariable Long id) {
            return service.detalharCadastroEmpresa(id)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }
        @GetMapping
        public ResponseEntity <Page<DadosListagemEmpresa>> listar(
                @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
            var page = repository.findAllByAtivoTrue(paginacao)
                    .map(DadosListagemEmpresa::new);
            return ResponseEntity.ok(page);

        }

        @PostMapping
        public ResponseEntity<DadosEmpresaDetalhado> cadastrar(
                @RequestBody @Valid DadosCadastroEmpresa dados,
                UriComponentsBuilder uriCadastro) {
            var empresa = service.cadastrar(dados);
            var uri = uriCadastro.path("/empresa/{id}").buildAndExpand(empresa.id()).toUri();
            return ResponseEntity.created(uri).body(empresa);
        }
        @PutMapping("/{id}")
        public ResponseEntity<DadosEmpresaDetalhado> atualizar(
                @PathVariable Long id,
                @RequestBody @Valid DadosAtualizacaoEmpresa dados) {
            return ResponseEntity.ok(service.atualizar(id, dados));
        }

        @DeleteMapping("/{id}")
        @Transactional
        public ResponseEntity<Void> excluir(@PathVariable Long id) {
            service.excluir(id);
            return ResponseEntity.noContent().build();
        }

}

