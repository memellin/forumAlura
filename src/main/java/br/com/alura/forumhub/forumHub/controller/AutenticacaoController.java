package br.com.alura.forumhub.forumHub.controller;

import br.com.alura.forumhub.forumHub.domain.usuario.DadosAutenticacao;
import br.com.alura.forumhub.forumHub.domain.usuario.Usuario;
import br.com.alura.forumhub.forumHub.infra.TokenService;
import br.com.alura.forumhub.forumHub.infra.security.DadosTokenJWT;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var tokenAuthentication = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authetication = manager.authenticate(tokenAuthentication);

        var tokenJWT = tokenService.gerarToken((Usuario) authetication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
