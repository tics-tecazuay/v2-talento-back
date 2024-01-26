package com.ista.talento_humano.model.secondary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vperiodos")
public class vperiodos implements Serializable {

    @Id
    @Column(name = "per_codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long per_codigo;

    private String per_nombre;

    @Column(name = "per_fechainicio")
    private Date per_fechainicio;

    @Column(name = "per_fechafin")
    private Date per_fechafin;

    @Column(name = "car_descripcion")
    private String car_descripcion;

    @Column(name = "car_id")
    private String car_id;
}
