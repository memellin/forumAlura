package br.com.alura.forumhub.forumHub.domain.autor;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;

    public Autor(DadosCadastroAutor autor) {
        this.nome = autor.nome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
