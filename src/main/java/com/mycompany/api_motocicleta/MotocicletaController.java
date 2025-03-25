/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api_motocicleta;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/motocicletas")
public class MotocicletaController {

    private List<Motocicleta> motocicleta = new ArrayList<>();

    // Obtener todas las motocicletas
    @GetMapping
    public List<Motocicleta> getAllMotocicletas() {
        return motocicleta;
    }

    // Crear una nueva motocicleta
    @PostMapping
    public Motocicleta createMotocicleta(@RequestBody Motocicleta nuevaMotocicleta) {
        motocicleta.add(nuevaMotocicleta);
        return nuevaMotocicleta;
    }

    // Actualizar una motocicleta por su ID
    @PutMapping("/{id}")
    public Motocicleta updateMotocicleta(@PathVariable String ID, @RequestBody Motocicleta updatedMotocicleta) {
        for (int i = 0; i < motocicleta.size(); i++) {
            if (motocicleta.get(i).getId().equals(ID)) {
                motocicleta.set(i, updatedMotocicleta);
                return updatedMotocicleta;
            }
        }
        throw new NoSuchElementException("Motocicleta no encontrada");
    }

    // Eliminar una motocicleta por su ID
    @DeleteMapping("/{id}")
    public String deleteMotocicleta(@PathVariable String ID) {
        motocicleta.removeIf(m -> m.getId().equals(ID));
        return "Motocicleta eliminada";
    }

    // Buscar una motocicleta mediante la placa
    @GetMapping("/buscar/{placa}")
    public Motocicleta getMotocicletaByPlaca(@PathVariable String placa) {
        return motocicleta.stream()
                .filter(m -> m.getPlacaMotocicleta().equalsIgnoreCase(placa))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Motocicleta no encontrada"));
    }

    // Obtener todas las motocicletas que tengan un cilindraje en particular
    @GetMapping("/cilindraje/{cilindraje}")
    public List<Motocicleta> getMotocicletasByCilindraje(@PathVariable int cilindraje) {
        List<Motocicleta> resultado = new ArrayList<>();
        for (Motocicleta m : motocicleta) {
            if (m.getCilindrajeMotocicleta() == cilindraje) {
                resultado.add(m);
            }
        }
        return resultado;
    }
}
