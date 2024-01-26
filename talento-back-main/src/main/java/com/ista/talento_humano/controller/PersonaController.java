package com.ista.talento_humano.controller;

import java.util.List;

import com.ista.talento_humano.model.primary.FichaCombinada;
import com.ista.talento_humano.model.primary.Horario;
import com.ista.talento_humano.services.primary.ServiceImpl.MiServicio;
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

import com.ista.talento_humano.model.primary.Persona;
import com.ista.talento_humano.services.primary.Service.PersonaService;

//@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@CrossOrigin(origins = { "http://localhost:3000/" })
@RestController
@RequestMapping("/talento/api/persona")
public class PersonaController {
    @Autowired
    PersonaService PersonaService;
    @Autowired
    MiServicio miServicio;

    @PostMapping("/create")
    public ResponseEntity<Persona> crear(@RequestBody Persona obj) {
        try {
            return new ResponseEntity<>(PersonaService.save(obj), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<Persona>> obtenerLista() {
        try {
            return new ResponseEntity<>(PersonaService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/combined/{id}")
    public ResponseEntity<FichaCombinada> obtenerInformacionCompleta(@PathVariable Long id) {
        try {
            FichaCombinada resultado = miServicio.obtenerInformacionCompleta(id);
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/combi/{cedula}")
    public ResponseEntity<FichaCombinada> obtenerInformacionSecretaria(@PathVariable String cedula) {
        Persona fndObj = PersonaService.findByCedula(cedula);
        if (fndObj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                FichaCombinada resultado = miServicio.obtenerInformacionCompleta(fndObj.getId_persona());
                return new ResponseEntity<>(resultado, HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }

    @GetMapping("/readPersona/{id}")
    public ResponseEntity<List<Persona>> obtenerPersona(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(PersonaService.listarPersona(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<Persona> actualizarUsuario(@PathVariable Long id, @RequestBody Persona obj) {
        Persona fndObj = PersonaService.findById(id);
        if (fndObj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                fndObj.setCedula(obj.getCedula());
                fndObj.setApellido_paterno(obj.getApellido_paterno());
                fndObj.setApellido_materno(obj.getApellido_materno());
                fndObj.setPrimer_nombre(obj.getPrimer_nombre());
                fndObj.setSegundo_nombre(obj.getSegundo_nombre());
                fndObj.setPais_natal(obj.getPais_natal());
                fndObj.setEdad(obj.getEdad());
                fndObj.setGenero(obj.getGenero());
                fndObj.setSexo(obj.getSexo());
                fndObj.setEstado_civil(obj.getEstado_civil());
                fndObj.setEtnia(obj.getEtnia());
                fndObj.setTipo_sangre(obj.getTipo_sangre());
                fndObj.setCelular(obj.getCelular());
                fndObj.setCorreo(obj.getCorreo());
                fndObj.setCorreo_institucional(obj.getCorreo_institucional());
                fndObj.setPais_residencia(obj.getPais_residencia());
                fndObj.setProvincia_residencia(obj.getProvincia_residencia());
                fndObj.setCanton_residencia(obj.getCanton_residencia());
                fndObj.setParroquia_residencia(obj.getParroquia_residencia());
                fndObj.setCalles(obj.getCalles());
                fndObj.setNumero_casa(obj.getNumero_casa());
                fndObj.setSector(obj.getSector());
                fndObj.setReferencia(obj.getReferencia());
                fndObj.setTelefono(obj.getTelefono());
                fndObj.setIdioma_raiz(obj.getIdioma_raiz());
                fndObj.setIdioma_secundario(obj.getIdioma_secundario());
                fndObj.setFoto(obj.getFoto());
                fndObj.setDiscapacidad(obj.getDiscapacidad());
                fndObj.setTipo_discapacidad(obj.getTipo_discapacidad());
                fndObj.setPorcentaje_discapacidad(obj.getPorcentaje_discapacidad());
                fndObj.setCarnet_conadis(obj.getCarnet_conadis());
                fndObj.setDocumentos_personales(obj.getDocumentos_personales());
                fndObj.setFoto_carnet(obj.getFoto_carnet());
                return new ResponseEntity<>(PersonaService.save(fndObj), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            PersonaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar este registro");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/cv_socioempleo")
    public ResponseEntity<String> obtenerCvEmpleado(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(PersonaService.obtenerCvEmpleado(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/mecanizado_iess")
    public ResponseEntity<String> obtenermecaiess(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(PersonaService.obtenerMecaiess(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/documentos_personales")
    public ResponseEntity<String> obtenerDocperso(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(PersonaService.obtenerDocpers(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @GetMapping("/{id}/foto_carnet")
//    public ResponseEntity<String> obtenerfoto(@PathVariable Long id) {
//        try {
//            return new ResponseEntity<>(PersonaService.obtenerCorreoInstitucional(id), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
