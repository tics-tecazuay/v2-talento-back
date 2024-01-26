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

import com.ista.talento_humano.model.primary.Habilidades;
import com.ista.talento_humano.services.primary.Service.HabilidadesService;
import com.ista.talento_humano.services.primary.Service.PersonaService;

//@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@CrossOrigin(origins = { "http://localhost:3000/" })
@RestController
@RequestMapping("/talento/api/habilidades")
public class HabilidadesController {

    @Autowired
    HabilidadesService HabilidadesService;
    PersonaService personaService;

    @PostMapping("/create")
    public ResponseEntity<Habilidades> crear(@RequestBody Habilidades obj) {
        try {
            // Asignar el id de la persona al objeto de habilidades
            //obj.setPersona(personaService.findById(obj.getPersona().getId_persona()));
            return new ResponseEntity<>(HabilidadesService.save(obj), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<Habilidades>> obtenerLista() {
        try {
            return new ResponseEntity<>(HabilidadesService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readHabilidades/{id}")
    public ResponseEntity<List<Habilidades>> obtenerHablidades(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(HabilidadesService.listarHabilidadesPorHabilidad(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readHabilidadesPersona/{id}")
    public ResponseEntity<List<Habilidades>> obtenerHabilidadtesPersona(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(HabilidadesService.listarHabilidadesPorPersona(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Habilidades> actualizarUsuario(@PathVariable Long id, @RequestBody Habilidades obj) {
        Habilidades fndObj = HabilidadesService.findById(id);
        if (fndObj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                fndObj.setDescripcion(obj.getDescripcion());
                return new ResponseEntity<>(HabilidadesService.save(fndObj), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            HabilidadesService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar este registro");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
