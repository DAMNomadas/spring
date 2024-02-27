package org.nomad.wanderer.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.nomad.wanderer.model.Ciudad;
import org.nomad.wanderer.model.Noticias;
import org.nomad.wanderer.model.ciudadDTO.AddCiudadRequest;
import org.nomad.wanderer.model.ciudadDTO.UpdateCiudadRequest;
import org.nomad.wanderer.model.dto.noticiasDTO.NoticiaRequestDTO;
import org.nomad.wanderer.model.puntuacionDTO.CiudadPuntuacionResponseDTO;
import org.nomad.wanderer.service.CiudadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Transactional
@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    @Autowired
    private CiudadServiceImpl service;

    @GetMapping
    public ResponseEntity<List<CiudadPuntuacionResponseDTO>> getAllPuntuaciones(){
        List<CiudadPuntuacionResponseDTO> list = service.getAllPuntuaciones();

        if (list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<CiudadPuntuacionResponseDTO> getCiudadPuntuacionByNombre(@PathVariable("nombre") String nombre){
        CiudadPuntuacionResponseDTO ciudadPuntuacion  = service.obtenerPuntuacionCiudad(nombre);

        if (ciudadPuntuacion == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(ciudadPuntuacion, HttpStatus.OK);
        }

    }

//    @PostMapping
//    public ResponseEntity<Ciudad> addCiudad(@Valid @RequestBody AddCiudadRequest ciudad){
//
//        Ciudad obj = service.addCiudad(ciudad);
//
//        if (obj == null) {
//            return new ResponseEntity<>(obj, HttpStatus.BAD_REQUEST);
//        }else{
//            return new ResponseEntity<>(obj, HttpStatus.CREATED);
//        }
//
//    }
    @Transactional
    @PostMapping
    public ResponseEntity<Ciudad> addCiudad(@Valid @RequestParam("imagenFile") MultipartFile imagenFile,
                                            @RequestParam("nombre") String nombre,
                                            @RequestParam("descripcion") String descripcion,
                                            @RequestParam("universalHealthcare") String universalHealthcareStr,
                                            @RequestParam("averageSalary") String averageSalaryStr,
                                            @RequestParam("pais") String pais,
                                            @RequestParam("video") String video,
                                            @RequestParam("latitud") String latitudStr,
                                            @RequestParam("longitud") String longitudStr) {

        boolean universalHealthcare = Boolean.parseBoolean(universalHealthcareStr);
        float averageSalary = Float.parseFloat(averageSalaryStr);
        float latitud = Float.parseFloat(latitudStr);
        float longitud = Float.parseFloat(longitudStr);
        AddCiudadRequest addCiudadRequestDTO = new AddCiudadRequest();
        addCiudadRequestDTO.setAverageSalary(averageSalary);
        addCiudadRequestDTO.setDescripcion(descripcion);
        addCiudadRequestDTO.setPais(pais);
        addCiudadRequestDTO.setNombre(nombre);
        addCiudadRequestDTO.setVideo(video);
        addCiudadRequestDTO.setUniversalHealthcare(universalHealthcare);
        addCiudadRequestDTO.setImagenFile(imagenFile);
        addCiudadRequestDTO.setLatitud(latitud);
        addCiudadRequestDTO.setLongitud(longitud);

        Ciudad obj = service.addCiudad(addCiudadRequestDTO);

        if (obj == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.CREATED);
        }
    }

    @PutMapping
    public ResponseEntity<Ciudad> modificarCiudad(@Valid @RequestBody UpdateCiudadRequest updateCiudadRequest){
        Ciudad obj = service.modificarCiudad(updateCiudadRequest);

        if (obj == null) {
            return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }

    }

    @Transactional
    @GetMapping("/imagen/{id}")
    public ResponseEntity<Resource> getCiudadImage(@PathVariable("id") int id) {
        Ciudad ciudad = service.getCiudadById(id);

        if (ciudad.getImagen() == null || ciudad.getImagen().length == 0) {
            return ResponseEntity.notFound().build();
        }

        ByteArrayResource resource = new ByteArrayResource(ciudad.getImagen());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentLength(ciudad.getImagen().length);
        headers.set("Content-Disposition", "attachment; filename=\"" + ciudad.getNombre() + ".jpg\"");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("image/jpeg"))
                .body(resource);
    }

}
