package contructionCompany.api.controller;

import contructionCompany.api.domain.colaborador.*;
import contructionCompany.api.repository.ColaboradorRepository;
import contructionCompany.api.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("colaborador")
public class FuncionarioController {

    @Autowired
    private ColaboradorRepository repository;
    @Autowired
    private FuncionarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemColaborador> cadastroColaborador(@PathVariable Long id) {
        DadosListagemColaborador dados = service.buscarColaboradorPorId(id);
        return ResponseEntity.ok(dados);
    }


    @GetMapping
    public Page<DadosListagemColaborador> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemColaborador::new);
    }

    @PostMapping
    public ResponseEntity<DadosListagemColaborador> cadastrar(@RequestBody @Valid DadosCadastroColaborador dados, UriComponentsBuilder uriCadastro) {
        DadosListagemColaborador dadosListagem = service.cadastrar(dados);
        var uri = uriCadastro.path("/colaborador/{id}").buildAndExpand(dadosListagem.id()).toUri();
        return ResponseEntity.created(uri).body(dadosListagem);
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody @Valid DadosAtualizacaoColaborador dados) {
        service.atualizar(dados);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
