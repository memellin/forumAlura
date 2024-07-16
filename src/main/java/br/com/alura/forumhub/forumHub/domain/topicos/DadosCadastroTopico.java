package br.com.alura.forumhub.forumHub.domain.topicos;

import br.com.alura.forumhub.forumHub.domain.Resposta;
import br.com.alura.forumhub.forumHub.domain.autor.DadosCadastroAutor;
import br.com.alura.forumhub.forumHub.domain.curso.DadosCadastroCurso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroTopico(

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotNull
        LocalDateTime data,

        @NotNull
        @Valid
        DadosCadastroAutor autor,

        @NotNull
        @Valid
        DadosCadastroCurso curso,

        Resposta respostas
) {
}
