package com.ista.talento_humano.controller;

import java.util.List;

import com.ista.talento_humano.model.primary.Horario;
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

import com.ista.talento_humano.model.primary.InstruccionFormal;
import com.ista.talento_humano.services.primary.Service.InstruccionFormalService;

//@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@CrossOrigin(origins = { "http://localhost:3000/" })
@RestController
@RequestMapping("/talento/api/InstruccionFormal")
public class InstruccionFormalController {

    @Autowired
    InstruccionFormalService InstruccionFormalService;

    @PostMapping("/create")
    public ResponseEntity<InstruccionFormal> crear(@RequestBody InstruccionFormal obj) {
        try {
            return new ResponseEntity<>(InstruccionFormalService.save(obj), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<InstruccionFormal>> obtenerLista() {
        try {
            return new ResponseEntity<>(InstruccionFormalService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readInstruccionFormal/{id}")
    public ResponseEntity<List<InstruccionFormal>> obtenerInstruccionFormal(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(InstruccionFormalService.listarInstruccionFormalPorIntruccion(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readInstruccionFormalPersona/{id}")
    public ResponseEntity<List<InstruccionFormal>> obtenerInstruccionFormalPersona(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(InstruccionFormalService.listarInstruccionFormalPorPersona(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<InstruccionFormal> actualizarUsuario(@PathVariable Long id, @RequestBody InstruccionFormal obj) {
        InstruccionFormal fndObj = InstruccionFormalService.findById(id);
        if (fndObj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                fndObj.setNivelInstruccion(obj.getNivelInstruccion());
                fndObj.setInstitucionEducativa(obj.getInstitucionEducativa());
                fndObj.setTituloObtenido(obj.getTituloObtenido());
                fndObj.setNum_SenecytRegistro(obj.getNum_SenecytRegistro());
                fndObj.setTiempoEstudio(obj.getTiempoEstudio());
                fndObj.setAnioGraduacion(obj.getAnioGraduacion());
                fndObj.setAreaEstudios(obj.getAreaEstudios());
                fndObj.setTitulo(obj.getTitulo());
                return new ResponseEntity<>(InstruccionFormalService.save(fndObj), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            InstruccionFormalService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar este registro");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/titulo")
    public ResponseEntity<String> obtenerTitulo(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(InstruccionFormalService.obtenerTitulo(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
