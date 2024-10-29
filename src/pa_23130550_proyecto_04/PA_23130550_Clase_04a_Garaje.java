/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa_23130550_proyecto_04;

import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author migue
 */
class Garaje {
    private Vehiculo [] lista = null;
    
    public Garaje() {
        lista = new Vehiculo[5]; // creamos un arreglo de 5 referencias nulas
    }   
    
    public Garaje(int n) {
        lista = new Vehiculo[n];  // creamos un areglo de n referencias nulas
    }
    
    public Garaje(JTable tabla) { // constructor que crea un garaje a partir de una tabla de datos
        lista = new Vehiculo[tabla.getRowCount()];
        for(int r=0; r < tabla.getRowCount(); r++) {
            Vehiculo vehiculo = new Vehiculo();
            
            vehiculo.setDescripcion(tabla.getValueAt(r,0) + "");
            vehiculo.setDistancia(Double.parseDouble(tabla.getValueAt(r,1) + ""));
            vehiculo.setAceleracion(Double.parseDouble(tabla.getValueAt(r,2) + ""));
            vehiculo.setTiempo(Double.parseDouble(tabla.getValueAt(r,3) + ""));
            // asignamos el objeto en la posicion r del arreglo       
            lista[r] = vehiculo;
        }    
    }
    
    public Vehiculo getVehiculo(int posicion) {
        if(posicion >= 0 && posicion < lista.length)
            return lista[posicion];
        else
            return null;
    }
    
    // metodo que devuelve una lista de vehiculos
    public Vehiculo[] getLista() {
        return lista;
    }
    
    public void setVehiculo(Vehiculo v, int posicion) {
        if(posicion >= 0 && posicion < lista.length)
            lista[posicion] = v;
    }

    // ordena los vehiculos alfabeticamente segun su descripcion
    public void alfabetico() {
        for(int i=0; i < lista.length - 1; i++)
            for(int j=i+1; j < lista.length; j++) {
                if(lista[i].getDescripcion().compareToIgnoreCase(lista[j].getDescripcion()) > 0) {
                    Vehiculo aux = lista[i];
                    lista[i] = lista[j];
                    lista[j] = aux;
                }
            }
    }  
    // Método que muestra la información de los vehículos en una tabla y actualiza una etiqueta con el promedio de la velocidad inicial.
    public void mostrar(JTable tabla, JLabel etiqueta) {
        DecimalFormat formato = new DecimalFormat("#,###,##0.00");
        
        double total = 0.0;

        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        modelo.setRowCount(lista.length);
        
        for(int r=0; r < tabla.getRowCount(); r++) {
            tabla.setValueAt(lista[r].getDescripcion(), r, 0);
            tabla.setValueAt(lista[r].getDistancia(), r, 1);
            tabla.setValueAt(lista[r].getAceleracion(), r, 2);
            tabla.setValueAt(lista[r].getTiempo(), r, 3); 
           
            tabla.setValueAt(formato.format(lista[r].velocidadInicial()), r, 4);
            
            total += lista[r].velocidadInicial();
        }
        etiqueta.setText(formato.format(total / lista.length));
    }
    
    
    
}
