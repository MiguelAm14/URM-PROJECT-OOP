/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa_23130550_proyecto_04;

/**
 *
 * @author migue
 */
class Vehiculo {
    //atributos
    private String descripcion;
    private double distancia;
    private double aceleracion;
    private double tiempo;
    
    // constructor
    public Vehiculo() {
        descripcion = "No-Id";
        distancia = 0.0;
        aceleracion = 0.0;
        tiempo = 0.0;
    }
    
   // constructor parametrizado
    public Vehiculo(String descripcion, double distancia, double aceleracion, double tiempo) {
        this.descripcion = descripcion;
        this.distancia = distancia;
        this.aceleracion = aceleracion;
        this.tiempo = tiempo;
    }
    
    // metodos get
    public String getDescripcion() {
        return descripcion;
    }
    
    public double getDistancia() {
        return distancia;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public double getTiempo() {
        return tiempo;
    }
    
    // metodos set
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }
    
    // metodo toString
    @Override
    public String toString() {
        return "Vehiculo{" + "descripcion=" + descripcion + ", distancia=" + distancia + ", aceleracion=" + aceleracion + ", tiempo=" + tiempo + '}';
    }
    
    // metodo de proceso
    public double velocidadInicial() {
        return (distancia - 0.5 * aceleracion * Math.pow(tiempo,2)) / tiempo;
    }
}
