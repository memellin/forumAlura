package br.com.alura.forumhub.forumHub.domain.topicos;

import br.com.alura.forumhub.forumHub.domain.Resposta;

public record DadosAtualizacaoTopico (
    String titulo,
    String mensagem,
    Resposta respostas
){}

