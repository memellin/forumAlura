package br.com.alura.forumhub.forumHub.controller;


import br.com.alura.forumhub.forumHub.domain.RespostasRepository;
import br.com.alura.forumhub.forumHub.domain.autor.AutorRepository;
import br.com.alura.forumhub.forumHub.domain.curso.CursoRepository;
import br.com.alura.forumhub.forumHub.domain.topicos.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private RespostasRepository respostasRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriComponent){
        Topico topico = new Topico(dados);
        autorRepository.save(topico.getAutor());
        cursoRepository.save(topico.getCurso());
        respostasRepository.save(topico.getRespostas());
        topicoRepository.save(topico);
        var uri = uriComponent.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicos>> listar(Pageable paginacao){
        var page = topicoRepository.findAll(paginacao).map(DadosListagemTopicos::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemTopicos> detalhar(@PathVariable Long id){
        var topico = topicoRepository.getReferenceById(id);
        var topicoDto = new DadosListagemTopicos(topico);

        return ResponseEntity.ok(topicoDto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopico> atualizar(@RequestBody DadosAtualizacaoTopico dados, @PathVariable Long id){
        var topicoBd = topicoRepository.findById(id);

        if (topicoBd.isPresent()){
            var topico = topicoBd.get();
            topico.atualizar(dados);
            return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
