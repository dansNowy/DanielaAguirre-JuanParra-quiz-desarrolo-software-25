/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.api_motocicleta;

import java.util.UUID;

/**
 *
 * @author usuario
 */
public class Motocicleta {

    private String ID;
    private String MarcaMotocicleta;
private String placaMotocicleta;
    private int cilindrajeMotocicleta;
    private double precioMotocicleta;
    private String colorMotocicleta;

    // Constructor
    public Motocicleta(String marcaMotocicleta, String placaMotocicleta, int cilindrajeMotocicleta, double precioMotocicleta,String colorMotocicleta) {
        this.ID = UUID.randomUUID().toString(); // Generar ID aleatorio
        this.MarcaMotocicleta = marcaMotocicleta;
        this.placaMotocicleta = placaMotocicleta;
        this.cilindrajeMotocicleta = cilindrajeMotocicleta;
        this.precioMotocicleta = precioMotocicleta;
        this.colorMotocicleta = colorMotocicleta;
    }

    // Getters y Setters
    public String getId() {
        return ID;
    }

    public String getMarcaMotocicleta() {
        return MarcaMotocicleta;
    }

    public void setMarcaMotocicleta(String marcaMotocicleta) {
        this.MarcaMotocicleta = marcaMotocicleta;
    }

    public String getPlacaMotocicleta() {
        return placaMotocicleta;
    }

    public void setPlacaMotocicleta(String placaMotocicleta) {
        this.placaMotocicleta = placaMotocicleta;
    }

    public int getCilindrajeMotocicleta() {
        return cilindrajeMotocicleta;
    }

    public void setCilindrajeMotocicleta(int cilindrajeMotocicleta) {
        this.cilindrajeMotocicleta = cilindrajeMotocicleta;
    }

    public double getPrecioMotocicleta() {
        return precioMotocicleta;
    }

    public void setPrecioMotocicleta(double precioMotocicleta) {
        this.precioMotocicleta = precioMotocicleta;
    }

    public String getColorMotocicleta() {
        return colorMotocicleta;
    }

    public void setColorMotocicleta(String colorMotocicleta) {
        this.colorMotocicleta = colorMotocicleta;
    }

    // Método para mostrar información
    @Override
    public String toString() {
        return "Motocicleta{" +
                "id='" + ID + '\'' +
                ", marca='" + MarcaMotocicleta + '\'' +
                ", placa='" + placaMotocicleta + '\'' +
                ", cilindraje=" + cilindrajeMotocicleta +
                ", precio=" + precioMotocicleta +
                ", color='" + colorMotocicleta + '\'' +
                '}';
    }    
    
}
