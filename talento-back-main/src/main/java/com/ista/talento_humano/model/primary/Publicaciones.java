package com.ista.talento_humano.model.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "publicaciones")
public class Publicaciones {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publi")
    private Long id_publi;

    @Column(name = "titulo_publi")
    private String titulo_publi;

    @Column(name = "autores_publi")
    private String autores_publi;
//Long-Text
    @Column(name = "filiacion_publi")
    private String filiacion_publi;

    @Column(name = "lugar_publi")
    private String lugar_publi;

    @Column(name = "fecha_evento")
    private Date fecha_evento;

    @Column(name = "fecha_publi")
    private Date fecha_publi;

    @Column(name = "editorial_publi")
    private String editorial_publi;

    @Column(name = "isbn_publi")
    private String isbn_publi;

    @Column(name = "issn_publi")
    private String issn_publi;

    @Column(name = "doi_publi")
    private String doi_publi;

    @Column(name = "publicacion", columnDefinition = "TEXT")
    private String publicacion;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
}
