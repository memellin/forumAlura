package br.com.alura.forumhub.forumHub.domain.topicos;

import br.com.alura.forumhub.forumHub.domain.autor.Autor;
import br.com.alura.forumhub.forumHub.domain.curso.Curso;

public record DadosDetalhamentoTopico(
        String titulo,
        String mensagem,
        Autor autor,
        Curso curso
) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getAutor(), topico.getCurso());
    }
}
