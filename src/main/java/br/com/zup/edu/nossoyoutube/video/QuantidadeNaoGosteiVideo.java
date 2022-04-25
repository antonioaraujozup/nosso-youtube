package br.com.zup.edu.nossoyoutube.video;

import javax.persistence.*;

@Entity
public class QuantidadeNaoGosteiVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private long quantidade;

    @Version
    private int versao;

    @OneToOne(optional = false)
    private Video video;

    public QuantidadeNaoGosteiVideo(Video video) {
        this.video = video;
        this.quantidade = 0;
    }

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public QuantidadeNaoGosteiVideo() {
    }

    public void incrementa() {
        this.quantidade++;
    }
}
