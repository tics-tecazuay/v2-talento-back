package com.ista.talento_humano.controller;

import java.util.List;

import com.ista.talento_humano.model.primary.EvaluacionDocente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ista.talento_humano.model.primary.Experiencia;
import com.ista.talento_humano.services.primary.Service.ExperienciaService;

//@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" }
@CrossOrigin(origins = { "http://localhost:3000/" })
@RestController
@RequestMapping("/talento/api/experiencia")
public class ExperienciaController {

    @Autowired
    ExperienciaService ExperienciaService;

    @PostMapping("/create")
    public ResponseEntity<Experiencia> crear(@RequestBody Experiencia obj) {
        try {
            return new ResponseEntity<>(ExperienciaService.save(obj), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<Experiencia>> obtenerLista() {
        try {
            return new ResponseEntity<>(ExperienciaService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readExperiencia/{id}")
    public ResponseEntity<List<Experiencia>> obtenerEvaluacionDocente(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(ExperienciaService.listarExperienciaPorExperiencia(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readExperienciaPersona/{id}")
    public ResponseEntity<List<Experiencia>> obtenerEvaluacionDocentePersona(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(ExperienciaService.listarExperienciaPorPersona(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Experiencia> actualizarUsuario(@PathVariable Long id, @RequestBody Experiencia obj) {
        Experiencia fndObj = ExperienciaService.findById(id);
        if (fndObj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                fndObj.setInstitucion(obj.getInstitucion());
                fndObj.setPuesto(obj.getPuesto());
                fndObj.setArea_trabajo(obj.getArea_trabajo());
                fndObj.setFecha_inicio(obj.getFecha_inicio());
                fndObj.setFecha_fin(obj.getFecha_fin());
                fndObj.setFecha_inicio(obj.getFecha_inicio());
                fndObj.setActividades(obj.getActividades());
                fndObj.setEstado(obj.getEstado());
                fndObj.setCertificado_trabajo(obj.getCertificado_trabajo());
                return new ResponseEntity<>(ExperienciaService.save(fndObj), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            ExperienciaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar este registro");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/certificado_trabajo")
    public ResponseEntity<String> obtenerCertificado(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(ExperienciaService.obtenerCertificado(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
