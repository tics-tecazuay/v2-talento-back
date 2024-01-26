package com.ista.talento_humano.controller;

import java.util.List;

import com.ista.talento_humano.model.primary.CargaFamiliar;
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

import com.ista.talento_humano.model.primary.EvaluacionDocente;
import com.ista.talento_humano.services.primary.Service.EvaluacionDocenteService;

//@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@CrossOrigin(origins = { "http://localhost:3000/" })
@RestController
@RequestMapping("/talento/api/evaluaciondocente")
public class EvaluacionDocenteController {

    @Autowired
    EvaluacionDocenteService EvaluacionDocenteService;

    @PostMapping("/create")
    public ResponseEntity<EvaluacionDocente> crear(@RequestBody EvaluacionDocente obj) {
        try {
            return new ResponseEntity<>(EvaluacionDocenteService.save(obj), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<EvaluacionDocente>> obtenerLista() {
        try {
            return new ResponseEntity<>(EvaluacionDocenteService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readEvaluacion/{id}")
    public ResponseEntity<List<EvaluacionDocente>> obtenerEvaluacionDocente(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(EvaluacionDocenteService.listarEvaluacionesPorEvaluaciones(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readEvaluacionPersona/{id}")
    public ResponseEntity<List<EvaluacionDocente>> obtenerEvaluacionDocentePersona(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(EvaluacionDocenteService.listarEvaluacionPorPersona(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EvaluacionDocente> actualizarUsuario(@PathVariable Long id, @RequestBody EvaluacionDocente obj) {
        EvaluacionDocente fndObj = EvaluacionDocenteService.findById(id);
        if (fndObj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                fndObj.setCod_carrera(obj.getCod_carrera());
                fndObj.setEvidencia_evaluacion(obj.getEvidencia_evaluacion());

                return new ResponseEntity<>(EvaluacionDocenteService.save(fndObj), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            EvaluacionDocenteService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar este registro");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/evidencia_evaluacion")
    public ResponseEntity<String> obtenerDocperso(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(EvaluacionDocenteService.obtenerEvidencia(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
