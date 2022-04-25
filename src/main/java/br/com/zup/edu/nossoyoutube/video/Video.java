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

    @Version
    private int versao;

    @OneToOne(mappedBy = "video", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeGosteiVideo quantidadeGostei; //njoinha para cima

    @OneToOne(mappedBy = "video", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeNaoGosteiVideo quantidadeNaoGostei; // joinha para baixo

    public Video(String titulo, String descricao, String link) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.link = link;
        this.visualizacoes=0;
        this.quantidadeGostei = new QuantidadeGosteiVideo(this);
        this.quantidadeNaoGostei = new QuantidadeNaoGosteiVideo(this);
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

    public void incrementaGostei() {
        this.quantidadeGostei.incrementa();
    }

    public void incrementaNaoGostei() {
        this.quantidadeNaoGostei.incrementa();
    }
}
