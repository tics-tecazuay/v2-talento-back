package com.ista.talento_humano.controller;

import java.util.List;

import com.ista.talento_humano.model.primary.Capacitaciones;
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

import com.ista.talento_humano.model.primary.CargaFamiliar;
import com.ista.talento_humano.services.primary.Service.CargaFamiliarService;

//@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@CrossOrigin(origins = { "http://localhost:3000/" })
@RestController
@RequestMapping("/talento/api/CargaFamiliar")
public class CargaFamiliarController {

	@Autowired
	CargaFamiliarService CargaFamiliarService;
	
	@PostMapping("/create")
	public ResponseEntity<CargaFamiliar> crear(@RequestBody CargaFamiliar obj) {
		try {
			return new ResponseEntity<>(CargaFamiliarService.save(obj), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/read")
	public ResponseEntity<List<CargaFamiliar>> obtenerLista() {
		try {
			return new ResponseEntity<>(CargaFamiliarService.findByAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/readCarga/{id}")
	public ResponseEntity<List<CargaFamiliar>> obtenerCargaFamiliar(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(CargaFamiliarService.listarCargaFamiliarPorCarga(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/readCargaPersona/{id}")
	public ResponseEntity<List<CargaFamiliar>> obtenerCargaFamiliarPersona(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(CargaFamiliarService.listarCargaFamiliarPorPersona(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CargaFamiliar> actualizarUsuario(@PathVariable Long id, @RequestBody CargaFamiliar obj) {
		CargaFamiliar fndObj = CargaFamiliarService.findById(id);
		if (fndObj == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				fndObj.setCedula(obj.getCedula());
				fndObj.setNombre_pariente(obj.getNombre_pariente());
				fndObj.setApellido_pariente(obj.getApellido_pariente());
				fndObj.setFecha_nacimiento(obj.getFecha_nacimiento());
				fndObj.setEdad(obj.getEdad());
				fndObj.setEvidencia(obj.getEvidencia());				
				return new ResponseEntity<>(CargaFamiliarService.save(fndObj), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {

		try {
			CargaFamiliarService.delete(id);
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
			return new ResponseEntity<>(CargaFamiliarService.obtenerEvidencia(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
