package com.ista.talento_humano.controller;

import com.ista.talento_humano.model.primary.Publicaciones;
import com.ista.talento_humano.services.primary.Service.PublicacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@CrossOrigin(origins = { "http://localhost:3000/" })
@RestController
@RequestMapping("/talento/api/publicaciones")
public class PublicacionesController {

    @Autowired
    PublicacionesService publicacionesService;

    @PostMapping("/create")
    public ResponseEntity<Publicaciones> crear(@RequestBody Publicaciones obj) {
        try {
            return new ResponseEntity<>(publicacionesService.save(obj), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<Publicaciones>> obtenerLista() {
        try {
            return new ResponseEntity<>(publicacionesService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/readPublicaciones/{id}")
    public ResponseEntity<List<Publicaciones>> obtenerPublicaciones(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(publicacionesService.listarPublicacionesPorPublicacion(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readPublicacionesPersona/{id}")
    public ResponseEntity<List<Publicaciones>> obtenerPublicacionesPersona(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(publicacionesService.listarPublicacionesPorPersona(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Publicaciones> actualizarPublicacion(@PathVariable Long id, @RequestBody Publicaciones obj) {
        Publicaciones fndObj = publicacionesService.findById(id);
        if (fndObj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                fndObj.setTitulo_publi(obj.getTitulo_publi());
                fndObj.setAutores_publi(obj.getAutores_publi());
                fndObj.setFiliacion_publi(obj.getFiliacion_publi());
                fndObj.setLugar_publi(obj.getLugar_publi());
                fndObj.setFecha_evento(obj.getFecha_evento());
                fndObj.setFecha_publi(obj.getFecha_publi());
                fndObj.setEditorial_publi(obj.getEditorial_publi());
                fndObj.setIsbn_publi(obj.getIsbn_publi());
                fndObj.setIssn_publi(obj.getIssn_publi());
                fndObj.setDoi_publi(obj.getDoi_publi());
                fndObj.setPublicacion(obj.getPublicacion());
                fndObj.setPersona(obj.getPersona());
                return new ResponseEntity<>(publicacionesService.save(fndObj), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            publicacionesService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar este registro");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/publicacion")
    public ResponseEntity<String> obtenerPublicacion(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(publicacionesService.obtenerPublicacion(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
