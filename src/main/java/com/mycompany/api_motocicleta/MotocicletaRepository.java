/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api_motocicleta;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class MotocicletaRepository {
    private final List<Motocicleta> baseDeDatos = new ArrayList<>();
	 private final List<String> authTokens = new ArrayList<>();

    
	 public Motocicleta save(Motocicleta motocicleta) {
		 baseDeDatos.add(motocicleta);
		 authTokens.add(motocicleta.getId());
		 return motocicleta;
		 }
		 public Motocicleta findById(String id) {
		 for (Motocicleta motocicleta : baseDeDatos) {
		 if (motocicleta.getId().equals(id)) {
		 return motocicleta;
		 }
		 }
		 return null;
		 }
		 public List<Motocicleta> findAll() {
		 return new ArrayList<>(baseDeDatos);
		 }
		 public void deleteById(String ID) {
		 for (int i = 0; i < baseDeDatos.size(); i++) {
		 if (baseDeDatos.get(i).getId().equals(ID)) {
		 baseDeDatos.remove(i);
		 return;
		 }
		 }
		 }
		 public Motocicleta update(Motocicleta motocicleta) {
			 for (int i = 0; i < baseDeDatos.size(); i++) {
			 if (baseDeDatos.get(i).getId().equals(motocicleta.getId())) {
			 baseDeDatos.set(i, motocicleta);
			 return motocicleta;
			 }
			 }
			 return null;
			 }
	public List<Motocicleta> buscarPorFiltros(String placaMotocicleta) {
		List<Motocicleta> resultado = new ArrayList<>();
	for (Motocicleta usuario : baseDeDatos) {
		boolean CoincideplacaMotocicleta = (placaMotocicleta == null ||
				usuario.getPlacaMotocicleta().contains(placaMotocicleta));
				 if (CoincideplacaMotocicleta) {
				 }
	  }
		return resultado;
	}
	public String findByAuthToken(String authToken) {
		for (String token : authTokens) {
		   if (token.equals(authToken)) {
			return "Autorizado";
		    }
		}
		return null;
	 }
    
}
