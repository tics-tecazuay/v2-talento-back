package com.ista.talento_humano.controller;

import com.ista.talento_humano.model.secondary.Vdocentespppall;
import com.ista.talento_humano.services.secondary.VDocentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@CrossOrigin(origins = { "http://localhost:3000/" })
@RestController
@RequestMapping("/talento/api/vDocente")
public class VDocentesController {


    @Autowired
    VDocentesService docentesService;

    @GetMapping("/read")
    public ResponseEntity<List<Vdocentespppall>> obtenerDocentes() {
        try {
            return new ResponseEntity<>(docentesService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Vdocentespppall> obtenerDocente(Long id) {
        try {
            return new ResponseEntity<>(docentesService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
