package com.ista.talento_humano.model.primary;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ista.talento_humano.model.secondary.Distributivo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persona")
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long id_persona;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "apellido_paterno")
    private String apellido_paterno;

    @Column(name = "apellido_materno")
    private String apellido_materno;

    @Column(name = "primer_nombre")
    private String primer_nombre;

    @Column(name = "segundo_nombre")
    private String segundo_nombre;

    @Column(name = "fecha_nacimiento")
    private String fecha_nacimiento;

    @Column(name = "pais_natal")
    private String pais_natal;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "genero")
    private String genero;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "tipo_sangre")
    private String tipo_sangre;

    @Column(name = "estado_civil")
    private String estado_civil;

    @Column(name = "etnia")
    private String etnia;

    @Column(name = "idioma_raiz")
    private String idioma_raiz;

    @Column(name = "idioma_secundario")
    private String idioma_secundario;

    ////////////////////////////////////////////

    @Column(name = "pais_residencia")
    private String pais_residencia;

    @Column(name = "provincia_residencia")
    private String provincia_residencia;

    @Column(name = "canton_residencia")
    private String canton_residencia;

    @Column(name = "parroquia_residencia")
    private String parroquia_residencia;

    @Column(name = "calles")
    private String calles;

    @Column(name = "numero_casa")
    private String numero_casa;

    @Column(name = "sector")
    private String sector;

    @Column(name = "referencia")
    private String referencia;

    //////////////////////////////////////////////////

    @Column(name = "celular")
    private String celular;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    @Column(name = "correo_institucional")
    private String correo_institucional;

    ///////////////////////////////////////////////

    @Column(name = "discapacidad")
    private String discapacidad;

    @Column(name = "tipo_discapacidad")
    private String tipo_discapacidad;

    @Column(name = "porcentaje_discapacidad")
    private String porcentaje_discapacidad;

    @Column(name = "carnet_conadis")
    private String carnet_conadis;

    ////////////////////////////////////////////////

    @Column(name = "foto_carnet", columnDefinition = "TEXT")
    private String foto_carnet;

    @Column(name = "foto", columnDefinition = "TEXT")
    private String foto;

    @Column(name = "cv_socioempleo", columnDefinition = "TEXT")
    private String cv_socioempleo;

    @Column(name = "mecanizado_iess", columnDefinition = "TEXT")
    private String mecanizado_iess;

    @Column(name = "documentos_personales", columnDefinition = "TEXT")
    private String documentos_personales;

    @Column(name = "descripcion_perfil")
    private String descripcion_perfil;

    ////////////////////////////////////////////////

    /*Revizar campos Fenix*/

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private Usuario usuario;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private Horario horario;


    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Experiencia> experiencias;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Recomendaciones> recomendaciones;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Contrato> contrato;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<InstruccionFormal> instruccionFormal;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Capacitaciones> capacitaciones;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CargaFamiliar> cargaFamiliar;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Habilidades> habilidades;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<EvaluacionDocente> evaluacionDocentes;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Publicaciones> publicaciones;

    @Override
    public String toString() {
        return "Persona{" +
                "id_persona=" + id_persona +
                ", cedula='" + cedula + '\'' +
                ", apellido_paterno='" + apellido_paterno + '\'' +
                ", apellido_materno='" + apellido_materno + '\'' +
                ", primer_nombre='" + primer_nombre + '\'' +
                ", segundo_nombre='" + segundo_nombre + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", pais_natal='" + pais_natal + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", sexo='" + sexo + '\'' +
                ", tipo_sangre='" + tipo_sangre + '\'' +
                ", estado_civil='" + estado_civil + '\'' +
                ", etnia='" + etnia + '\'' +
                ", idioma_raiz='" + idioma_raiz + '\'' +
                ", idioma_secundario='" + idioma_secundario + '\'' +
                ", pais_residencia='" + pais_residencia + '\'' +
                ", provincia_residencia='" + provincia_residencia + '\'' +
                ", canton_residencia='" + canton_residencia + '\'' +
                ", parroquia_residencia='" + parroquia_residencia + '\'' +
                ", calles='" + calles + '\'' +
                ", numero_casa='" + numero_casa + '\'' +
                ", sector='" + sector + '\'' +
                ", referencia='" + referencia + '\'' +
                ", celular='" + celular + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", correo_institucional='" + correo_institucional + '\'' +
                ", discapacidad='" + discapacidad + '\'' +
                ", tipo_discapacidad='" + tipo_discapacidad + '\'' +
                ", porcentaje_discapacidad='" + porcentaje_discapacidad + '\'' +
                ", carnet_conadis='" + carnet_conadis + '\'' +
                ", foto_carnet='" + foto_carnet + '\'' +
                ", foto='" + foto + '\'' +
                ", cv_socioempleo='" + cv_socioempleo + '\'' +
                ", mecanizado_iess='" + mecanizado_iess + '\'' +
                ", documentos_personales='" + documentos_personales + '\'' +
                ", descripcion_perfil='" + descripcion_perfil + '\'' +
                ", usuario=" + usuario +
                ", horario=" + horario +
                ", experiencias=" + experiencias +
                ", recomendaciones=" + recomendaciones +
                ", contrato=" + contrato +
                ", instruccionFormal=" + instruccionFormal +
                ", capacitaciones=" + capacitaciones +
                ", cargaFamiliar=" + cargaFamiliar +
                ", habilidades=" + habilidades +
                ", evaluacionDocentes=" + evaluacionDocentes +
                ", publicaciones=" + publicaciones +
                '}';
    }
}

