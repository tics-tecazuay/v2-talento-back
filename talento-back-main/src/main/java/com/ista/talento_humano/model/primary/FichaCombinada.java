package com.ista.talento_humano.model.primary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FichaCombinada {

    private Persona persona;
    private List<Capacitaciones> capacitaciones;
    private List<CargaFamiliar> cargaFamiliar;
    private List<Contrato> contratos;
    private List<EvaluacionDocente> evaluaciones;
    private List<Habilidades> habilidades;
    private List<Horario> horarios;
    private List<Publicaciones> publicaciones;
    private List<Recomendaciones> recomendaciones;
    private List<InstruccionFormal> instruccionFormals;
    private List<Experiencia> experiencias;

}
