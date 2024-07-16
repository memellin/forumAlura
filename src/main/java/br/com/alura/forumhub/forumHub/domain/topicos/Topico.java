package br.com.alura.forumhub.forumHub.domain.topicos;

import br.com.alura.forumhub.forumHub.domain.Resposta;
import br.com.alura.forumhub.forumHub.domain.autor.Autor;
import br.com.alura.forumhub.forumHub.domain.curso.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String titulo;

    @Column(unique = true, nullable = false)
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @OneToOne
    @JoinColumn(name = "respostas_id")
    private Resposta respostas;

    @Enumerated(EnumType.STRING)
    private Status status;


    public Topico(DadosCadastroTopico dados){
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = new Autor(dados.autor());
        this.curso = new Curso(dados.curso());
        this.status = Status.ABERTO;
    }

    @OneToMany(mappedBy = "topico")
    public Resposta getRespostas() {
        return respostas;
    }

    public Status getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Autor getAutor() {
        return autor;
    }

    public Curso getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        return "Topico{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", autor=" + autor +
                ", curso=" + curso +
                '}';
    }

    public void atualizar(DadosAtualizacaoTopico dados) {

        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }

        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }

        if (dados.respostas() != null){
            this.respostas = new Resposta(dados.respostas());
        }
    }
}
