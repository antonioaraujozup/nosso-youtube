package br.com.zup.edu.nossoyoutube.video;

import javax.persistence.*;

@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String link;
    @Column(nullable = false)
    private Integer visualizacoes;
    @Column(nullable = false)
    private Integer gostei;//joinha para cima
    @Column(nullable = false)
    private Integer naoGostei;//joinha para baixo

    public Video(String titulo, String descricao, String link) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.link = link;
        this.visualizacoes=0;
        this.gostei=0;
        this.naoGostei=0;
    }

    /**
     * @deprecated
     */
    @Deprecated
    public Video() {
    }

    public Long getId() {
        return id;
    }
}
