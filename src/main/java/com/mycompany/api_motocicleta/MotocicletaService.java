/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api_motocicleta;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class MotocicletaService {
    private final MotocicletaRepository motocicletaRepository;
	 @Autowired
	 public MotocicletaService(MotocicletaRepository motocicletaRepository) {
	 this.motocicletaRepository = motocicletaRepository;
	 initSampleData();
	 }
         
	 private void initSampleData() {
	 Motocicleta Yamaha = new Motocicleta("YZ","TBI67G",125,5000000,"Rojo");
	 
	 save(Yamaha);
	 
	 }
	 public Motocicleta save(Motocicleta motocicleta) {
	 return motocicletaRepository.save(motocicleta);
	 }
	 public Motocicleta findById(String ID) {
	 return motocicletaRepository.findById(ID);
	 }
	 public List<Motocicleta> findAll() {
	 return motocicletaRepository.findAll();
	 }
	 public Motocicleta update(Motocicleta motocicleta) {
	 return motocicletaRepository.update(motocicleta);
	 }
	 public void deleteById(String ID) {
		 motocicletaRepository.deleteById(ID);
		 }
     public List<Motocicleta> buscarPorFiltros(String placaMotocicleta) {
		 return motocicletaRepository.buscarPorFiltros(placaMotocicleta);
	}
	public String findByAuthToken(String authToken) {
		 return motocicletaRepository.findByAuthToken(authToken);
	}    
    
}
