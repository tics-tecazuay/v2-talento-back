package com.ista.talento_humano.controller;

import com.ista.talento_humano.model.secondary.vperiodos;
import com.ista.talento_humano.services.secondary.VPeriodosService;
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
@RequestMapping("/talento/api/vPerido")
public class VPeriodosController {

    @Autowired
    VPeriodosService vPeriodosService;

    @GetMapping("/read")
    public ResponseEntity<List<vperiodos>> obtenerPeriodos() {
        try {
            return new ResponseEntity<>(vPeriodosService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<vperiodos> obtenerPeriodo(Long id) {
        try {
            return new ResponseEntity<>(vPeriodosService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
