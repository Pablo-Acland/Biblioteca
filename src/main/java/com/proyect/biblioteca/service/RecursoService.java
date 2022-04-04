package com.proyect.biblioteca.service;

import com.proyect.biblioteca.model.Recurso;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RecursoService {
    Flux<Recurso> findAll();

    Mono<Recurso> save(Recurso recurso);

    Mono<Recurso> delete(String id);

    Mono<Recurso> update(String id, Recurso recurso);

    Mono<Recurso> findById(String id);

    Mono<String> disponibilidad(@PathVariable("id") String id);

    Mono<String> confirmarDisponibilidad(Mono<Recurso> recurso);

    Mono<String> prestarUnRecurso(String id);

    Flux<Recurso> recomendadoTipoyArea(String tipo, String area);

    Mono<Object> devolverRecurso(String id);
}

