package com.ista.talento_humano.model.primary;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "vfiltros")
public class VFiltros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long id_persona;

    @Column(name = "apellido_paterno")
    private String apellido_paterno;

    @Column(name = "primer_nombre")
    private String primer_nombre;

    @Column(name = "discapacidad")
    private String discapacidad;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "genero")
    private String genero;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fecha_inicio;

    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fecha_fin;

    @Column(name = "contrato_vigente")
    private Boolean contrato_vigente;

    @Column(name = "salario_publico")
    private String salario_publico;

    @Column(name = "salario")
    private Double salario;

    @Column(name = "tiempo_dedicacion")
    private String tiempo_dedicacion;

}
