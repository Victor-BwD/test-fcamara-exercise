package com.victorbwd.desafiofcamara.controllers;

import com.victorbwd.desafiofcamara.domain.cars.Car;
import com.victorbwd.desafiofcamara.domain.cars.CarDTO;
import com.victorbwd.desafiofcamara.domain.establishment.Establishment;
import com.victorbwd.desafiofcamara.domain.establishment.EstablishmentDTO;
import com.victorbwd.desafiofcamara.services.CarService;
import com.victorbwd.desafiofcamara.services.EstablishmentService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/establishment")
public class EstablishmentController {
    private EstablishmentService establishmentService;

    public EstablishmentController(EstablishmentService establishmentService) {
        this.establishmentService = establishmentService;
    }

    @PostMapping
    public ResponseEntity<Establishment> insert(@RequestBody EstablishmentDTO establishmentData) {
        Establishment newEstablishment = this.establishmentService.insert(establishmentData);
        return ResponseEntity.ok().body(newEstablishment);
    }

    @GetMapping
    public ResponseEntity<List<Establishment>> getAll() {
        List<Establishment> establishments = this.establishmentService.getAll();
        return ResponseEntity.ok().body(establishments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Establishment> update(@PathVariable("id") String id, @RequestBody EstablishmentDTO establishmentData) {
        Establishment updateEstablishment = this.establishmentService.update(id, establishmentData);
        return ResponseEntity.ok().body(updateEstablishment);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Establishment> delete(@PathVariable("id") String id) {
        this.establishmentService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
