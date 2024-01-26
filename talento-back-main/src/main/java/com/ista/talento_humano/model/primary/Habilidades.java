package com.ista.talento_humano.model.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "habilidades")
public class Habilidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habilidades")
    private Long id_habilidades;

    @Column(name = "descripcion")
    private String Descripcion;
    
    /*Relacion con persona*/
	@ManyToOne
	@JoinColumn(name = "id_persona")
	private Persona persona;


    
    
}
