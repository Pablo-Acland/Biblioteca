package com.proyect.biblioteca.controller;

import com.proyect.biblioteca.model.Recurso;
import com.proyect.biblioteca.service.Impl.RecursoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("*")
@CrossOrigin(origins = "http://localhost:8080")

public class RecursoController {

    @Autowired
    RecursoServiceImpl recursoService;

    @GetMapping(value = "/recursos")
    private Flux<Recurso> allRecursos() {
        return this.recursoService.findAll();
    }

    @PostMapping(value = "/recurso")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Recurso> saveRecurso(@RequestBody Recurso recurso) {
        return this.recursoService.save(recurso);
    }

    @DeleteMapping("/delete/{id}")
    private Mono<ResponseEntity<Recurso>> deleteRecurso(@PathVariable("id") String id) {
        return this.recursoService.delete(id)
                .flatMap(recurso -> Mono.just(ResponseEntity.ok(recurso)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping(value = "/recurso/edit/{id}")
    private Mono<ResponseEntity<Recurso>> updateCliente(@PathVariable("id") String id, @RequestBody Recurso recurso) {
        return this.recursoService.update(id, recurso)
                .flatMap(recurso1 -> Mono.just(ResponseEntity.ok(recurso1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping(value = "/recurso/search/{id}")
    private Mono<Recurso> RecursoByID(@PathVariable("id") String id) {
        return this.recursoService.findById(id);
    }


    @GetMapping(value = "/recurso/isDisponible/{id}")
    public Mono<String> Disponile(@PathVariable("id") String id){
        var isDisponible = recursoService.disponibilidad(id);
        if(isDisponible == null){
            return isDisponible;
        }
        return isDisponible;
    }

    @PutMapping("/recurso/prestar/{id}")
    public Mono prestarRecurso(@PathVariable("id") String id){
        return recursoService.prestarUnRecurso(id);
    }

    @GetMapping(value = "/recurso/recomendar/{tipo}/{area}")
    private Flux<Recurso> RecomendarTipoYArea(@PathVariable("tipo") String tipo, @PathVariable("area") String area) {
        return this.recursoService.recomendadoTipoyArea(tipo,area);
    }

    @PutMapping("/recurso/devolver/{id}")
    public Mono devolverRecurso(@PathVariable("id") String id){
        return recursoService.devolverRecurso(id);
    }


}
