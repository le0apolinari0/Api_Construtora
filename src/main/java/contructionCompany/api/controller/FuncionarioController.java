package contructionCompany.api.controller;

import contructionCompany.api.domain.colaborador.*;
import contructionCompany.api.repository.ColaboradorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("colaborador")
public class FuncionarioController {

    @Autowired
    private ColaboradorRepository repository;

    @GetMapping
    public Page<DadosListagemColaborador> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemColaborador::new);
    }
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
