package com.ista.talento_humano.controller;

import java.util.List;

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

import com.ista.talento_humano.model.primary.PeriodoAcademico;
import com.ista.talento_humano.services.primary.Service.PeriodoAcademicoService;

//@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@CrossOrigin(origins = { "http://localhost:3000/" })
@RestController
@RequestMapping("/talento/api/periodoacademico")
public class PeriodoAcademicoController {

    @Autowired
    PeriodoAcademicoService PeriodoAcademicoService;

    @PostMapping("/create")
    public ResponseEntity<PeriodoAcademico> crear(@RequestBody PeriodoAcademico obj) {
        try {
            return new ResponseEntity<>(PeriodoAcademicoService.save(obj), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<PeriodoAcademico>> obtenerLista() {
        try {
            return new ResponseEntity<>(PeriodoAcademicoService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PeriodoAcademico> actualizarPeriodo(@PathVariable Long id, @RequestBody PeriodoAcademico obj) {
        PeriodoAcademico fndObj = PeriodoAcademicoService.findById(id);
        if (fndObj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                fndObj.setNombre(obj.getNombre());
                fndObj.setFecha_inicio(obj.getFecha_inicio());
                fndObj.setFecha_fin(obj.getFecha_fin());
                return new ResponseEntity<>(PeriodoAcademicoService.save(fndObj), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            PeriodoAcademicoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar este registro");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
