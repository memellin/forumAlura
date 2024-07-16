package br.com.alura.forumhub.forumHub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCurso(
        @NotBlank
        String titulo
) {
}
