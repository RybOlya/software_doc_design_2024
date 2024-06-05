package ua.lviv.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.service.AbstractService;

import java.util.List;

public abstract class AbstractController<T> {
    private final AbstractService<T> service;

    public AbstractController(AbstractService<T> service) {
        this.service = service;
    }

    @GetMapping
    public List<T> getAll() {
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<T> getById(final @PathVariable("id") Integer id) {
        T foundedEntity = service.getById(id);
        if (foundedEntity != null) {
            return new ResponseEntity<>(foundedEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public T create(@RequestBody T newEntity) {
        return service.saveToDatabase(newEntity);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<T> delete(@PathVariable("id") Integer id) {
        if (service.deleteById(id)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}