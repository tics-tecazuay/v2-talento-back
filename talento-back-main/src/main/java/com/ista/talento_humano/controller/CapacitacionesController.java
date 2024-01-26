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

import com.ista.talento_humano.model.primary.Capacitaciones;
import com.ista.talento_humano.services.primary.Service.CapacitacionesService;

//@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@CrossOrigin(origins = { "http://localhost:3000/" })
@RestController
@RequestMapping("/talento/api/capacitaciones")
public class CapacitacionesController {

	@Autowired
	CapacitacionesService capacitacionesService;
	
	@PostMapping("/create")
	public ResponseEntity<Capacitaciones> crear(@RequestBody Capacitaciones obj) {
		try {
			return new ResponseEntity<>(capacitacionesService.save(obj), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/read")
	public ResponseEntity<List<Capacitaciones>> obtenerLista() {
		try {
			return new ResponseEntity<>(capacitacionesService.findByAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/readCapacitaciones/{id}")
	public ResponseEntity<List<Capacitaciones>> obtenerCapacitaciones(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(capacitacionesService.listarCapacitacionesPorCapacitaciones(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/readCapacitacionPersona/{id}")
	public ResponseEntity<List<Capacitaciones>> obtenerCapacitacionesPersona(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(capacitacionesService.listarCapacitacionesPorPersona(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Capacitaciones> actualizarUsuario(@PathVariable Long id, @RequestBody Capacitaciones obj) {
		Capacitaciones fndObj = capacitacionesService.findById(id);
		if (fndObj == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				fndObj.setInstitucion(obj.getInstitucion());
				fndObj.setTipo_evento(obj.getTipo_evento());
				fndObj.setNombre_evento(obj.getNombre_evento());
				fndObj.setArea_estudios(obj.getArea_estudios());
				fndObj.setTipo_certificado(obj.getTipo_certificado());
				fndObj.setFecha_inicio(obj.getFecha_inicio());
				fndObj.setFecha_fin(obj.getFecha_fin());
				fndObj.setNumero_dias(obj.getNumero_dias());
				fndObj.setCantidad_horas(obj.getCantidad_horas());
				fndObj.setEvidencia(obj.getEvidencia());				
				return new ResponseEntity<>(capacitacionesService.save(fndObj), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {

		try {
			capacitacionesService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar este registro");
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}/evidencia")
	public ResponseEntity<String> obtenerDocperso(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(capacitacionesService.obtenerEvidencia(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
