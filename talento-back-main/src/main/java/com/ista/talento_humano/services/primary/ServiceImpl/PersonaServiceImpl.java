package com.ista.talento_humano.services.primary.ServiceImpl;

import com.ista.talento_humano.model.primary.*;
import com.ista.talento_humano.repository.primary.*;
import com.ista.talento_humano.services.primary.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    CapacitacionesRepository capacitacionesRepository;

    @Autowired
    CargaFamiliarRepository cargaFamiliarRepository;

    @Autowired
    PublicacionesRepository publicacionesRepository;

    @Autowired
    RecomedacionesRepository recomedacionesRepository;

    @Autowired
    HorarioRepository horarioRepository;

    @Autowired
    HabilidadesRepository habilidadesRepository;

    @Autowired
    EvaluacionDocenteRepository evaluacionDocenteRepository;

    @Autowired
    ContratoRepository contratoRepository;

    @Autowired
    InstruccionFormalRepository instruccionFormalRepository;

    @Autowired
    ExperienciaRepository experienciaRepository;



    @Override
    public CrudRepository<Persona, Long> getDao() {

        return personaRepository;
    }

    @Override
    public List<Capacitaciones> listarCapacitacionesPorPersona(Long idPersona) {
        return capacitacionesRepository.listarCapacitacionesPorPersona(idPersona);
    }

    @Override
    public List<CargaFamiliar> listarCargaFamiliarPorPersona(Long idPersona) {
        return cargaFamiliarRepository.listarCargaFamiliarPorPersona(idPersona);
    }

    @Override
    public List<Contrato> listarContratosPorPersona(Long idPersona) {
        return contratoRepository.listarContratosPorPersona(idPersona);
    }

    @Override
    public List<EvaluacionDocente> listarEvaluacionesPorPersona(Long idPersona) {
        return evaluacionDocenteRepository.listarEvaluacionesPorPersona(idPersona);
    }

    @Override
    public List<Habilidades> listarHabilidadesPorPersona(Long idPersona) {
        return habilidadesRepository.listarHabilidadesPorPersona(idPersona);
    }

    @Override
    public List<Horario> listarHorariosPorPersona(Long idPersona) {
        return horarioRepository.listarHorariosPorPersona(idPersona);
    }

    @Override
    public List<Publicaciones> listarPublicacionesPorPersona(Long idPersona) {
        return publicacionesRepository.listarPublicacionesPorPersona(idPersona);
    }

    @Override
    public List<Recomendaciones> listarRecomendacionesPorPersona(Long idPersona) {
        return recomedacionesRepository.listarRecomendacionesPorPersona(idPersona);
    }

    @Override
    public List<Experiencia> listarExperienciaPorPersona(Long idPersona) {
        return experienciaRepository.listarExperienciaPorPersona(idPersona);
    }

    @Override
    public List<InstruccionFormal> listarInstruccionFormalPorPersona(Long idPersona) {
        return instruccionFormalRepository.listarInstruccionFormalPorPersona(idPersona);
    }

    @Override
    public Persona findByCedula(String cedula) {
        return personaRepository.findByCedula(cedula);
    }

    @Override
    public List<Persona> listarPersona(Long idPersona) {
        return personaRepository.listarPersona(idPersona);
    }

    @Override
    public List<Persona> listarPersona1(Long idPersona) {
        return null;
    }

    @Override
    public String obtenerCvEmpleado(Long idPersona) {
        return personaRepository.obtenerCvEmpleado(idPersona);
    }

    @Override
    public String obtenerMecaiess(Long idPersona) {
        return personaRepository.obtenerMecaiess(idPersona);
    }

    @Override
    public String obtenerDocpers(Long idPersona) {
        return personaRepository.obtenerDocpers(idPersona);
    }

}
