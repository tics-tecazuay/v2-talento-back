package com.ista.talento_humano.model.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "horario")
public class Horario implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_horario;

    private String periodoAcademico;

    private String jornadaHorario;

    private String horasSemanalesHorario;

    private String carreraHorario;

    @Column(columnDefinition = "TEXT")
    private String distributivo;


    //Relation
    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;




}
