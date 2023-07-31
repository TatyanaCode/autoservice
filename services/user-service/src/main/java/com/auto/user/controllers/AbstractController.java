package com.auto.user.controllers;

import com.auto.user.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * author danilova.tatyana 31.07.2023
 */
public abstract class AbstractController<T> {
    @Autowired
    AbstractService<T> service;

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    public ResponseEntity<Boolean> insert(T body) {
        return ResponseEntity.ok(service.insert(body));
    }

    @PutMapping
    public ResponseEntity<Boolean> update(T body) {
        return ResponseEntity.ok(service.update(body));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Long id) {
        return ResponseEntity.ok(service.updateById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

}
