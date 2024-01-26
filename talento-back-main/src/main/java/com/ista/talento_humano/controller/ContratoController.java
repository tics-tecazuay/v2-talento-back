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

import com.ista.talento_humano.model.primary.Contrato;
import com.ista.talento_humano.services.primary.Service.ContratoService;

//@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@CrossOrigin(origins = { "http://localhost:3000/" })
@RestController
@RequestMapping("/talento/api/contrato")
public class ContratoController {

    @Autowired
    ContratoService ContratoService;

    @PostMapping("/create")
    public ResponseEntity<Contrato> crear(@RequestBody Contrato obj) {
        try {

            return new ResponseEntity<>(ContratoService.save(obj), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<Contrato>> obtenerLista() {
        try {
            return new ResponseEntity<>(ContratoService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readContrato/{id}")
    public ResponseEntity<List<Contrato>> obtenerContrato(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(ContratoService.listarContratosPorContrato(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readContratoPersona/{id}")
    public ResponseEntity<List<Contrato>> obtenerContratoPersona(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(ContratoService.listarContratosPorPersona(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Contrato> actualizarUsuario(@PathVariable Long id, @RequestBody Contrato obj) {
        Contrato fndObj = ContratoService.findById(id);
        if (fndObj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                fndObj.setFecha_inicio(obj.getFecha_inicio());
                fndObj.setFecha_fin(obj.getFecha_fin());
                fndObj.setAnio_duracion(obj.getAnio_duracion());
                fndObj.setHoras_diarias(obj.getHoras_diarias());
                fndObj.setCargo(obj.getCargo());
                fndObj.setSalario(obj.getSalario());
                fndObj.setEvidencia(obj.getEvidencia());
                fndObj.setTiempo_dedicacion(obj.getTiempo_dedicacion());
                fndObj.setContrato_vigente(obj.getContrato_vigente());
                fndObj.setSalario_publico(obj.getSalario_publico());
                return new ResponseEntity<>(ContratoService.save(fndObj), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            ContratoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar este registro");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/evidencia")
    public ResponseEntity<String> obtenerEvidencia(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(ContratoService.obtenerEvidencia(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
