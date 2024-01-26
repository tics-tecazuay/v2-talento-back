package com.ista.talento_humano.controller;

import com.ista.talento_humano.model.primary.Recomendaciones;
import com.ista.talento_humano.services.primary.Service.RecomendacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@CrossOrigin(origins = { "http://localhost:3000/" })
@RestController
@RequestMapping("/talento/api/recomendaciones")
public class RecomendacionesController {


    @Autowired
    RecomendacionesService recomendacionesService;

    @PostMapping("/create")
    public ResponseEntity<Recomendaciones> crear(@RequestBody Recomendaciones obj) {
        try {
            return new ResponseEntity<>(recomendacionesService.save(obj), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<Recomendaciones>> obtenerLista() {
        try {
            return new ResponseEntity<>(recomendacionesService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/readRecomendaciones/{id}")
    public ResponseEntity<List<Recomendaciones>> obtenerRecomendaciones(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(recomendacionesService.listarRecomendacionesPorRecomendacion(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readRecomendacionesPersona/{id}")
    public ResponseEntity<List<Recomendaciones>> obtenerRecomendacionesPersona(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(recomendacionesService.listarRecomendacionesPorPersona(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Recomendaciones> actualizarUsuario(@PathVariable Long id, @RequestBody Recomendaciones obj) {
        Recomendaciones fndObj = recomendacionesService.findById(id);
        if (fndObj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                fndObj.setPrimer_nombre(obj.getPrimer_nombre());
                fndObj.setSegundo_nombre(obj.getSegundo_nombre());
                fndObj.setPrimer_apellido(obj.getPrimer_apellido());
                fndObj.setSegundo_apellido(obj.getSegundo_apellido());
                fndObj.setCorreo(obj.getCorreo());
                fndObj.setDocumentoRecomendacion(obj.getDocumentoRecomendacion());

                return new ResponseEntity<>(recomendacionesService.save(fndObj), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            recomendacionesService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar este registro");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
