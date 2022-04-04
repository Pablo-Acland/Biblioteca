package com.proyect.biblioteca.repository;

import com.proyect.biblioteca.model.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface RecursosRepository extends ReactiveMongoRepository<Recurso, String> {

    Flux<Recurso> findByTipo(String tipo);

}
