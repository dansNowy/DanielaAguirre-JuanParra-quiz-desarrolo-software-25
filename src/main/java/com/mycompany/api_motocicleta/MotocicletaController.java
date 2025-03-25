/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api_motocicleta;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/motocicletas")
public class MotocicletaController {

	private final MotocicletaService motocicletaService;
	 @Autowired
	 public MotocicletaController(MotocicletaService motocicletaService) {
	 this.motocicletaService = motocicletaService;
	 }
	 @GetMapping
	 public ResponseEntity<List<Motocicleta>> getAllMotocicletas() {
		 System.out.print("--------------------------");
	 List<Motocicleta> motocicletas = motocicletaService.findAll();
	 return new ResponseEntity<>(motocicletas, HttpStatus.OK);
	 }
	 @GetMapping("/{id}")
	 public ResponseEntity<Motocicleta> getMotocicletaById(@PathVariable String ID) {
	 Motocicleta motocicleta = motocicletaService.findById(ID);
	 if (motocicleta != null) {
	 return new ResponseEntity<>(motocicleta, HttpStatus.OK);
	 } else {
	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	 }
	 @PostMapping
	 public ResponseEntity<Motocicleta> createMotocicleta(@RequestBody Motocicleta motocicleta) {
	 Motocicleta newMotocicleta = motocicletaService.save(motocicleta);
	 return new ResponseEntity<>(newMotocicleta, HttpStatus.CREATED);
	 }
	 @PutMapping("/{id}")
	 public ResponseEntity<Motocicleta> updateMotocicleta(@PathVariable String ID,
	@RequestBody Motocicleta motocicleta) {
	 Motocicleta existingMotocicleta = motocicletaService.findById(ID);
	 if (existingMotocicleta != null) {
	 motocicleta.setId(ID);
	 Motocicleta updatedMotocicleta = motocicletaService.update(motocicleta);
	 return new ResponseEntity<>(updatedMotocicleta, HttpStatus.OK);
	 } else {
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 }
		 @DeleteMapping("/{id}")
		 public ResponseEntity<Void> deleteMotocicleta(@PathVariable String ID) {
		 Motocicleta existingMotocicleta = motocicletaService.findById(ID);
		 if (existingMotocicleta != null) {
		 motocicletaService.deleteById(ID);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 } else {
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 }
		 @GetMapping("/buscar")
		 public ResponseEntity<List<Motocicleta>> buscarMotocicleta(@RequestParam String
		placa)
		{
			 System.out.print("--------------------------");
		 List<Motocicleta> motocicletas = motocicletaService.buscarPorFiltros(placa);
		 return new ResponseEntity<>(motocicletas, HttpStatus.OK);
		 }
		 @GetMapping("/auth")
		 public ResponseEntity<String> getUserByToken(@RequestHeader("Authorization")
		String authToken) {
		 String motocicleta = motocicletaService.findByAuthToken(authToken);
		 if (motocicleta != null) {
		 return new ResponseEntity<>(motocicleta, HttpStatus.OK);
		 } else {
		 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		 }
		 }

	
	
	
}
