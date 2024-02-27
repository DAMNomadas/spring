package org.nomad.wanderer.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.nomad.wanderer.model.Noticias;
import org.nomad.wanderer.model.dto.noticiasDTO.NoticiaRequestDTO;
import org.nomad.wanderer.model.dto.noticiasDTO.NoticiaResponseDTO;
import org.nomad.wanderer.service.INoticasService;
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
@RequestMapping("/noticias")
public class NoticiasController {

    @Autowired
    private INoticasService service;

    @GetMapping
    public ResponseEntity<List<NoticiaResponseDTO>> getAllNoticias(){
        List<NoticiaResponseDTO> lista = service.getAllNoticias();

        if (lista.isEmpty()) {
            return new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }

    @GetMapping("/ciudad/{nombre}")
    public ResponseEntity<List<NoticiaResponseDTO>> getNoticiasByCiudad(@PathVariable("nombre") String ciudad){

        List<NoticiaResponseDTO> lista = service.getNoticiasByCiudad(ciudad);

        if (lista.isEmpty()) {
            return new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<NoticiaResponseDTO>> getNoticiasByCategoria(@PathVariable("categoria") String categoria){
        List<NoticiaResponseDTO> lista = service.getNoticasByCategoria(categoria);

        if (lista.isEmpty()) {
            return new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }

    }
    @GetMapping("/filter")
    public ResponseEntity<List<NoticiaResponseDTO>> getNoticiasByCategoriaAndCiudad(@RequestParam(value = "categoria") String categoria,
                                                                                    @RequestParam(value = "ciudad")String ciudad){
        List<NoticiaResponseDTO> lista = service.getNoticasByCategoriaAndCiudad(categoria, ciudad);

        if (lista.isEmpty()) {
            return new ResponseEntity<>(lista, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }

//    @PostMapping
//    public ResponseEntity<Noticias> addNoticia(@Valid @RequestBody NoticiaRequestDTO noticiaRequestDTO){
//
//        Noticias obj = service.addNoticia(noticiaRequestDTO);
//
//        if (obj == null) {
//            return new ResponseEntity<>(obj, HttpStatus.NO_CONTENT);
//        }else{
//            return new ResponseEntity<>(obj, HttpStatus.CREATED);
//        }
//
//    }
    @PostMapping
    public ResponseEntity<Noticias> addNoticia(@Valid @RequestParam("imagenFile") MultipartFile imagenFile, @RequestParam("titulo") String titulo, @RequestParam("texto") String texto, @RequestParam("nombre") String nombre, @RequestParam("categoria") String categoria){

        NoticiaRequestDTO noticiaRequestDTO = new NoticiaRequestDTO();
        noticiaRequestDTO.setTitulo(titulo);
        noticiaRequestDTO.setTexto(texto);
        noticiaRequestDTO.setNombre(nombre);
        noticiaRequestDTO.setCategoria(categoria);
        noticiaRequestDTO.setImagenFile(imagenFile);
        System.out.println("Título: " + noticiaRequestDTO.getTitulo());
        System.out.println("Texto: " + noticiaRequestDTO.getTexto());
        System.out.println("Nombre: " + noticiaRequestDTO.getNombre());
        System.out.println("Categoría: " + noticiaRequestDTO.getCategoria());
        //System.out.println("ImagenFile: " + noticiaRequestDTO.getImagenFile());


        Noticias obj = service.addNoticia(noticiaRequestDTO);

        if (obj == null) {
            return new ResponseEntity<>(obj, HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNoticia(@PathVariable(value = "id")Integer id){
        service.eliminarNotica(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @GetMapping("/imagen/{id}")
//    public ResponseEntity<Resource> getNoticiaImage(@PathVariable("id") int id) {
//        Noticias noticia = service.getNoticiaById(id); // Implementa este método en tu servicio
//
//        ByteArrayResource resource = new ByteArrayResource(noticia.getImagen());
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentLength(noticia.getImagen().length);
//        headers.set("Content-Disposition", "attachment; filename=" + noticia.getTitulo() + ".jpg"); // Cambia la extensión de acuerdo al formato de la imagen
//
//        return ResponseEntity.ok()
//                .headers(headers)
//                .contentType(MediaType.IMAGE_JPEG) // Cambia a IMAGE_PNG si es necesario
//                .body(resource);
//    }
    @Transactional
    @GetMapping("/imagen/{id}")
    public ResponseEntity<Resource> getNoticiaImage(@PathVariable("id") int id) {
        Noticias noticia = service.getNoticiaById(id); // Asume que este método devuelve la noticia correctamente

        // Verifica si la noticia tiene una imagen asociada
        if (noticia.getImagen() == null || noticia.getImagen().length == 0) {
            // Aquí puedes decidir cómo manejar los casos sin imagen.
            // Por ejemplo, podrías devolver un código de estado 404 o una imagen predeterminada.
            return ResponseEntity.notFound().build();
            // O return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        ByteArrayResource resource = new ByteArrayResource(noticia.getImagen());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentLength(noticia.getImagen().length);
        headers.set("Content-Disposition", "attachment; filename=\"" + noticia.getTitulo() + ".jpg\""); // Asegúrate de ajustar la extensión de acuerdo al formato real de la imagen

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("image/jpeg")) // Usa "image/png" o el tipo MIME correcto según el formato de tu imagen
                .body(resource);
    }

}
