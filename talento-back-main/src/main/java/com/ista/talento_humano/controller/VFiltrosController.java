package com.ista.talento_humano.controller;

import com.ista.talento_humano.model.primary.VFiltros;
import com.ista.talento_humano.model.secondary.Vcarreras;
import com.ista.talento_humano.services.primary.Service.VFiltrosService;
import com.ista.talento_humano.services.secondary.VCarrerasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@CrossOrigin(origins = { "http://localhost:3000/" })
@RestController
@RequestMapping("/talento/api/vFiltros")
public class VFiltrosController {

    @Autowired
    VFiltrosService filtrosService;

    @GetMapping("/read")
    public ResponseEntity<List<VFiltros>> obtenerFiltro() {
        try {
            return new ResponseEntity<>(filtrosService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<VFiltros> obtenerInformacion(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(filtrosService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
