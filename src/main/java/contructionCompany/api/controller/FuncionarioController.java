package contructionCompany.api.controller;

import contructionCompany.api.domain.colaborador.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroColaborador dados) {
        repository.save(new Colaborador(dados));

//        public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroColaborador dados, UriComponentsBuilder
//        uriCadastro) {
//            var funcionario = new Colaborador(dados);
//            repository.save(funcionario);
//            var uri = uriCadastro.path("/colaborador/{id}").buildAndExpand(funcionario.getId()).toUri();
//            return ResponseEntity.created(uri).body( new DadosListagemColaborador(funcionario));
//        }
    }

    @GetMapping
    public Page<DadosListagemColaborador> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemColaborador::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoColaborador dados) {
        var colaborador = repository.getReferenceById(dados.id());
        colaborador.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var colaborador = repository.getReferenceById(id);
        colaborador.excluir();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity cadastroColaborador(@PathVariable Long id){
//        var colaborador = repository.getReferenceById(id);
//
//        return ResponseEntity.ok(new DadosListagemColaborador(colaborador));
//    }


}
