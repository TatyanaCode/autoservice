package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.AbstractService;

import java.util.List;

import static com.google.common.net.HttpHeaders.AUTHORIZATION;

public class AbstractController<T> {

    @Autowired
    AbstractService<T> service;

    @GetMapping
    public ResponseEntity<List<T>> getAll(@RequestHeader(AUTHORIZATION) String token) {
        return ResponseEntity.ok(service.getAll(token));
    }

    @PostMapping
    public ResponseEntity<Boolean> insert(@RequestHeader(AUTHORIZATION) String token, @RequestBody T body) {
        return ResponseEntity.ok(service.insert(token, body));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateById(@RequestHeader(AUTHORIZATION) String token, @PathVariable Long id, @RequestBody T body) {
        return ResponseEntity.ok(service.updateById(token, id, body));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@RequestHeader(AUTHORIZATION) String token, @PathVariable Long id) {
        return ResponseEntity.ok(service.delete(token, id));
    }

}
