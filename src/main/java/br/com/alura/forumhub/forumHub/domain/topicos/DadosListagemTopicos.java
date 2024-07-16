package br.com.alura.forumhub.forumHub.domain.topicos;

import br.com.alura.forumhub.forumHub.domain.autor.Autor;
import br.com.alura.forumhub.forumHub.domain.curso.Curso;

import java.time.LocalDateTime;

public record DadosListagemTopicos(
        Long id,
        String titulo,
        String mensagem,
        Status status,
        Autor autor,
        Curso curso
) {
    public DadosListagemTopicos(Topico t) {
        this(t.getId(), t.getTitulo(), t.getMensagem(), t.getStatus(), t.getAutor(), t.getCurso());
    }
}
