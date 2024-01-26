package com.ista.talento_humano.controller;

import com.ista.talento_humano.model.primary.Habilidades;
import com.ista.talento_humano.model.primary.Horario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@CrossOrigin(origins = { "http://localhost:3000/" })
@RestController
@RequestMapping("/talento/api/horario")
public class HorarioController {
    @Autowired
    com.ista.talento_humano.services.primary.Service.HorarioService HorarioService;

    @PostMapping("/create")
    public ResponseEntity<Horario> crear(@RequestBody Horario obj) {
        try {

            return new ResponseEntity<>(HorarioService.save(obj), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<Horario>> obtenerLista() {
        try {
            return new ResponseEntity<>(HorarioService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readHorario/{id}")
    public ResponseEntity<List<Horario>> obtenerHorario(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(HorarioService.listarHorariosPorHorario(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readHorarioPersona/{id}")
    public ResponseEntity<List<Horario>> obtenerHorarioPersona(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(HorarioService.listarHorariosPorPersona(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Horario> actualizarHorario(@PathVariable Long id, @RequestBody Horario obj) {
        Horario fndObj = HorarioService.findById(id);
        if (fndObj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {

                fndObj.setCarreraHorario(obj.getCarreraHorario());
                fndObj.setJornadaHorario(obj.getJornadaHorario());
                fndObj.setHorasSemanalesHorario(obj.getHorasSemanalesHorario());
                fndObj.setPersona(obj.getPersona());
                fndObj.setPeriodoAcademico(obj.getPeriodoAcademico());
                fndObj.setDistributivo(obj.getDistributivo());
                return new ResponseEntity<>(HorarioService.save(fndObj), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            HorarioService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar este horario");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/distributivo")
    public ResponseEntity<String> obtenerDistributivo(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(HorarioService.obtenerDistributivo(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
